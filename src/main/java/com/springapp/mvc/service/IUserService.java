package com.springapp.mvc.service;

import com.springapp.mvc.dto.UserDto;
import com.springapp.mvc.models.User;

/**
 * Created by boro on 02.05.15.
 */
    public interface IUserService {
        User registerNewUserAccount(UserDto accountDto)
                throws Exception;

}
