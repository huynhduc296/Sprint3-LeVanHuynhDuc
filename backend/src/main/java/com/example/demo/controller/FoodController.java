package com.example.demo.controller;

import com.example.demo.dto.FoodDto;
import com.example.demo.entity.food.Food;
import com.example.demo.service.IFoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/food")
public class FoodController {
    @Autowired
    private IFoodService iFoodService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Food>> listAll() {
        List<Food> list = this.iFoodService.list();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/listTrend")
    public ResponseEntity<List<Food>> listTrend() {
        List<Food> list = this.iFoodService.listTrend();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Optional<Food>> findByIdFood(@PathVariable int id) {
        Optional<Food> list = this.iFoodService.findById(id);
        if (!list.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/food-category/{id}")
    public ResponseEntity<List<Food>> findFoodByIdCategory(@PathVariable int id) {
        List<Food> list = this.iFoodService.findFoodCategory(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/food/sort/a-z")
    public ResponseEntity<List<Food>> sortAtoZ() {
        List<Food> list = this.iFoodService.sortFoodAToZ();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody Food food) {
        this.iFoodService.create(food);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody FoodDto foodDto) {
        Food food = new Food();
        BeanUtils.copyProperties(foodDto, food);
        this.iFoodService.update(food);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        this.iFoodService.deleteFood(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
