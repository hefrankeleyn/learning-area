package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.NamedParametersSpittlerDao;
import com.hef.spittr.entities.Spittler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NamedParameterSpittlerDaoImple implements NamedParametersSpittlerDao {


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_INSERT_SPITTER = "insert into Spitter " +
            "(username, password, fullname, email, updateByEmail) values " +
            "(:username, :password, :fullname, :email, :updateByEmail)";
    @Override
    public void addSpittler(Spittler spittler) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", spittler.getUsername());
        paramMap.put("password", spittler.getPassword());
        paramMap.put("email", spittler.getEmail());
        paramMap.put("fullname", spittler.getFullname());
        paramMap.put("updateByEmail", spittler.getUpdateByEmail());
        namedParameterJdbcTemplate.update(SQL_INSERT_SPITTER, paramMap);
    }
}
