package com.springapp.mvc.dao;


import com.springapp.mvc.dao.manager.OperationManager;
import com.springapp.mvc.dao.mapper.UserMapper;
import com.springapp.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by boro on 23.03.15.
 */
@Repository
public class UserDao implements Dao<User> {
    Map<String, Object> map;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.map = new HashMap<String, Object>();


    }

    @Override
    public void create(User user) throws IOException, SQLException, ClassNotFoundException {
        String sql = "INSERT INTO USERS VALUES (DEFAULT,:firstname,:lastname,:age)";
        map.put("firstname", user.getFirstname());
        map.put("lastname", user.getLastname());
        map.put("age", user.getAge());
        try {
            jdbcTemplate.update(sql, map) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT * FROM USERS WHERE id = " + id;
        User user = null;
        try {
         user = (User) jdbcTemplate.query(sql, new UserMapper()).get(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT * FROM USERS";
        List<User> users = null;
        try {
            users = jdbcTemplate.query(sql, new UserMapper()) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE USERS SET firstname = :firstname , lastname = :lastname,  age = :age  WHERE id = :id";
        map.put("firstname", user.getFirstname());
        map.put("lastname", user.getLastname());
        map.put("age", user.getAge());
        map.put("id",user.getId());


        try {
            jdbcTemplate.update(sql, map) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM  USERS WHERE id = :id";
        map.put("id",id);
        try {
            jdbcTemplate.update(sql,map) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT COUNT (*) FROM  USERS";
       int  count = 0;
        try {
           count = jdbcTemplate.queryForObject(sql,map, Integer.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
