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

    @Override
    public List<Vehicle> getAllVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteVehicleById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehicle searchVehicle(String input, int ref, boolean isUsed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehicle searchVehicle(String input, int ref, BigDecimal priceMin, BigDecimal priceMax, int yearMin, int yearMax, boolean isUsed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehicle> findFeaturedVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getVehicleDetails(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehicle> getVehicleInventory(boolean isUsed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getVehicleInventoryCount(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static final class VehicleMapper implements RowMapper<Vehicle> {
        
        @Override
        public Vehicle mapRow(ResultSet rs, int index) throws SQLException {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleId(rs.getInt("vehicleId"));
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
            return vehicle;
        }
    }
    
}
