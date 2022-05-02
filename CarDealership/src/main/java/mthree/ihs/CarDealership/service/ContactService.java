/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.service;

import java.util.List;
import mthree.ihs.CarDealership.dao.ContactDao;
import mthree.ihs.CarDealership.dao.VehicleDao;
import mthree.ihs.CarDealership.dto.Contact;
import mthree.ihs.CarDealership.dto.Vehicle;

/**
 *
 * @author SPENCER
 */
public class ContactService {
    private final ContactDao dao;
    private final VehicleDao vdao;
    
    //constructor
    public ContactService(ContactDao dao, VehicleDao vdao) {
        this.dao = dao;
        this.vdao = vdao;
    }
    
    public Contact getContact(int id) {
        return dao.getContact(id);
    }
    
    public List<Contact> getAllContacts() {
        return dao.getAllContacts();
    }
    
    //adding a contact
    //inputs[0] = name
    //inputs[1] = email
    //inputs[2] = phone number
    //inputs[3] = message
    //inputs[4] = vehicleId
    //
    //boolean addVin used to check of contact was accessed through details page
    public Contact addContact(String[] inputs, boolean addVin) {
        //name and message are required
        if(inputs[0].equals("") || inputs[3].equals("")) {
            return null;
        }
        
        //either email or phone must be provided
        if(inputs[1].equals("") && inputs[2].equals("")) {
            return null;
        }
        
        //check to see if vehicle exists
        int vehicleId = Integer.parseInt(inputs[4]);
        Vehicle temp = vdao.getVehicleById(vehicleId);
        if(temp == null) {
            return null;
        }
        
        //create contact variable
        Contact ret = new Contact();
        
        //if accessed from inventory/details page
        if(addVin == true) {
            inputs[3] = temp.getVin() + inputs[3];
        }
        ret.setContactName(inputs[0]);
        ret.setEmail(inputs[1]);
        ret.setPhone(inputs[2]);
        ret.setMessage(inputs[3]);
        ret.setVehicleId(vehicleId);
        
        return ret;
        
    }
    
    //not sure what we'll use this for
    public void updateContact(Contact contact) {
        dao.updateContact(contact);
    }
}
