package com.example.demo.entity.food;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private String categoryCode;

    private Boolean deleteFlag;

    @JsonBackReference(value = "category_items")
    @OneToMany(mappedBy = "category")
    private Set<Food> foods;
}
