package com.example.demo.service;

import com.example.demo.entity.food.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    List<Category> list();

    Optional<Category> findId(int id);

    void save(Category category);

    void delete(int id);

    Optional<Category> findById(int id);

    void update(Category category);
}
