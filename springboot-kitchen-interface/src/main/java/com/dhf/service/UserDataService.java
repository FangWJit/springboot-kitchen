package com.dhf.service;

import com.dhf.model.UserData;

public interface UserDataService {
    UserData selectUserData(String user_phone);

    boolean updateUserDetail(UserData userData);

    void insertUserDetail(UserData userData);
}
