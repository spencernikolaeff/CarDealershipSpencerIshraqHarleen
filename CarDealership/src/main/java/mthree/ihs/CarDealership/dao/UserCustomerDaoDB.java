/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mthree.ihs.CarDealership.dto.UserCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author harle
 */
public class UserCustomerDaoDB implements UserCustomerDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public UserCustomer getUserCustomerById(int id) {
        try {
            final String SELECT_USERCUSTOMER_BY_ID = "SELECT * FROM customeraccount JOIN useraccount ON customeraccount.userId = useraccount.userId WHERE salesId = ? ORDER BY customerId;";
            List<UserCustomer> userCustomerList = jdbc.query(SELECT_USERCUSTOMER_BY_ID, new UserCustomerMapper(), id);
            UserCustomer userCustomer = new UserCustomer();

            userCustomer = userCustomerList.get(0);

            return userCustomer;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public UserCustomer addUserCustomer(UserCustomer user) {
        final String INSERT_USERCUSTOMER = "INSERT INTO customeraccount(phoneNumber, street1, street2, city, state, zipcode, userId) "
                + "VALUES(?,?,?,?,?,?,?)";

        jdbc.update(INSERT_USERCUSTOMER,
                user.getPhoneNumber(),
                user.getStreet1(),
                user.getStreet2(),
                user.getCity(),
                user.getState(),
                user.getZipcode(),
                user.getUserId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setCustomerId(newId);
        return user;
    }

    @Override
    public List<UserCustomer> getAllUserCustomer() {
        final String SELECT_ALL_USERCUSTOMER = "SELECT * FROM customeraccount JOIN useraccount ON customeraccount.userId = useraccount.userId ORDER BY customerId;";
        List<UserCustomer> userCustomer = jdbc.query(SELECT_ALL_USERCUSTOMER, new UserCustomerMapper());

        return userCustomer;
    }

    @Override
    public void editUserCustomer(UserCustomer user) {
        final String EDIT_USERCUSTOMER = "UPDATE customeraccount SET phoneNumber = ?, street1 = ?, street2 = ?, city = ?, state = ?, zipcode = ?, userId = ? WHERE customerId = ?;";

        jdbc.update(EDIT_USERCUSTOMER,
                user.getPhoneNumber(),
                user.getStreet1(),
                user.getStreet2(),
                user.getCity(),
                user.getState(),
                user.getZipcode(),
                user.getUserId(),
                user.getCustomerId());
    }

    @Override
    public void deleteUserCustomerById(int id) {
        final String DELETE_USERCUSTOMER = "DELETE FROM customeraccount WHERE customerId = ?";
        jdbc.update(DELETE_USERCUSTOMER, id);
    }

    public static final class UserCustomerMapper implements RowMapper<UserCustomer> {

        @Autowired
        JdbcTemplate jdbc;

        @Override
        public UserCustomer mapRow(ResultSet rs, int index) throws SQLException {

            UserCustomer userCustomer = new UserCustomer();
            userCustomer.setCustomerId(rs.getInt("customerId"));
            userCustomer.setPhoneNumber(rs.getString("phoneNumber"));
            userCustomer.setStreet1(rs.getString("street1"));
            userCustomer.setStreet2(rs.getString("street2"));
            userCustomer.setCity(rs.getString("city"));
            userCustomer.setState(rs.getString("state"));
            userCustomer.setZipcode(rs.getInt("zipcode"));
            userCustomer.setUserId(rs.getInt("userId"));

            return userCustomer;
        }
    }
}
