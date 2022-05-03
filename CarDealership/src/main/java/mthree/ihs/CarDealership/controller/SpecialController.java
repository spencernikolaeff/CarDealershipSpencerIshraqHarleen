/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.controller;

import mthree.ihs.CarDealership.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Spencer
 */
@Controller
public class SpecialController {
    @Autowired
    private SpecialService service;
    
    @GetMapping("/special")
    public String viewSpecials(Model model) {
        model.addAttribute("listSpecials", service.listAllSpecials());
        return "index";
    }
}
