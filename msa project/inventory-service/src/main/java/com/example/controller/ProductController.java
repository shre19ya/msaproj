package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path="/all")
    public List<Product> getAllItems() {
        return productService.getAllItems();
    }

    @GetMapping("/{id}")
    public Product getItemById(@PathVariable Integer id) {
        return productService.getItemById(id);
    }

    @PutMapping("/{id}")
    public Product updateItemQuantity(@PathVariable Integer id, @RequestParam int quantity) {
        return productService.updateItemQuantity(id, quantity);
    }

}
