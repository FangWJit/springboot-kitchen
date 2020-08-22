package com.dhf.dao;

import com.dhf.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPhone(String user_phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}