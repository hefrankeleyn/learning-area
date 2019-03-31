package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.SpittlerDao;
import com.hef.spittr.entities.Spittler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@Repository
public class SpittlerDaoImple implements SpittlerDao {

    private static final Logger log = Logger.getLogger("com.hef.spittr.dao.impl.SpittlerDaoImple");

    @Autowired
    private DataSource dataSource;

    private static final String SQL_INSERT_SPITTER = "insert into Spitter " +
            "(username, password, fullname, email, updateByEmail) values " +
            "(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, " +
            "email = ?, updateByEmail = ? where fullname = ?";

    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname," +
            "email, updateByEmail from spitter where fullname = ?";
    @Override
    public void addSpittler(Spittler spittler) {
//        Connection connectio
        try (Connection connection=dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SPITTER);){
            statement.setString(1, spittler.getUsername());
            statement.setString(2, spittler.getPassword());
            statement.setString(3, spittler.getFullname());
            statement.setString(4, spittler.getEmail());
            statement.setBoolean(5, spittler.getUpdateByEmail());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSpittler(Spittler spittler) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SPITTER)) {
            statement.setString(1, spittler.getUsername());
            statement.setString(2, spittler.getPassword());
            statement.setString(3, spittler.getEmail());
            statement.setBoolean(4, spittler.getUpdateByEmail());
            statement.setString(5, spittler.getFullname());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Spittler findOne(String fullName) {
        Spittler spittler = null;
        ResultSet res = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_SPITTER)){
            statement.setString(1, fullName);
            res = statement.executeQuery();
            if (res.next()){
                log.info(res.toString());
                spittler = new Spittler();
                spittler.setUsername(res.getString("username"));
                spittler.setPassword(res.getString("password"));
                spittler.setEmail(res.getString("email"));
                spittler.setFullname(res.getString("fullname"));
                spittler.setUpdateByEmail(res.getBoolean("updateByEmail"));
            }
            return spittler;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (res != null){
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return spittler;
    }
}
