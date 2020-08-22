package com.dhf.dao;

import com.dhf.model.Food;

import java.util.ArrayList;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Food record);

    int insertSelective(Food record);

    ArrayList<String> selectByType(Integer id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

    ArrayList<Food> selectFoodAll();
}