package com.example.service;

import com.example.entity.Medicine;
import com.example.repo.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public Medicine getMedicineByName(String name) {
        return medicineRepository.findByName(name);
    }
}