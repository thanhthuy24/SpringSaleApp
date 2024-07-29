/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.htt.repository;

import com.htt.pojo.User;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    User getUserByUsername(String username); 
}
