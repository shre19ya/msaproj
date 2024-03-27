package com.example.controller;

import com.example.entity.Medicine;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.service.MedicineService;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        List<Order> orders = orderService.getUserOrders(user);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(
            @RequestParam String username,
            @RequestParam String medicineName
    ) {
        User user = userService.getUserByUsername(username);
        Medicine medicine = medicineService.getMedicineByName(medicineName);
        orderService.placeOrder(user, String.valueOf(medicine));
        return ResponseEntity.ok("Order placed successfully");
    }
}

