/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.util.List;
import mthree.ihs.CarDealership.dto.Special;

/**
 *
 * @author Spencer
 */
public interface SpecialDao {
    
    //basic methods
    Special getSpecialById(int id);
    List<Special> getAllSpecials();
    Special addSpecial(Special special);
    void updateSpecial(Special special);
    void deleteSpecial(int id);
    
    //get vehicle id by special
    int getVehicleIdBySpecialId(int id);
    
}
