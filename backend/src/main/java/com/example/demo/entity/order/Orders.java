package com.example.demo.entity.order;

import com.example.demo.entity.customer.Customer;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String orderCode;

    private String createDate;

    @JsonBackReference
    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> orderDetails;


}