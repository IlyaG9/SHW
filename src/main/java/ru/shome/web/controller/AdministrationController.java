package ru.shome.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.shome.web.beans.User;
import ru.shome.web.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/users" })
	public String getUsers(Model model) {
		List<User> users = userService.getUserAllUsers();
		model.addAttribute("users", users);
		return "adminUsers";
	}

	@RequestMapping(value = { "/userEdit/{id}" })
	public String editUser(@PathVariable Long id, Model model) {
		User user = userService.getUserById(id);
		if (user != null) {
			model.addAttribute("user", user);

			return "userEdit";
		} else {
			return "redirect: ../user/userNotFound";
		}
	}

	@RequestMapping(value = { "/userExecuteEdit" }, method = RequestMethod.POST)
	public String executeEdit(@Valid User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "userEdit";
		}
		userService.saveUser(user);
		List<User> users = userService.getUserAllUsers();
		model.addAttribute("users", users);
		return "adminUsers";
	}
}
