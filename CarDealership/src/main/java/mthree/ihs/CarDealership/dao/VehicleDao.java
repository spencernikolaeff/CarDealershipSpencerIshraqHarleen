/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.math.BigDecimal;
import java.util.List;
import mthree.ihs.CarDealership.dto.Vehicle;

/**
 *
 * @author Spencer
 */
public interface VehicleDao {
    
    //basic methods
    
    //get by id
    Vehicle getVehicleById(int id);
    
    //get all
    List<Vehicle> getAllVehicles();
    
    //add 
    Vehicle addVehicle(Vehicle vehicle);
    
    //edit
    void updateVehicle(Vehicle vehicle);
    
    //delete
    void deleteVehicleById(int id);
    
    
    
    //advanced methods
    
    //search by make / model / year
    //we use this when Price is set to No Min, No Max, and Year is set to No Min, No Max
    //ref 1: make
    //ref 2: model
    //ref 3: year
    //isUsed is whether we're searching used / new vehicles since they're seperate pages
    Vehicle searchVehicle(String input, int ref, boolean isUsed);

    //search + price or year
    Vehicle searchVehicle(String input, int ref, BigDecimal priceMin, BigDecimal priceMax, int yearMin, int yearMax, boolean isUsed);
    
    //featured vehicles
    List<Vehicle> findFeaturedVehicles();
    
    //get vehicle details
    String getVehicleDetails(int id);
    
    //get vehicle inventory
    //gets list of new/used vehicles 
    //maybe use helper method for the counts
    List<Vehicle> getVehicleInventory(boolean isUsed);
    
    //get vehicle inventory HELPER
    //gets the number of vehicles using the vehicle id
    //get the make, model, and year of the vehicle with that id
    //then see how many vehicles we have with those specifications
    int getVehicleInventoryCount(int id);
    
}
