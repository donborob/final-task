package com.springapp.mvc.controllers;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value ="/",method = {RequestMethod.GET, RequestMethod.HEAD})
    public String printWelcome(ModelMap model) {
        return "redirect:/users";
    }

    @RequestMapping(value ="/users" ,method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) throws SQLException, IOException, ClassNotFoundException {
        model.addAttribute("users", userDao.getAll());
        return "index";
    }
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user) throws SQLException, IOException, ClassNotFoundException {
        userDao.create(user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUser(ModelMap model,@PathVariable("userId") Integer userId) throws SQLException, IOException, ClassNotFoundException {
        model.addAttribute("user", userDao.get(userId));
        return "edit";
    }

    @RequestMapping("/delete/{userId}")
       public String deleteUser(@PathVariable("userId") Integer userId) throws SQLException, IOException, ClassNotFoundException {

        userDao.delete(userId);

        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("userId") Integer userId, @ModelAttribute("user") User user) throws SQLException, IOException, ClassNotFoundException {

        userDao.update(user);

        return "redirect:/users";
    }
}