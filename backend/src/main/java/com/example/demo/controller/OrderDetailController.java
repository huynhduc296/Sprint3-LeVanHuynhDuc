//package com.example.demo.controller;
//
//import com.example.demo.entity.order.OrderDetail;
//import com.example.demo.repository.IOrderDetailRepository;
//import com.example.demo.service.IOrderDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/order-detail")
//@CrossOrigin("*")
//public class OrderDetailController {
//    @Autowired
//    private IOrderDetailService iOrderDetailService;
//
//    @GetMapping("/list")
//    public ResponseEntity<List<OrderDetail>> listAll() {
//        List<OrderDetail> list = this.iOrderDetailService.list();
//        if (list.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public void save(@RequestBody OrderDetail orderDetail) {
//        this.iOrderDetailService.saveOrder(orderDetail);
//    }
//
//    @GetMapping("/list/customer")
//    public ResponseEntity<List<OrderDetail>> findOrderCustomer() {
//        List<OrderDetail> list = this.iOrderDetailService.findCartCustomer();
//        if (list.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//}
