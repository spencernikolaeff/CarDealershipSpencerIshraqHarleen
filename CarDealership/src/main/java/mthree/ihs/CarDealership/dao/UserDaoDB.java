/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import javax.management.relation.Role;
import mthree.ihs.CarDealership.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author harle
 */
@Repository
public class UserDaoDB implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User getUserById(int id) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM useraccount WHERE userId = ? ORDER BY userId, isAdmin;";
            List<User> users = jdbc.query(SELECT_USER_BY_ID, new UserMapper(), id);
            User user = new User();

            user = users.get(0);

            return user;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public User addUser(User user) {

        final String INSERT_USER = "INSERT INTO useraccount(firstName, lastName, email, password) "
                + "VALUES(?,?,?,?)";

        jdbc.update(INSERT_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        final String SELECT_ALL_USER = "SELECT * FROM useraccount ORDER BY userId, isAdmin;";
        List<User> users = jdbc.query(SELECT_ALL_USER, new UserMapper());

        return users;
    }

    @Override
    public void editUser(User user) {
        final String EDIT_USER = "UPDATE useraccount SET firstName = ?, lastName = ?, email = ?, password = ? WHERE id = ?;";

        final String EDIT_USER_ISADMIN = "UPDATE useraccount SET isAdmin = ?";

        jdbc.update(EDIT_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());

        jdbc.update(EDIT_USER_ISADMIN, user.isIsAdmin());

    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        final String DELETE_USER = "DELETE FROM useraccount WHERE userId = ?";
        jdbc.update(DELETE_USER, id);

    }

    public static final class UserMapper implements RowMapper<User> {

        @Autowired
        JdbcTemplate jdbc;

        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {

            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setIsAdmin(rs.getBoolean("isAdmin"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

}
