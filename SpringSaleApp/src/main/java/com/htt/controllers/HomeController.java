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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService cateService;
    
    @Autowired
    private ProductService prodService;
    
    @ModelAttribute
    public void commonAttribute(Model model){
        model.addAttribute("cates", this.cateService.getCates());
    }
    
    //Trả về trang chủ
    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("products", this.prodService.getProducts(params));
        
        return "home"; 
    }
}
