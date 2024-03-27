package com.example.service;

import com.example.entity.Medicine;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.repo.MedicineRepository;
import com.example.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUser(user);
    }

    public void placeOrder(User user, String medicineName) {
        Medicine medicine = medicineRepository.findByName(medicineName);
        if (medicine != null && medicine.getQuantity() > 0) {
            Order order = new Order();
            order.setUser(user);
            order.setMedicine(medicine);
            order.setOrderDate(LocalDateTime.now());
            orderRepository.save(order);
            // Update inventory: decrease quantity of ordered medicine
            medicine.setQuantity(medicine.getQuantity() - 1);
            medicineRepository.save(medicine);
        } else {
            throw new RuntimeException("Medicine not available or out of stock");
        }
    }
}