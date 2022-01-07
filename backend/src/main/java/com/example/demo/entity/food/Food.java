package com.example.demo.entity.food;


import com.example.demo.entity.order.OrderDetail;
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
public class Food {
    @JsonBackReference(value = "items_orders")
    @OneToMany(mappedBy = "food")
    Set<OrderDetail> orderDetails;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fadId;
    private String fadName;
    private String fadImage;
    private boolean deleteFlag;
    private String fadCode;
    private double fadPrice;
//    private Integer fadWaitTime;
    private String description;
    private Integer quantityPeopleOrder;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;
    
}
