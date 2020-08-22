package com.dhf.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dhf.dao.UserMapper;
import com.dhf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserService.class,version = "1.0.0",timeout = 15000)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectByPhone(String user_phone) {

        User user = userMapper.selectByPhone(user_phone);

        return user;
    }

    @Override
    public boolean insertUser(User user) {

        User user1 = userMapper.selectByPhone(user.getUserPhone());
        if (user1 == null) {
            userMapper.insertSelective(user);
            System.out.println("注册成功");
            return true;
        }
        return false;
    }

    @Override
    public void updataUserByPhone(User user) {

        userMapper.updateByPrimaryKeySelective(user);

    }
}
