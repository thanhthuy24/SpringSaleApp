/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htt.service.impl;

import com.htt.pojo.Product;
import com.htt.repository.ProductRepository;
import com.htt.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository prodRepo;
    
    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.prodRepo.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product p) {
        this.prodRepo.addOrUpdate(p);
    }

    @Override
    public Product getProductById(int id) {
        return this.prodRepo.getProductById(id);
    }
    
}
