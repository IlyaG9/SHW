
package ru.shome.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Smart Homne Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
@Controller
public class HomePageController {

    
    @RequestMapping(value = {"/","home","index"})
    public String showHomePage(){
    
    return "home";
    }
}
