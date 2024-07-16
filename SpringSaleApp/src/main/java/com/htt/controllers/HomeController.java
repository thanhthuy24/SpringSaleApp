/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htt.controllers;

import com.htt.service.CategoryService;
import com.htt.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService cateService;
    
    @Autowired
    private ProductService prodService;
    
    //Trả về trang chủ
    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("cates", this.cateService.getCates());
        model.addAttribute("products", this.prodService.getProducts(params));
        return "index"; 
    }
}
