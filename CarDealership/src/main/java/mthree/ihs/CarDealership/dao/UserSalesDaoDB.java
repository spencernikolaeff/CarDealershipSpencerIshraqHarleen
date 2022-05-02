/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mthree.ihs.CarDealership.dto.UserSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author harle
 */
public class UserSalesDaoDB implements UserSalesDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public UserSales getUserSalesById(int id) {
        try {
            final String SELECT_USERSALES_BY_ID = "SELECT * FROM salesaccount JOIN useraccount ON salesaccount.userId = useraccount.userId WHERE salesId = ? ORDER BY salesId;";
            List<UserSales> userSalesList = jdbc.query(SELECT_USERSALES_BY_ID, new UserSalesMapper(), id);
            UserSales userSales = new UserSales();

            userSales = userSalesList.get(0);

            return userSales;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public UserSales addUserSales(UserSales user) {

        final String INSERT_USER = "INSERT INTO salesaccount(totalSales, totalVehiclesSold, userId) "
                + "VALUES(?,?,?)";

        jdbc.update(INSERT_USER,
                user.getTotalSales(),
                user.getTotalVehiclesSold(),
                user.getUserId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setU_salesId(newId);
        return user;
    }

    @Override
    public List<UserSales> getAllUserSales() {
        final String SELECT_ALL_USERSALES = "SELECT * FROM salesaccount JOIN useraccount ON salesaccount.userId = useraccount.userId ORDER BY salesId, isAdmin;";
        List<UserSales> userSales = jdbc.query(SELECT_ALL_USERSALES, new UserSalesMapper());

        return userSales;
    }

    @Override
    public void editUserSales(UserSales user) {
        final String EDIT_USERSALES = "UPDATE salesaccount SET totalSales = ?, totalVehiclesSold = ?, userId = ? WHERE salesId = ?;";

        jdbc.update(EDIT_USERSALES,
                user.getTotalSales(),
                user.getTotalVehiclesSold(),
                user.getUserId(),
                user.getU_salesId());

    }

    @Override
    public void deleteUserSalesById(int id) {
        final String DELETE_USERSALES = "DELETE FROM salesaccount WHERE salesId = ?";
        jdbc.update(DELETE_USERSALES, id);
    }

    public static final class UserSalesMapper implements RowMapper<UserSales> {

        @Autowired
        JdbcTemplate jdbc;

        @Override
        public UserSales mapRow(ResultSet rs, int index) throws SQLException {

            UserSales userSales = new UserSales();
            userSales.setU_salesId(rs.getInt("salesId"));
            userSales.setTotalSales(rs.getBigDecimal("totalSales"));
            userSales.setTotalVehiclesSold(rs.getInt("totalVehiclesSold"));
            userSales.setUserId(rs.getInt("userId"));

            return userSales;
        }
    }

}
