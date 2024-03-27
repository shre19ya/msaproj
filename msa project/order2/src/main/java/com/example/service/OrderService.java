package com.example.service;

//import com.example.entity.Medicine;
import com.example.entity.Order;
//import com.example.entity.User;
//import com.example.repo.MedicineRepository;
import com.example.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface OrderService {
    Order create (Order order);

    List<Order> getOrders();

    List<Order> getOrderbyUserid(int userid);

}