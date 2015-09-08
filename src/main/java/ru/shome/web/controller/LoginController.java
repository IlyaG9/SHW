package ru.shome.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.shome.web.beans.User;
import ru.shome.web.services.UserService;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/login")
//    public String login(@RequestParam(required = true) String name, @RequestParam(required = true) String password, Model model) {
//
//        if (userService.isUserValid(name, password)) {
//            User user = userService.getUser(name);
//            model.addAttribute("user", user);
//            return "redirect: /";
//        } else {
//            return "userNotFound";
//        }
//
//    }
    @RequestMapping(value = "/registration")
    public String registartion(Model model) {
    	User user=new User();
    	model.addAttribute(user);
        return "registration";
    }
    
    @RequestMapping(value = "/createNewUser", method = RequestMethod.POST)
    public String createNewUser(@Valid User user,BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
    		 return "registration";
    	}
    	userService.saveUser(user);
    	 return "registrationComplite";
    }

    @RequestMapping(value = "/signIn")
    public String signIn() {

        return "signIn";
    }

    @RequestMapping(value = "/userNotFound")
    public String userNotFound() {

        return "userNotFound";
    }
}
