/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htt.repository.impl;

import com.htt.pojo.Cart;
import com.htt.pojo.OrderDetail;
import com.htt.pojo.Product;
import com.htt.pojo.SaleOrder;
import com.htt.repository.ProductRepository;
import com.htt.repository.ReceiptRepository;
import com.htt.repository.UserRepository;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public void addReceipt(List<Cart> carts) {
        if (carts != null) {
            Session s = this.factory.getObject().getCurrentSession();
            SaleOrder order = new SaleOrder();
            order.setUserId(this.userRepo.getUserByUsername(
                    SecurityContextHolder.getContext().getAuthentication().getName()));
            order.setCreatedDate(new Date());
            s.save(order);

            for (Cart c : carts) {
                OrderDetail d = new OrderDetail();
                d.setUnitPrice(c.getUnitPrice());
                d.setQuantity(c.getQuantity());

                d.setProductId(this.productRepo.getProductById(c.getId()));
                d.setOrderId(order);

                s.save(d);
            }

        }
    }
}
