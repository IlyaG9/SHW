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

import ru.shome.web.beans.Setting;
import ru.shome.web.beans.SettingValue;
import ru.shome.web.beans.User;
import ru.shome.web.services.SettingsService;
import ru.shome.web.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

	@Autowired
	UserService userService;
	@Autowired
	SettingsService settingsService;

	@RequestMapping(value = { "/users" })
	public String getUsers(Model model) {
		List<User> users = userService.getUserAllUsers();
		model.addAttribute("users", users);
		return "adminUsers";
	}
	@RequestMapping(value = { "/settings" })
	public String getSettings(Model model) {
		List<Setting> settings = settingsService.getAllSettings();
		model.addAttribute("settings", settings);
		return "settings";
	}
	@RequestMapping(value = { "/changeSettings" })
	public String changeSettings(Model model) {
	
		Setting s=new Setting();
		s.setIdentifier("TESTinteger");
		SettingValue value=new SettingValue();
		value.setValue(1);
		s.setValue(value);
		
		Setting s2=new Setting();
		s2.setIdentifier("TESTdouble");
		SettingValue value2=new SettingValue();
		value2.setValue(5.55);
		s2.setValue(value2);
		
		Setting s3=new Setting();
		s3.setIdentifier("TESTString");
		SettingValue valu3=new SettingValue();
		valu3.setValue("some setting");
		s3.setValue(valu3);
		
		Setting s4=new Setting();
		s4.setIdentifier("TESTboolean");
		SettingValue valu43=new SettingValue();
		valu43.setValue(true);
		s4.setValue(valu43);
		
		settingsService.save(s);
		settingsService.save(s2);
		settingsService.save(s3);
		settingsService.save(s4);
		
		List<Setting> settings = settingsService.getAllSettings();
		model.addAttribute("settings", settings);
		return "settings";
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
