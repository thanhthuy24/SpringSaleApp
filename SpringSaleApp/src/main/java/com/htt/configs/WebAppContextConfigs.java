/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htt.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Admin
 */
@EnableWebMvc

//kích hoạt transaction
@EnableTransactionManagement

//gắn annotation config... để biến nó thành rỗ đậu 
@Configuration 

//chỉ những chỗ chứa bean bằng annotation để nó scan
@ComponentScan(basePackages = {
    "com.htt.controllers",
    "com.htt.repository",
    "com.htt.service"
})
// trang này là IoC container
public class WebAppContextConfigs implements  WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
    }
    
    //phân giải từ controller thành view ...
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver r = new InternalResourceViewResolver();
        
        r.setViewClass(JstlView.class);
        r.setPrefix("/WEB-INF/pages/");
        r.setSuffix(".jsp");
        
        return r;
    }
}
