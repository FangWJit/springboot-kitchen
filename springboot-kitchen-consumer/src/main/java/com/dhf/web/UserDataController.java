package com.dhf.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.dhf.model.User;
import com.dhf.model.UserData;
import com.dhf.service.UserDataService;
import com.dhf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping(value = "/kitchen")
public class UserDataController {

    @Reference(interfaceClass = UserDataService.class,version = "1.0.0",check = false)
    private UserDataService userDataService;

    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false)
    private UserService userService;

    @RequestMapping(value = "/detail/{user_phone}")
    public String detail(Model model,@PathVariable("user_phone") String user_phone){

        UserData userData = userDataService.selectUserData(user_phone);

        model.addAttribute("userData",userData);

        return "userdetail";
    }
    
    @RequestMapping(value = "/changedetail")
    public String change(HttpServletRequest request,
                         Model model,
                         String userName,
                         Integer age,
                         String sex,
                         MultipartFile userPhoto)  {
        //获取图片的全名称
        String photo = userPhoto.getOriginalFilename();
        System.out.println(photo);
        //获取用户的唯一标识符  手机
        User user = (User) request.getSession().getAttribute("link");
        String userPhone = user.getUserPhone();
        //如果用户名改了 ，用户登录表信息也要更改
        if (!userName.equals(user.getUserName())){
            user.setUserName(userName);
            userService.updataUserByPhone(user);
        }
        //将用户信息保存到临时对象对象
        UserData userData = new UserData();

        userData.setUserPhone(userPhone);
        userData.setUserName(userName);
        userData.setAge(age);
        userData.setSex(sex);
        //判定如果头像没有修改
        if (photo != null && photo != "") {
            String fileName = "F:\\javawebDemo\\springboot-kitchen\\springboot-kitchen-consumer\\src\\main\\resources\\static\\head";
            File file = new File(fileName);
            if (!file.exists()) {
                file.mkdir();
            }
            InputStream is = null;
            OutputStream os = null;
            try {
                is = userPhoto.getInputStream();
                os = new FileOutputStream(file + "\\" + photo);
                byte[] bytes = new byte[1024];
                int leng = 0;
                while ((leng = is.read(bytes)) != -1) {
                    os.write(bytes, 0, leng);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                    if (os != null) os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            userData.setUserPhoto(photo);
        }
        //将新的数据进行替代
        userDataService.updateUserDetail(userData);
        //重新获取用户的全部信息
        UserData userData1 = userDataService.selectUserData(userPhone);
        model.addAttribute("userData",userData1);

        return "userdetail";
    }
}
