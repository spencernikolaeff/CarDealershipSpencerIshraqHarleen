/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mthree.ihs.CarDealership.dto.Vehicle;
import mthree.ihs.CarDealership.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Spencer
 */
@Controller
public class VehicleController {

    @Autowired
    VehicleService service;
    
    String year = "1994";
    String make = "A4";
    String vmodel = "Audi";
    String body = "";
    String interior = "";
    String exterior = "";
    
//    @GetMapping("/index.html")
//    public String loadFeatured(Model model) {
//        model.addAttribute("featured1year", year);
//        model.addAttribute("featured1model", vmodel);
//        model.addAttribute("featured1make", make);
//        return "/index.html";
//    }
    
    @GetMapping("inventory/new.html")
    public String loadNewInventory(Model model) {
        //model.addAttribute("featured1iconurl", temp.getIconURL());
        model.addAttribute("year", year);
        model.addAttribute("model", vmodel);
        model.addAttribute("make", make);
        model.addAttribute("body", body);
        model.addAttribute("interior", interior);
        model.addAttribute("exterior", exterior);
        //model.addAttribute("featured1price", temp.getPrice());
        return "inventory/new.html";
    }
    
    @GetMapping("inventory/used.html")
    public String loadUsedInventory(Model model) {
        //model.addAttribute("featured1iconurl", temp.getIconURL());
        model.addAttribute("year", year);
        model.addAttribute("model", vmodel);
        model.addAttribute("make", make);
        model.addAttribute("body", body);
        model.addAttribute("interior", interior);
        model.addAttribute("exterior", exterior);
        //model.addAttribute("featured1price", temp.getPrice());
        return "inventory/used.html";
    }
    
    @PostMapping("searchForm")
    public String searchForm(HttpServletRequest request) {
//        String[] inputs = {"",""};
//        inputs[0] = request.getParameter("keyword");
//        inputs[1] = "0";
//        Vehicle test = service.searchVehicle(inputs);
//        body = test.getBody();
//        make = test.getMake();
//        vmodel = test.getModel();
//        interior = test.getInteriorColor();
//        exterior = test.getExteriorColor();
        return "redirect:inventory/new.html";
    }
    
    
//    @GetMapping("index.html")
//    public String putVehicleInFeatured(Model model) {
////        Vehicle temp = service.getVehicleById(1);
//        Vehicle temp = new Vehicle();
//        temp.setYear(1994);
//        temp.setModel("Audi");
//        temp.setMake("A4");
//        //model.addAttribute("featured1iconurl", temp.getIconURL());
//        model.addAttribute("featured1year", temp.getYear());
//        model.addAttribute("featured1model", temp.getModel());
//        model.addAttribute("featured1make", temp.getMake());
//        //model.addAttribute("featured1price", temp.getPrice());
//        return "index.html";
//    }
    
    //trying out post with just vehicle year mayeb?
    
//    @GetMapping("/vehicle/new")
//    public String searchNewVehicles(Model model) {
//        Vehicle vehicle = service.getVehicleById(1);
//        String year = String.valueOf(vehicle.getYear());
//        model.addAttribute("vehicle1year", year);
//        return "test";
//    }

}
