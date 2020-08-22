package com.dhf.service;

import com.dhf.model.User;

public interface UserService {

    User selectByPhone(String user_phone);

    boolean insertUser(User user);

    void updataUserByPhone(User user);
}
