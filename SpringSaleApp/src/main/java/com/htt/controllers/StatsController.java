/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htt.controllers;

import com.htt.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class StatsController {
    @Autowired
    private StatsService statsSer;
    
    @GetMapping("/stats")
    public String index(Model model){
        model.addAttribute("revenues", this.statsSer.statsRevenueByProduct());
        return "stats";
    }
}
