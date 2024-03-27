package com.example.repo;

import com.example.entity.Order;
//import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserid(int userid);

}
