package ru.shome.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.shome.web.beans.User;
import ru.shome.web.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/users" })
	public String getUsers(Model model) {
		List<User> users=userService.getUserAllUsers();
		model.addAttribute("users", users);
		return "adminUsers";
	}
}
