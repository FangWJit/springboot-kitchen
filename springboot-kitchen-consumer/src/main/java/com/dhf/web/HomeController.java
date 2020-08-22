package com.dhf.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dhf.exception.MyException;
import com.dhf.exception.NoUSerException;
import com.dhf.exception.PassException;
import com.dhf.model.User;
import com.dhf.model.UserData;
import com.dhf.service.UserDataService;
import com.dhf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/kitchen")
public class HomeController {

    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false)
    private UserService userService;

    @Reference(interfaceClass = UserDataService.class,version = "1.0.0",check = false)
    private UserDataService userDataService;

    @RequestMapping(value = "/{formName}")
    public String home(@PathVariable("formName") String formName){
        return formName;
    }

    @RequestMapping(value = "/decidelogin")
    public String decideLogin(HttpServletRequest request,Model model, String user_phone, String user_pass) throws MyException {

        System.out.println(user_phone+"---"+user_pass);

        User user = userService.selectByPhone(user_phone);
        if (null == user){
            throw new NoUSerException("用户不存在");
        }
        if (!user_pass.equals(user.getUserPass())){
            throw new PassException("密码错误");
        }

        request.getSession().setAttribute("link",user);

        return "index";
    }
    @RequestMapping(value = "/exit")
    public String exit(HttpServletRequest request){
        request.getSession().setAttribute("link",null);
        return "index";
    }

    @RequestMapping(value = "/registersu")
    public String register(User user){

        boolean b = userService.insertUser(user);

        UserData userData = new UserData();
        userData.setUserPhone(user.getUserPhone());
        userData.setUserName(user.getUserName());

        userDataService.insertUserDetail(userData);

        System.out.println(b);

        return "login";
    }


}
