package com.example.service.ServiceImplementation;

import com.example.entity.Order;
import com.example.repo.OrderRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Override
    public Order create(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getOrderbyUserid(int userid) {
        return orderRepo.findByUserid(userid);
    }

}
