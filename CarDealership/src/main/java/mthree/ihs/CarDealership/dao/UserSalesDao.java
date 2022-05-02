/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.util.List;
import mthree.ihs.CarDealership.dto.UserSales;

/**
 *
 * @author harle
 */
public interface UserSalesDao {

    UserSales getUserSalesById(int id);

    UserSales addUserSales(UserSales user);

    List<UserSales> getAllUserSales();

    void editUserSales(UserSales user);
    
    void deleteUserSalesById(int id);
    
}
