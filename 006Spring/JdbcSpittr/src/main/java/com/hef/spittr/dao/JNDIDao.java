package com.hef.spittr.dao;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JNDI 连接
 */
public interface JNDIDao {

    Connection getConnection() throws NamingException, SQLException;

}
