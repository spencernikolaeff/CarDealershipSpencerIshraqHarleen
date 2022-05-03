/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author harle
 */
public class salesLog {

    private int salesLogId;

    private LocalDate dateSold;
    private BigDecimal priceSoldFor;
    private int customerId;
    private int salesId;
    private int vehicleId;  //Returning IDs from the database 

    public int getSalesLogId() {
        return salesLogId;
    }

    public salesLog() {

    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public void setDateSold(LocalDate dateSold) {
        this.dateSold = dateSold;
    }

    public BigDecimal getPriceSoldFor() {
        return priceSoldFor;
    }

    public void setPriceSoldFor(BigDecimal priceSoldFor) {
        this.priceSoldFor = priceSoldFor;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setSalesLogId(int salesLogId) {
        this.salesLogId = salesLogId;
    }

}
