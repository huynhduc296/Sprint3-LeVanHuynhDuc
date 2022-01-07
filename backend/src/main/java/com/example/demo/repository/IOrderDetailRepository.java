package com.example.demo.repository;


import com.example.demo.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Modifying
    @Query(value = "INSERT INTO `sprint3`.`order_detail` (`fad_id`, `order_id`, `quantity`, `customer_id`) VALUES (?1, ?2,?3, '1')", nativeQuery = true)
    void createOrderDetail(int fadId, int orderId, int quantity);

    @Query(value = "select * \n" +
            "from order_detail\n" +
            "where customer_id = 1", nativeQuery = true)
    List<OrderDetail> getFindByCustomer();

}
