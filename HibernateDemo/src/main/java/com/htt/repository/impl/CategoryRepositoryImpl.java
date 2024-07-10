/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htt.repository.impl;

import com.htt.hibernatedemo.HibernateUtils;
import com.htt.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates() {
        // Dùng HQL
        try (Session s = HibernateUtils.getFactory().openSession()){
            
            Query q = s.createQuery("From Category");
            return q.getResultList();
        }
    }
}
