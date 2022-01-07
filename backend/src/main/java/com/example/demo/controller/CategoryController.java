package com.example.demo.controller;

import com.example.demo.entity.food.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> list = this.iCategoryService.list();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Category>> findByCategory(@PathVariable int id) {
        Optional<Category> list = this.iCategoryService.findById(id);
        if (!list.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PatchMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id) {
        this.iCategoryService.delete(id);
    }
    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Category category) {
        this.iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        this.iCategoryService.update(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
