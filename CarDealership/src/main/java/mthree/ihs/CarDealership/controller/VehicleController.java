/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.controller;

import java.util.List;
import mthree.ihs.CarDealership.dto.Vehicle;
import mthree.ihs.CarDealership.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Spencer
 */
@Controller
public class VehicleController {

    @Autowired
    VehicleService service;
    
    
    //trying out post with just vehicle year mayeb?
    
//    @GetMapping("/vehicle/new")
//    public String searchNewVehicles(Model model) {
//        Vehicle vehicle = service.getVehicleById(1);
//        String year = String.valueOf(vehicle.getYear());
//        model.addAttribute("vehicle1year", year);
//        return "test";
//    }

}
