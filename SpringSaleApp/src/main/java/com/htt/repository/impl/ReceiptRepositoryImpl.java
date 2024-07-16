///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.htt.repository.impl;
//
//import com.htt.hibernatedemo.HibernateUtils;
//import com.htt.pojo.Cart;
//import com.htt.pojo.OrderDetail;
//import com.htt.pojo.SaleOrder;
//import java.util.Date;
//import java.util.List;
//import org.hibernate.Session;
//
///**
// *
// * @author Admin
// */
//public class ReceiptRepositoryImpl {
//    private static final UserRepositoryImpl u = new UserRepositoryImpl();
//    private static final ProductRepositoryImpl pr = new ProductRepositoryImpl();
//    
//    public void addReceipt(List<Cart> carts) {
//        if (carts != null) {
//            try (Session s = HibernateUtils.getFactory().openSession()) {
//                SaleOrder order =  new SaleOrder();
//                order.setUserId(u.getUserByUsername("dhthanh"));
//                order.setCreatedDate(new Date());
//                s.save(order);
//  
//                for (var c : carts) {
//                    OrderDetail d = new OrderDetail();
//                    d.setUnitPrice(c.getUnitPrice());
//                    d.setQuantity(c.getQuantity());
//                    
//                    d.setProductId(pr.getProductById(c.getId()));
//                    d.setOrderId(order);
//                    
//                    s.save(d);
//                }
//                
//            }
//            
//        }
//    }
//}
