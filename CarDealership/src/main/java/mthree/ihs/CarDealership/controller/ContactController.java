/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.controller;

import javax.servlet.http.HttpServletRequest;
import mthree.ihs.CarDealership.dao.ContactDaoDB;
import mthree.ihs.CarDealership.dto.Contact;
import mthree.ihs.CarDealership.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author harle
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService service;
    
    @Autowired
    private ContactDaoDB dao;

    @GetMapping("/home/contact.html")
    public String loadFeatured(Model model) {

        return "/home/contact.html";
    }

    @PostMapping("/home/contact.html")
    public String addContact(HttpServletRequest request) {
        String contactName = request.getParameter("contactName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String message = request.getParameter("message");

        Contact contact = new Contact();
        contact.setContactName(contactName);
        contact.setEmail(email);
        contact.setPhone(phoneNumber);
        contact.setMessage(message);
        
       // String inputs[] = {"","","","",""};
       // inputs[0] = contactName;
       // inputs[1] = email;
       // inputs[2] = phoneNumber;
       // inputs[3] = message;
       // inputs[4] = "";
        
        dao.addContact(contact);

        return "redirect:/home/contact.html";
    }
    
}
