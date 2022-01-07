package com.example.demo.dto;

import com.example.demo.entity.food.Category;
import com.example.demo.entity.order.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private Integer fadId;

    private String fadName;

    private String fadImage;

    private boolean deleteFlag;

    private String fadCode;

    private double fadPrice;

    private Integer fadWaitTime;

    private Category category;

    Set<OrderDetail> orderDetails;


}
