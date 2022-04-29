/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dto;

import java.math.BigDecimal;

/**
 *
 * @author Spencer
 */
public class UserSales extends User {
    
    private int u_salesId;
    
    //private attributes
    private BigDecimal totalSales;
    private int totalVehiclesSold;

    //empty constructor
    public UserSales() {
        
    }

    public int getU_salesId() {
        return u_salesId;
    }

    public void setU_salesId(int u_salesId) {
        this.u_salesId = u_salesId;
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
