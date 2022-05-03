/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.ihs.CarDealership.dao;

import java.time.LocalDate;
import java.util.List;
import mthree.ihs.CarDealership.dto.salesLog;
import mthree.ihs.CarDealership.dto.UserSales;

/**
 *
 * @author Ishraq
 */
public interface SalesLogDao {
    
    // list out the sales done by specific user
    List<salesLog> getAllSalesLogByUser(int salesPersonId);
    
    // List out all sales
    List<salesLog>  getAllSales();
    
    // List out Sales by Specific User and between two dates
    List <salesLog> getSalesLogByDate(int salesPersonId, LocalDate startDate, LocalDate endDate);
    
    // add a Sales Log
    salesLog addSalesLog(salesLog sale);
}
