/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.ihs.CarDealership.dao;

import java.util.List;
import mthree.ihs.CarDealership.dto.Contact;

/**
 *
 * @author Ishraq
 */
public interface ContactDao {
    
    // gets a specific contact
    Contact getContact(int contactId);
    
    // List out all contacts
    List <Contact> getAllContacts();
    
    // adds a contact to the contact table
    Contact addContact(Contact contact);
    
    // updates a existing contact
    void updateContact(Contact contact);
    
}
