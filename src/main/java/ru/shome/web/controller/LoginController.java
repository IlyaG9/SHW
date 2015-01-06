package ru.shome.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(@RequestParam(required = true) String name,@RequestParam(required = true) String password) {
        String n=name;
        String p=password;
        int i=0;
        return "home";
    }
    @RequestMapping(value = "/registration")
    public String registartion(){
    
        return "home";
    }
}
