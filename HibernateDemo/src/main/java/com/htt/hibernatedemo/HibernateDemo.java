/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.htt.hibernatedemo;

import com.htt.pojo.Cart;
import com.htt.repository.impl.CategoryRepositoryImpl;
import com.htt.repository.impl.ProductRepositoryImpl;
import com.htt.repository.impl.ReceiptRepositoryImpl;
import com.htt.repository.impl.StatsRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.err.println(c.getName()));
//        Map<String, String> params = new HashMap<>();
//        params.put("q", "iPhone");
//        params.put("fromPrice", "28000000");
//        params.put("cateId", "2");
//        params.put("page", "2");
//        
//        ProductRepositoryImpl s = new ProductRepositoryImpl();
//        s.getProducts(params).forEach(p -> System.out.printf("%s - %d\n", p.getName(), p.getPrice()));

//            List<Cart> carts = new ArrayList<>();
//            carts.add(new Cart(2, "DEF", 3, 8000));
//
//            ReceiptRepositoryImpl r = new ReceiptRepositoryImpl();
//            r.addReceipt(carts);

//            StatsRepositoryImpl s = new StatsRepositoryImpl();
//            s.statsRevenueByProduct().forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));
        
            StatsRepositoryImpl s = new StatsRepositoryImpl();
            s.statsRevenueByPeriod(2020, "QUARTER").forEach(o -> System.out.printf("%s: %d\n", o[0], o[1]));

    }
}
