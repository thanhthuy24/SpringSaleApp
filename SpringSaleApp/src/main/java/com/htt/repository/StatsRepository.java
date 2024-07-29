/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.htt.repository;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatsRepository {
    List<Object[]> statsRevenueByProduct();
    List<Object[]> statsRevenueByPeriod(int year, String period);
}
