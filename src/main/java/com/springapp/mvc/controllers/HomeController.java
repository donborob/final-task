package com.springapp.mvc.controllers;

import com.springapp.mvc.dto.UserDto;
import com.springapp.mvc.models.User;
import com.springapp.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by boro on 30.04.15.
 */
@Controller
public class HomeController {
    @RequestMapping(value ="/home",method = {RequestMethod.GET, RequestMethod.HEAD})
    public String home() {
        return "Home/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "Home/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user")UserDto accountDto,
                                            BindingResult result, WebRequest request) {
        User registered = new User();
        //TODO validation

        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("username", "message.regError","Username already exists");
        }
        if (result.hasErrors()) {
            return new ModelAndView("Home/registration", "user", accountDto);
        }
        else {
            return new ModelAndView("Home/index", "user", registered);
        }
    }
    private User createUserAccount(UserDto accountDto, BindingResult result) {
        UserService service = new UserService();
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (Exception e) {
            return null;
        }
        return registered;
    }
}
