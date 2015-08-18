package ru.shome.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.shome.web.beans.Car;
import ru.shome.web.services.CarService;

@Controller
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping(value = "/car")
	public String findCarList(Model model) {
		List<Car> carList = carService.getCarList(0, 10);
		model.addAttribute("cars", carList);
		return "car";
	}
}
