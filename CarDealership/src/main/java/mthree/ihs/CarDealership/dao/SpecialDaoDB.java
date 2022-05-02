/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mthree.ihs.CarDealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mthree.ihs.CarDealership.dto.Special;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 17202
 */
@Repository
public class SpecialDaoDB implements SpecialDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Special getSpecialById(int specialid) {
        try {
            final String SELECT_SPECIAL_BY_ID = "SELECT * FROM special WHERE specialId = ?";
            return jdbc.queryForObject(SELECT_SPECIAL_BY_ID, new SpecialMapper(), specialid);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Special> getAllSpecials() {
        final String SELECT_ALL_SPECIAL = "SELECT * FROM special";
        return jdbc.query(SELECT_ALL_SPECIAL, new SpecialMapper());
    }

    @Override
    @Transactional
    public Special addSpecial(Special special) {
        final String INSERT_SPECIAL = "INSERT INTO special(specialTitle, specialDescription, discountValue, isPercent) "
                + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_SPECIAL,
                special.getTitle(),
                special.getDescription(),
                special.getDiscountValue(),
                special.getIsPercent());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        special.setSpecialId(newId);
        return special;
    }

    @Override
    public void updateSpecial(Special special) {
        final String UPDATE_SPECIAL = "UPDATE Special SET specialTitle = ?, specialDescription = ?, discountValue = ? "
                + "WHERE specialId = ?";
        jdbc.update(UPDATE_SPECIAL,
                special.getTitle(),
                special.getDescription(),
                special.getDiscountValue(),
                special.getSpecialId());
    }

    @Override
    public void deleteSpecial(int id) {
        final String DELETE_SPECIAL = "DELETE FROM Special WHERE specialId = ?";
        jdbc.update(DELETE_SPECIAL, id);

    }

    public static final class SpecialMapper implements RowMapper<Special> {

        @Override
        public Special mapRow(ResultSet rs, int index) throws SQLException {
            Special special = new Special();
            special.setTitle(rs.getString("specialTitle"));
            special.setDescription(rs.getString("specialDescription"));
            special.setDiscountValue(rs.getBigDecimal("discountValue"));
            special.setIsPercent(rs.getBoolean("isPercent"));

            return special;
        }
    }
}
