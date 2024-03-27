package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllItems() {
        return productRepository.findAll();
    }

    public Product getItemById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    public Product updateItemQuantity(Integer id, int quantity) {
        Product item = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        item.setQuantity(quantity);
        return productRepository.save(item);
    }

}
