package com.springapp.mvc.validators;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.models.Order;
import com.springapp.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by boro on 30.04.15.
 */
public class OrderValidator {
    @Autowired
    private UserDao userDao;

    public boolean supports(Class clazz) {
        return Order.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) throws SQLException, IOException, ClassNotFoundException {
        Order order = (Order) obj;
        if (order.getTotalAmount() <= 0 || !((Integer) order.getTotalAmount() instanceof Integer)) {
            e.rejectValue("totalAmount", "negativevalue", "Wrong total amount format");
        }
        if (order.getSellerId() <= 0 || !((Integer) order.getSellerId() instanceof Integer)) {
            e.rejectValue("sellerId", "negativevalue", "Wrong seller id format");
        }
        if (order.getCustomerId() <= 0 || !((Integer) order.getCustomerId() instanceof Integer)) {
            e.rejectValue("customerId", "negativevalue", "Wrong customer id format");
        }
        try{
            userDao.get(order.getSellerId());
        }
        catch(Exception e1){
            e.rejectValue("sellerId", "wrongformat", "Seller with current id doesn't exist");
        }
        try{
            userDao.get(order.getCustomerId());
        }
        catch(Exception e1){
            e.rejectValue("customerId", "wrongformat", "Customer with current id doesn't exist");
        }
        if (order.getCustomerId() == order.getSellerId()) {
            e.rejectValue("customerId", "wrongformat", "Customer Id can't be equal Seller Id");
        }



    }
}
