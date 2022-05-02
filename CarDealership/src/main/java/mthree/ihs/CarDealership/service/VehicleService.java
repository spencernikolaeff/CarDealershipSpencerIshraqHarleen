/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.service;

import java.math.BigDecimal;
import java.util.List;
import mthree.ihs.CarDealership.dao.VehicleDao;
import mthree.ihs.CarDealership.dto.Vehicle;
import org.springframework.stereotype.Component;

/**
 *
 * @author SPENCER
 */
@Component
public class VehicleService {
    
    private final VehicleDao dao;
    
    //constructor
    public VehicleService(VehicleDao dao) {
        this.dao = dao;
    }
    
    //get vehicle by id
    public Vehicle getVehicleById(int id) {
        return dao.getVehicleById(id);
    }
    
    //get all vehicles
    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }
    
    //get all inStock vehicles
    public List<Vehicle> getAllVehiclesInStock() {
        return dao.getVehicleInventory(true);
    }
    
    //add vehicle
    //takes a string of inputs of size 14
    public void addVehicle(String[] inputs) {
        Vehicle toBeAdded = new Vehicle();
        toBeAdded.setMake(inputs[0]);
        toBeAdded.setModel(inputs[1]);
        toBeAdded.setIsUsed(Boolean.parseBoolean(inputs[2])); //convert isUsed to boolean
        toBeAdded.setBody(inputs[3]);
        toBeAdded.setYear(Integer.parseInt(inputs[4])); //convert year to int
        toBeAdded.setIsManual(Boolean.parseBoolean(inputs[5])); //convert isManual to bool
        toBeAdded.setExteriorColor(inputs[6]);
        toBeAdded.setInteriorColor(inputs[7]);
        toBeAdded.setMileage(Integer.parseInt(inputs[8])); //convert miles to int
        toBeAdded.setVin(inputs[9]);
        toBeAdded.setMsrp(new BigDecimal(inputs[10])); //convert msrp and price to big decimal
        toBeAdded.setPrice(new BigDecimal(inputs[11]));
        toBeAdded.setVehicleDescription(inputs[12]);
        toBeAdded.setIconURL(inputs[13]);
        toBeAdded.setInStock(true); //always adding a vehicle to be in stock
        toBeAdded.setIsFeatured(false); //initially added vehicles will never be featured
        dao.addVehicle(toBeAdded);
    }
    
    //update vehicle
    //here we take a similar approach to add vehicle but with 1 extra step of featuring
    public void editVehicle(String[] inputs) {
        Vehicle toBeAdded = new Vehicle();
        toBeAdded.setMake(inputs[0]);
        toBeAdded.setModel(inputs[1]);
        toBeAdded.setIsUsed(Boolean.parseBoolean(inputs[2])); //convert isUsed to boolean
        toBeAdded.setBody(inputs[3]);
        toBeAdded.setYear(Integer.parseInt(inputs[4])); //convert year to int
        toBeAdded.setIsManual(Boolean.parseBoolean(inputs[5])); //convert isManual to bool
        toBeAdded.setExteriorColor(inputs[6]);
        toBeAdded.setInteriorColor(inputs[7]);
        toBeAdded.setMileage(Integer.parseInt(inputs[8])); //convert miles to int
        toBeAdded.setVin(inputs[9]);
        toBeAdded.setMsrp(new BigDecimal(inputs[10])); //convert msrp and price to big decimal
        toBeAdded.setPrice(new BigDecimal(inputs[11]));
        toBeAdded.setVehicleDescription(inputs[12]);
        toBeAdded.setIconURL(inputs[13]);
        toBeAdded.setInStock(true); //always adding a vehicle to be in stock
        toBeAdded.setIsFeatured(Boolean.parseBoolean(inputs[14]));
        dao.updateVehicle(toBeAdded);
    }
    
    //delete vehicle
    //uses a boolean to return true if delete, false if vehicle doesn't exist
    public boolean deleteVehicle(int id) {
        dao.deleteVehicleById(id);
        if(dao.getVehicleById(id) == null) { //check to make sure vehicle no longer exists
            return true;
        } else {
            return false;
        }
    }
    
    //search vehicle by given inputs in an array
    //*******not sure about the return type yet********
    //inputs[0] = make / model / year ----ALWAYS EXISTS
    //inputs[1] = isUsed -----------------ALWAYS EXISTS
    //inputs[2] = Year1 (using year1 data)
    //inputs[3] = Year2 (using year2 data)
    //inputs[4] = Price1 (using price1 data)
    //inputs[5] = Price2 (using price2 data)
    //
    //
    public Vehicle searchVehicle(String[] inputs) {
        
        //check to make sure we have proper inputs
        
        if(inputs[0].equals("") || inputs.length != 6) {
            return null;
        }
        
        //boolean isUsed
        boolean isUsed = false;
        
        if(Boolean.parseBoolean(inputs[1]) == true){
            isUsed = true;
        }
        
        //check for using basic search if no other data is present
        if((inputs[2] + inputs[3] + inputs[4] + inputs[5]).equals("")) {
            return dao.searchVehicle(inputs[0], isUsed);
        }
        
        //otherwise use advanced search method
        
        //for years
        int year1;
        if(inputs[2] == "") {
            year1 = -1;
        } else {
            year1 = Integer.parseInt(inputs[2]);
        }
        int year2;
        if(inputs[3] == "") {
            year2 = -1;
        } else {
            year2 = Integer.parseInt(inputs[3]);
        }
        
        //for prices
        BigDecimal price1;
        if(inputs[4] == "") {
            price1 = new BigDecimal(-1);
        } else {
            price1 = new BigDecimal(inputs[4]);
        }
        BigDecimal price2;
        if(inputs[5] == "") {
            price2 = new BigDecimal(-1);
        } else {
            price2 = new BigDecimal(inputs[5]);
        }
        
        return dao.searchVehicle(inputs[0], price1, price2, year1, year2, isUsed);
    }
    
    
    
}
