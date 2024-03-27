package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 225)
    private Integer id;
    @Column(name="productname", length = 225)
    private String name;
    @Column(name="productdesc", length = 225)
    private String description;
    @Column(name="productcategory", length = 225)
    private String category;
    @Column(name="productmanfucturer", length = 225)
    private String manufacturer;
    @Column(name="productquantity", length = 225)
    private int quantity;
}
