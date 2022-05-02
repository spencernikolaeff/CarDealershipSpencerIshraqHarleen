/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.ihs.CarDealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import mthree.ihs.CarDealership.dto.SalesLog;
import mthree.ihs.CarDealership.dto.UserSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ishraq
 */
@Repository
public class SalesLogDaoDB implements SalesLogDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<SalesLog> getAllSalesLogByUser(int salesPersonId) {
        final String SELECT_ALL_SALESLOG_BY_USER = "SELECT * FROM salesLog" + "WHERE salesId = ?" ;
        return jdbc.query(SELECT_ALL_SALESLOG_BY_USER, new SalesLogMapper());
    }

    @Override
    public List<SalesLog> getAllSales() {
final String SELECT_ALL_SALESLOG = "SELECT * FROM salesLog";
        return jdbc.query(SELECT_ALL_SALESLOG, new SalesLogMapper());    }

    @Override
    public List<SalesLog> getSalesLogByDate(UserSales salesPerson, LocalDate startDate, LocalDate endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSalesLog(SalesLog sale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static final class SalesLogMapper implements RowMapper<SalesLog> {

        @Override
        public SalesLog mapRow(ResultSet rs, int index) throws SQLException {
            SalesLog salesLog = new SalesLog();
            salesLog.setDateSold(rs.getDate("dateSold").toLocalDate());
            salesLog.setPriceSoldFor(rs.getBigDecimal("priceSoldFor"));
            salesLog.setCustomerId(rs.getInt("customerId"));
            salesLog.setSalesId(rs.getInt("salesId"));
            salesLog.setVehicleId(rs.getInt("vehicleId"));

            return salesLog;
        }
    }
}
