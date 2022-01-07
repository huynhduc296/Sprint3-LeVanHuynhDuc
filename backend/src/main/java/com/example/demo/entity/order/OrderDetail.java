package com.example.demo.entity.order;


import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.food.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private OrderDetailKey orderDetailId;


    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @MapsId("fadId")
    @JoinColumn(name = "fad_id")
    private Food food;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;


    private int quantity;
}
