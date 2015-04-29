package com.springapp.mvc.validators;

import com.springapp.mvc.models.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by boro on 29.04.15.
 */
public class UserValidator implements Validator {
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "firstname", "name.empty","First Name can't be blank");
        ValidationUtils.rejectIfEmpty(e, "lastname", "name.empty","Last Name can't be blank");
       User user = (User) obj;
        if (user.getAge() <= 0 || !((Integer) user.getAge() instanceof Integer)) {
            e.rejectValue("age", "negativevalue", "Wrong age format");
        }
    }
}
