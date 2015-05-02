package com.springapp.mvc.dao.mapper;

import com.springapp.mvc.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by boro on 27.03.15.
 */
public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("Id"));
        user.setFirstname(resultSet.getString("FIRSTNAME"));
        user.setLastname(resultSet.getString("LASTNAME"));
        user.setAge(resultSet.getInt("AGE"));

        return user;
    }
}
