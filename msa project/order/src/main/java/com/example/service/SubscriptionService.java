package com.example.service;

import com.example.entity.Medicine;
import com.example.entity.Subscription;
import com.example.entity.User;
import com.example.repo.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> getUserSubscriptions(User user) {
        return subscriptionRepository.findByUser(user);
    }

    public void subscribe(User user, Medicine medicine, LocalDate startDate, LocalDate endDate) {
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setMedicine(medicine);
        subscription.setStartDate(startDate);
        subscription.setEndDate(endDate);
        subscriptionRepository.save(subscription);
    }
}