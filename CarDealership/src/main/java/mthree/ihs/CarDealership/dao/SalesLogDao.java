/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.ihs.CarDealership.dao;

import java.time.LocalDate;
import java.util.List;
import mthree.ihs.CarDealership.dto.SalesLog;
import mthree.ihs.CarDealership.dto.UserSales;

/**
 *
 * @author khani
 */
public interface SalesLogDao {
    
    List<SalesLog> getAllSalesLogByUser(UserSales salesPerson);
    
    List<SalesLog>  getAllSales();
    
    List <SalesLog> getSalesLogByDate(UserSales salesPerson, LocalDate startDate, LocalDate endDate);
    
    
}
