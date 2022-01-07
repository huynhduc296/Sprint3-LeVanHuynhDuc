package com.example.demo.repository;

import com.example.demo.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

    @Modifying // tạo trước 1 cái table vs order
    @Query(value = "insert into `orders` (table_id) value (?1);", nativeQuery = true)
    void createOrderTable(int tableId);

    @Query(value = "select * \n" +
            "from orders order by order_id desc limit 1;", nativeQuery = true)
    Optional<Orders> getNewOrder();


}
