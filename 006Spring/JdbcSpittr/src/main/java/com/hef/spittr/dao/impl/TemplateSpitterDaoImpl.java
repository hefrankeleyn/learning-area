package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.TemplateSpitterDao;
import com.hef.spittr.entities.Spittler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  JdbcOperations 是一个接口， 定义了 JdbcTemplate 所实现的操作。
 */
//@Repository
public class TemplateSpitterDaoImpl implements TemplateSpitterDao {

    private JdbcOperations jdbcOperations;

    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname," +
            "email, updateByEmail from spitter where fullname = ?";

    private static final String SQL_INSERT_SPITTER = "insert into Spitter " +
            "(username, password, fullname, email, updateByEmail) values " +
            "(?, ?, ?, ?, ?)";

//    @Autowired
    public TemplateSpitterDaoImpl(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }
    @Override
    public Spittler findOneSpittler(String fullname) {
        return jdbcOperations.queryForObject(SQL_SELECT_SPITTER, new SpitterRowMapper(), fullname);
    }

    @Override
    public void addSpitter(Spittler spittler) {
        jdbcOperations.update(SQL_INSERT_SPITTER, spittler.getUsername(),
                spittler.getPassword(),
                spittler.getFullname(),
                spittler.getEmail(),
                spittler.getUpdateByEmail());
    }

    @Override
    public Spittler lambdaFindOneSpitter(String fullname) {
        return jdbcOperations.queryForObject(SQL_SELECT_SPITTER, (res, row) -> {
            return new Spittler(res.getString("username"),
                    res.getString("password"),
                    res.getString("fullname"),
                    res.getString("email"),
                    res.getBoolean("updateByEmail"));
        }, fullname);
    }

    @Override
    public Spittler methodReferenceFindOneSpitter(String fullname) {
        return jdbcOperations.queryForObject(SQL_SELECT_SPITTER, this::mapSpitter, fullname);
    }

    /**
     * 引用的方法
     * @param res
     * @param row
     * @return
     * @throws SQLException
     */
    private Spittler mapSpitter(ResultSet res, int row) throws SQLException{
        return new Spittler(res.getString("username"),
                res.getString("password"),
                res.getString("fullname"),
                res.getString("email"),
                res.getBoolean("updateByEmail"));
    }

    /**
     * Spring 的映射
     */
    private static final class SpitterRowMapper implements RowMapper<Spittler> {
        @Override
        public Spittler mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Spittler(resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getBoolean("updateByEmail"));
        }
    }
}
