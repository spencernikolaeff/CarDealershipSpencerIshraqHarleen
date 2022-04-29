/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dto;

import java.math.BigDecimal;

/**
 *
 * @author 17202
 */
public class UserSales extends User {
    
    //private attributes
    private BigDecimal totalSales;
    private int totalVehiclesSold;

    //empty constructor
    public UserSales() {
        
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalVehiclesSold() {
        return totalVehiclesSold;
    }

    public void setTotalVehiclesSold(int totalVehiclesSold) {
        this.totalVehiclesSold = totalVehiclesSold;
    }
    
    
}
