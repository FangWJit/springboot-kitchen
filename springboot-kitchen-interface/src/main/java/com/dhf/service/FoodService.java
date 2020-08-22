package com.dhf.service;

import com.dhf.model.Food;

import java.util.ArrayList;
import java.util.HashMap;

public interface FoodService {

    HashMap<String, ArrayList<String>> selectFoodAll();
}
