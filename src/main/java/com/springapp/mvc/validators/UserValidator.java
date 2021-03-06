package com.springapp.mvc.validators;

import com.springapp.mvc.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by boro on 29.04.15.
 */
@Component
public class UserValidator implements Validator {
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "firstname", "name.empty", "First Name can't be blank");
        ValidationUtils.rejectIfEmpty(e, "lastname", "name.empty", "Last Name can't be blank");
        User user = (User) obj;
        try {
            if ((user.getAge() <= 0)) {
                e.rejectValue("age", "negativevalue", "Negative age value");
            }
        } catch (NumberFormatException e1) {
            e.rejectValue("age", "wrong.format", "Wrong age format");
        }
    }
}
