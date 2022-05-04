/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.ihs.CarDealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mthree.ihs.CarDealership.dto.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ishraq
 */
@Repository
@Component
public class ContactDaoDB implements ContactDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Contact getContact(int contactId) {
        try {
            final String SELECT_CONTACT_BY_ID = "SELECT * FROM contact WHERE contactId = ?";
            return jdbc.queryForObject(SELECT_CONTACT_BY_ID, new ContactMapper(), contactId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Contact> getAllContacts() {
        final String SELECT_ALL_CONTACT = "SELECT * FROM contact";
        return jdbc.query(SELECT_ALL_CONTACT, new ContactMapper());
    }

    @Override
    @Transactional
    public Contact addContact(Contact contact) {
        final String INSERT_CONTACT = "INSERT INTO contact(contactName, email, phoneNumber, message, vehicleId) "
                + "VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_CONTACT,
                contact.getContactName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getMessage(),
                contact.getVehicleId());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        contact.setContactId(newId);
        return contact;
    }

    
    @Override
    public void updateContact(Contact contact) {
        final String UPDATE_CONTACT = "UPDATE contact SET contactName = ?, email = ?, phoneNumber = ?, message = ? "
                + "WHERE contactId = ?";
        jdbc.update(UPDATE_CONTACT,
                contact.getContactName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getMessage(),
                contact.getContactId());
    }

    public static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int index) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contactId"));
            contact.setContactName(rs.getString("contactName"));
            contact.setEmail(rs.getString("email"));
            contact.setPhone(rs.getString("phoneNumber"));
            contact.setMessage(rs.getString("message"));

            return contact;
        }
    }
}
