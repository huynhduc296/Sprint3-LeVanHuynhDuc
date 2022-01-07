package com.example.demo.service;

import com.example.demo.entity.food.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodService {
    List<Food> list();

    Optional<Food> findById(int id);

    List<Food> findFoodCategory(int id);

    List<Food> sortFoodAToZ();

    void create(Food food);

    void update(Food food);

    List<Food> listTrend();

    void deleteFood(int id);
}
