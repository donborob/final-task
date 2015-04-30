package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by boro on 30.04.15.
 */
@Controller
public class HomeController {
    @RequestMapping(value ="/",method = {RequestMethod.GET, RequestMethod.HEAD})
    public String home() {
        return "Home/index";
    }
}
