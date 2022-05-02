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
    
}
