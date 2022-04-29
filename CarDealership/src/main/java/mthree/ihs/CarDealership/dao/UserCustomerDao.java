/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.util.List;
import mthree.ihs.CarDealership.dto.UserCustomer;

/**
 *
 * @author harle
 */
public interface UserCustomerDao {

    String getUserCustomerEmailById(int id);

    UserCustomer getUserCustomerById(int id);

    UserCustomer addUserCustomer(UserCustomer user);

    List<UserCustomer> getAllUserCustomer();

    UserCustomer editUserCustomer(UserCustomer user);

    String getUserCustomerAddress(UserCustomer user);
    
    String getUserCustomerPhoneNumber(UserCustomer user);
    
    void deleteUserCustomerById(int id);

}

