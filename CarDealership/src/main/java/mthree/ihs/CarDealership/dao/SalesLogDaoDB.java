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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ishraq
 */
@Repository
public class SalesLogDaoDB implements SalesLogDao {

    @Autowired
    JdbcTemplate jdbc;

    // list out the sales done by specific user
    @Override
    public List<SalesLog> getAllSalesLogByUser(int salesPersonId) {
        final String SELECT_ALL_SALESLOG_BY_USER = "SELECT * FROM salesLog"
                + "WHERE salesId = " + salesPersonId;
        return jdbc.query(SELECT_ALL_SALESLOG_BY_USER, new SalesLogMapper());
    }

    // List out all sales
    @Override
    public List<SalesLog> getAllSales() {
        final String SELECT_ALL_SALESLOG = "SELECT * FROM salesLog";
        return jdbc.query(SELECT_ALL_SALESLOG, new SalesLogMapper());
    }

    // List out Sales by Specific User and between two dates
    @Override
    public List<SalesLog> getSalesLogByDate(int salesPersonId, LocalDate startDate, LocalDate endDate) {
        final String SELECT_ALL_SALESLOG_BY_DATES = "SELECT * FROM salesLog"
                + " WHERE (salesId = " + salesPersonId + " AND dateSold >= "
                + startDate + " AND datesold <= " + endDate;
        return jdbc.query(SELECT_ALL_SALESLOG_BY_DATES, new SalesLogMapper());
    }

    // add a Sales Log
    @Override
    @Transactional
    public SalesLog addSalesLog(SalesLog sale) {
        final String INSERT_SALESLOG = "INSERT INTO salesLog(dateSold, priceSoldFor, customerId, salesId, vehicleId) "
                + "VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_SALESLOG,
                sale.getDateSold(),
                sale.getPriceSoldFor(),
                sale.getCustomerId(),
                sale.getSalesId(),
                sale.getVehicleId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sale.setSalesLogId(newId);
        return sale;
    }
    
    // Mapper forsalesLog
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
