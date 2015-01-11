package ru.shome.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.shome.web.services.UserService;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Controller
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
    public String registartion() {

        return "registration";
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
