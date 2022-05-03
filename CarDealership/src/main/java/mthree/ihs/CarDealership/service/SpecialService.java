/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.service;

import java.util.List;
import mthree.ihs.CarDealership.dao.SpecialDao;
import mthree.ihs.CarDealership.dto.Special;
import org.springframework.stereotype.Service;

/**
 *
 * @author Spencer
 */
@Service
public class SpecialService {
    private final SpecialDao dao;
    
    public SpecialService(SpecialDao dao) {
        this.dao = dao;
    }
    
    public List<Special> listAllSpecials() {
        return dao.getAllSpecials();
    }
    
}
