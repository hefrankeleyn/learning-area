package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.SpitterDao;
import com.hef.spittr.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class SpitterDaoImpl implements SpitterDao {

    private static final Logger log = Logger.getLogger("SpitterDaoImpl");

    @Autowired
    private NamedParameterJdbcOperations jdbcOperations;

    private static final String SQL_SELECT_SPITTER_BY_ID = "select id, username, password, fullname, email, updatebyemail " +
            "from spitter where id= :id";


    private static final String SQL_SELECT_SPITTERS = "select id, username, password, fullname, email, updatebyemail " +
            "from spitter";


    private static final String SQL_SAVE_SPITTER = "insert into spitter(username, password, fullname, email, updatebyemail) " +
            "values(:username, :password, :fullname, :email, :updatebyemail)";

    private static final String SQL_FIND_LASTONE = "select id, username, password, fullname, email, updatebyemail from spitter order by id desc limit 1";
    private static final String SQL_DELETE_BY_ID = "delete from spitter where id=:id";

    @Override
    public Spitter findSpitterById(Long id) {
        log.info(SQL_SELECT_SPITTER_BY_ID);
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("id", id);
        Spitter spitter = jdbcOperations.query(SQL_SELECT_SPITTER_BY_ID, paraMap,(resultSet) -> {

            if(resultSet.next()){
                return new Spitter(resultSet.getLong("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("updateByEmail"));
            }
            return null;

        });
        return spitter;
    }

    @Override
    public List<Spitter> findAllSpitters() {
        List<Spitter> spitters = jdbcOperations.query(SQL_SELECT_SPITTERS, (resultSet) -> {
            List<Spitter> list = new ArrayList<>();
            while (resultSet.next()) {
                Spitter s = new Spitter(resultSet.getLong("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("updateByEmail"));
                list.add(s);
            }
            return list;
        });
        return spitters;
    }

    @Override
    public Spitter saveSpitter(Spitter spitter) {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("username", spitter.getUsername());
        paraMap.put("password", spitter.getPassword());
        paraMap.put("fullname", spitter.getFullName());
        paraMap.put("email", spitter.getEmail());
        paraMap.put("updatebyemail", spitter.getUpdateByEmail());

        int update = jdbcOperations.update(SQL_SAVE_SPITTER, paraMap);
        log.info("update: " + update);
        if(update == 1){
            return findLastOne();
        }
        return null;
    }

    @Override
    public Spitter findLastOne() {
        Spitter result = jdbcOperations.query(SQL_FIND_LASTONE, (r) -> {
            Spitter spitter = null;
            if (r.next()) {
                spitter = new Spitter(r.getLong("id"),
                        r.getString("fullName"),
                        r.getString("username"),
                        r.getString("password"),
                        r.getString("email"),
                        r.getBoolean("updateByEmail"));
            }
            return spitter;
        });
        return result;
    }

    @Override
    public void deleteSpitterById(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        int update = jdbcOperations.update(SQL_DELETE_BY_ID, map);
        log.info("delete: " + update);

    }

}
