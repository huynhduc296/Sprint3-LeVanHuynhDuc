package com.example.demo.service;

import com.example.demo.entity.order.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> list();

    void saveOrder(OrderDetail orderDetail);

    List<OrderDetail> findCartCustomer();
}
