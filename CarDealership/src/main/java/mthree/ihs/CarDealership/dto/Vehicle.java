/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dto;

/**
 *
 * @author Spencer Nikolaeff
 */

enum Body {
    COUPE,
    SEDAN,
    VAN,
    TRUCK,
    MOTORCYCLE
}

enum Transmission {
    AUTOMATIC,
    MANUAL
}

enum Color {
    BLACK,
    WHITE,
    RED,
    BLUE,
    GRAY,
    GREEN,
    YELLOW,
    PURPLE,
    ORANGE
}

public class Vehicle {
    
    private String make;
    private String model;
    private boolean type;
    private Body body;
    private int year;
    private Transmission transmission;
    private Color exterior;
    private Color interior;
    private int miles;
    private String vin;
    private String msrp;
    private double price;
    private String description;
    
    public Vehicle() {
        
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String desc) {
        this.description = desc;
    }
    
    public String getMsrp() {
        return this.msrp;
    }
    
    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }
    
    public String getVin() {
        return this.vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public int getMiles() {
        return this.miles;
    }
    
    public void setMiles(int miles) {
        this.miles = miles;
    }
    
    public String getMake() {
        return this.make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public boolean getType() {
        return this.type;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }
    
    public Body getBody() {
        return this.body;
    }
    
    public void setBody(Body body) {
        this.body = body;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public Transmission getTransmission() {
        return this.transmission;
    }
    
    public void setTransmission(Transmission trans) {
        this.transmission = trans;
    }
    
    public Color getInterior() {
        return this.interior;
    }
    
    public void setInterior(Color color) {
        this.interior = color;
    }
    
    public Color getExterior() {
        return this.exterior;
    }
    
    public void setExterior(Color color) {
        this.exterior = color;
    }
    
    
}