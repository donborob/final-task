package com.springapp.mvc.controllers;

import com.springapp.mvc.dao.OrderDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.models.Order;
import com.springapp.mvc.models.User;
import com.springapp.mvc.validators.OrderValidator;
import com.springapp.mvc.validators.UserValidator;
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
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class OrderController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderValidator validator;

    @RequestMapping(value = "/orders", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) throws SQLException, IOException, ClassNotFoundException {
        model.addAttribute("orders", orderDao.getAll());
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (User user : userDao.getAll()) {
            map.put(user.getId(), user.getFirstname() + " " + user.getLastname());
        }
        model.addAttribute("map", map);
        return "Order/index";
    }

    @RequestMapping(value = "/order/new", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("order") Order order, BindingResult result, ModelMap model) throws SQLException, IOException, ClassNotFoundException {
        validator.validate(order, result);
        if (result.hasErrors()) {
            model.addAttribute("order", order);
            model.addAttribute("users", userDao.getAll());
            return "Order/new";
        }
        orderDao.create(order);
        return "redirect:/orders";
    }

    @RequestMapping(value = "/order/new", method = RequestMethod.GET)
    public String newOrder(ModelMap model) throws SQLException, IOException, ClassNotFoundException {
        model.addAttribute("order", new Order());
        model.addAttribute("users", userDao.getAll());
        return "Order/new";
    }

    @RequestMapping(value = "/order/edit/{orderId}", method = RequestMethod.GET)
    public String editOrder(ModelMap model, @PathVariable("orderId") Integer orderId) throws SQLException, IOException, ClassNotFoundException {
        model.addAttribute("order", orderDao.get(orderId));
        model.addAttribute("users", userDao.getAll());
        return "Order/edit";
    }

    @RequestMapping("/order/delete/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Integer orderId) throws SQLException, IOException, ClassNotFoundException {

        orderDao.delete(orderId);

        return "redirect:/orders";
    }

    @RequestMapping(value = "/order/edit/{orderId}", method = RequestMethod.POST)
    public String updateOrder(@PathVariable("orderId") Integer orderId, @ModelAttribute("order") Order order, BindingResult result, ModelMap model) throws SQLException, IOException, ClassNotFoundException {
        order.setId(orderId);
        validator.validate(order, result);
        if (result.hasErrors()) {
            model.addAttribute("order", order);
            model.addAttribute("users", userDao.getAll());
            return "Order/edit";
        }
        orderDao.update(order);

        return "redirect:/orders";
    }
}
