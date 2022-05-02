/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import mthree.ihs.CarDealership.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Spencer
 */


@Repository
public class VehicleDaoDB implements VehicleDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Vehicle getVehicleById(int id) {
        try {
            final String SELECT_VEHICLE_BY_ID = "SELECT * FROM Vehicle WHERE vehicleId = ?";
            Vehicle vehicle = jdbc.queryForObject(SELECT_VEHICLE_BY_ID, new VehicleMapper(), id);
            return vehicle;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    //get all vehicles
    //
    //currently gets all vehicles 
    //need to add switch or overloading for different get all vehicle options
    //one area could be getting all vehicles that are IN STOCK
    @Override
    public List<Vehicle> getAllVehicles() {
        final String SELECT_ALL_VEHICLES = "SELECT * FROM VEHICLE";
        List<Vehicle> vehicles = jdbc.query(SELECT_ALL_VEHICLES, new VehicleMapper());
        return vehicles;
    }

    //adding a vehicle
    //doesn't include vehicleId since that's auto-increment
    @Override
    @Transactional
    public Vehicle addVehicle(Vehicle vehicle) {
        final String INSERT_VEHICLE = "INSERT INTO Vehicle(make,model,isUsed,body,vehicleYear,isManual,exteriorColor,interiorColor,mileage,vin,msrp,price,vehicleDescription,icon_url,inStock) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_VEHICLE,
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getIsUsed(),
                vehicle.getBody(),
                vehicle.getYear(),
                vehicle.getIsManual(),
                vehicle.getExteriorColor(),
                vehicle.getInteriorColor(),
                vehicle.getMileage(),
                vehicle.getVin(),
                vehicle.getMsrp(),
                vehicle.getPrice(),
                vehicle.getVehicleDescription(),
                vehicle.getIconURL(),
                vehicle.getInStock(),
                vehicle.getIsFeatured());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        vehicle.setId(newId);
        return vehicle;
    }

    @Override
    @Transactional
    public void updateVehicle(Vehicle vehicle) {
        final String UPDATE_VEHICLE = "UPDATE Vehicle SET make = ?,model = ?,isUsed = ?,body = ?,vehicleYear = ?,isManual = ?,exteriorColor = ?,interiorColor = ?,mileage = ?,vin = ?,msrp = ?,price = ?,vehicleDescription = ?,icon_url = ?,inStock = ? WHERE id = ?";
        jdbc.update(UPDATE_VEHICLE,
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getIsUsed(),
                vehicle.getBody(),
                vehicle.getYear(),
                vehicle.getIsManual(),
                vehicle.getExteriorColor(),
                vehicle.getInteriorColor(),
                vehicle.getMileage(),
                vehicle.getVin(),
                vehicle.getMsrp(),
                vehicle.getPrice(),
                vehicle.getVehicleDescription(),
                vehicle.getIconURL(),
                vehicle.getInStock(),
                vehicle.getIsFeatured());
    }

    //delete vehicle by specified id
    @Override
    @Transactional
    public void deleteVehicleById(int id) {
        final String DELETE_VEHICLE = "DELETE FROM Vehicle WHERE id = ?";
        jdbc.update(DELETE_VEHICLE, id);
    }

    //basic search vehicle 
    //input is the make / model / year
    //isUsed is whether we're selecting from used or new vehicles
    //here we're not searching in a specified year or price range hense 'basic search'
    //int ref is 1-3 with 1 being make, 2 being model, 3 being year
    @Override
    public Vehicle searchVehicle(String input, boolean isUsed) {
        String queryType = "SELECT * FROM VEHICLE WHERE make = " + input + " OR model = " + input + " OR year = " + input;
        queryType += " AND isUsed = " + isUsed;
        Vehicle vehicle = jdbc.queryForObject(queryType, new VehicleMapper());
        return vehicle;
    }

    @Override
    public Vehicle searchVehicle(String input, BigDecimal priceMin, BigDecimal priceMax, int yearMin, int yearMax, boolean isUsed) {
        String queryType = "SELECT * FROM VEHICLE WHERE make = " + input + " OR model = " + input + " OR year = " + input;
        queryType += " AND isUsed = " + isUsed;
        queryType += " AND price BETWEEN " + priceMin + " AND " + priceMax + " AND vehicleYear BETWEEN " + yearMin + " AND " + yearMax;
        Vehicle vehicle = jdbc.queryForObject(queryType, new VehicleMapper());
        return vehicle;
    }

    @Override
    public List<Vehicle> findFeaturedVehicles() {
        final String SELECT_ALL_FEATURED_VEHICLES = "SELECT * FROM VEHICLE WHERE isFeatured = 1";
        List<Vehicle> vehicles = jdbc.query(SELECT_ALL_FEATURED_VEHICLES, new VehicleMapper());
        return vehicles;
    }

    @Override
    public String getVehicleDetails(int id) {
        return getVehicleById(id).getVehicleDescription();
    }

    @Override
    public List<Vehicle> getVehicleInventory(boolean isUsed) {
        final String SELECT_ALL_VEHICLES = "SELECT * FROM VEHICLE WHERE isUsed = " + isUsed + " AND inStock = 1";
        List<Vehicle> vehicles = jdbc.query(SELECT_ALL_VEHICLES, new VehicleMapper());
        return vehicles;
    }

    @Override
    public int getVehicleInventoryCount(int id) {
        Vehicle temp = getVehicleById(id);
        int year = temp.getYear();
        String make = temp.getMake();
        String model = temp.getModel();
        String COUNT_VEHICLE = "SELECT * FROM Vehicle WHERE year = " + year + " AND make = " + make + " AND model = " + model;
        List<Vehicle> tempList = jdbc.query(COUNT_VEHICLE, new VehicleMapper());
        return tempList.size();
    }
    
    public static final class VehicleMapper implements RowMapper<Vehicle> {
        
        @Override
        public Vehicle mapRow(ResultSet rs, int index) throws SQLException {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(rs.getInt("vehicleId"));
            vehicle.setMake(rs.getString("make"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setIsUsed(rs.getBoolean("isUsed"));
            vehicle.setBody(rs.getString("body"));
            vehicle.setYear(rs.getInt("vehicleYear"));
            vehicle.setIsManual(rs.getBoolean("isManual"));
            vehicle.setExteriorColor(rs.getString("exteriorColor"));
            vehicle.setInteriorColor(rs.getString("interiorColor"));
            vehicle.setMileage(rs.getInt("mileage"));
            vehicle.setVin(rs.getString("vin"));
            vehicle.setMsrp(rs.getBigDecimal("msrp"));
            vehicle.setPrice(rs.getBigDecimal("price"));
            vehicle.setVehicleDescription(rs.getString("vehicleDescription"));
            vehicle.setIconURL(rs.getString("icon_url"));
            vehicle.setInStock(rs.getBoolean("inStock"));
            vehicle.setIsFeatured(rs.getBoolean("isFeatured"));
            return vehicle;
        }
    }
    
}
