package com.springapp.mvc.service;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.dto.UserDto;
import com.springapp.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by boro on 02.05.15.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userDto) throws Exception {
        if (emailExist(userDto.getUsername())) {
            throw new Exception("There is an account with that username : " +
                    userDto.getUsername());
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setAge(userDto.getAge());
        userDao.create(user);
        return user;
    }
    private boolean emailExist(String username) throws SQLException, IOException, ClassNotFoundException {
        User user = userDao.findByUserName(username);
        if (user != null) {
            return true;
        }
        return false;
    }
}