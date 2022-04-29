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
    
    private int specialId;
    private String title;
    private String Description;
    private BigDecimal discountValue;
    private boolean isPercent;
    private String icon_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }
    
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
