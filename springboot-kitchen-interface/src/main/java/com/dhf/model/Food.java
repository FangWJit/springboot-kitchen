package com.dhf.model;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private Integer id;

    private String foodSort;

    private String foodName;

    private Integer typeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodSort() {
        return foodSort;
    }

    public void setFoodSort(String foodSort) {
        this.foodSort = foodSort;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(id, food.id) &&
                Objects.equals(foodSort, food.foodSort) &&
                Objects.equals(foodName, food.foodName) &&
                Objects.equals(typeId, food.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodSort, foodName, typeId);
    }
}