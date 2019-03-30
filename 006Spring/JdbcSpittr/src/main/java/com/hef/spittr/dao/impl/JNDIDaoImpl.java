package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.JNDIDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class JNDIDaoImpl implements JNDIDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public Connection getConnection() throws NamingException, SQLException {
        return dataSource.getConnection();
    }
}
