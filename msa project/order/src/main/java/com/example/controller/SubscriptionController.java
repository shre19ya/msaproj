package com.example.controller;

import com.example.entity.Medicine;
import com.example.entity.Subscription;
import com.example.entity.User;
import com.example.repo.MedicineRepository;
import com.example.repo.UserRepository;
import com.example.service.MedicineService;
import com.example.service.SubscriptionService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        List<Subscription> subscriptions = subscriptionService.getUserSubscriptions(user);
        return ResponseEntity.ok(subscriptions);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(
            @RequestParam String username,
            @RequestParam String medicineName,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        User user = userService.getUserByUsername(username);
        Medicine medicine = medicineService.getMedicineByName(medicineName);
        subscriptionService.subscribe(user, medicine, startDate, endDate);
        return ResponseEntity.ok("Subscription created successfully");
    }
}
