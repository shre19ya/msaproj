package com.example.controller;

//import com.example.entity.Medicine;
import com.example.entity.Order;
//import com.example.entity.User;
//import com.example.service.MedicineService;
import com.example.service.OrderService;
//import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @RequestMapping("/hello")
    String display(){
        return "hello this is order microservice";
    }

    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok(service.getOrders());
    }
    @GetMapping("/users/{userid}")
    public ResponseEntity<List<Order>> getOrderbyUserid(@PathVariable int userid){
        return ResponseEntity.ok(service.getOrderbyUserid(userid));
    }

}

