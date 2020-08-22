package com.dhf.dao;

import com.dhf.model.UserData;

public interface UserDataMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserData record);

    int insertSelective(UserData record);

    UserData selectByPrimaryKey(String user_phone);

    int updateByPrimaryKeySelective(UserData record);

    int updateByPrimaryKey(UserData record);
}