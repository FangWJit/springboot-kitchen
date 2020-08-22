package com.dhf.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dhf.dao.UserDataMapper;
import com.dhf.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserDataService.class,version = "1.0.0",timeout = 150000)
public class UserDataServiceImpl implements UserDataService {
    
    @Autowired
    private UserDataMapper userDataMapper;
    
    @Override
    public UserData selectUserData(String user_phone) {

        UserData userData = userDataMapper.selectByPrimaryKey(user_phone);

        return userData;
    }

    @Override
    public boolean updateUserDetail(UserData userData) {
        int i = userDataMapper.updateByPrimaryKeySelective(userData);
        if (i!=0) return true;
        return false;
    }

    @Override
    public void insertUserDetail(UserData userData) {
        userDataMapper.insertSelective(userData);
    }
}
