/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.util.List;
import mthree.ihs.CarDealership.dto.User;

/**
 *
 * @author harle
 */
public interface UserDao {
    
    String getUserEmailById(int id);
    User getUserById(int id);
    User addUser(User user);
    List<User> getAllUsers();
    User editUser(User user);
    User getUserByUsername(String us);
    
    void deleteUserById(int id);
    
}
