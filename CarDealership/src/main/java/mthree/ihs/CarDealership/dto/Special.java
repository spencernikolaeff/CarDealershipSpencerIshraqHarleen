/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.ihs.CarDealership.dto;

import java.math.BigDecimal;

/**
 *
 * @author khani
 */
public class Special {
    private int specialId = 0;
    private String Description;
    private BigDecimal discountValue;
    private boolean isPercent = false;

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public void setIsPercent(boolean isPercent) {
        this.isPercent = isPercent;
    }

    public int getSpecialId() {
        return specialId;
    }

    public String getDescription() {
        return Description;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public boolean isIsPercent() {
        return isPercent;
    }
    
    
    
}
