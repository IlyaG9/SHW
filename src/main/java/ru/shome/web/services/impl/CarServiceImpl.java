package ru.shome.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.shome.web.beans.Car;
import ru.shome.web.dao.CarDao;
import ru.shome.web.services.CarService;


//@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;

	@Override
	public void saveCar(Car car) {
		if (car.getLink() != null && car.getPrice() != null) {
			carDao.save(car);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getCarList(int first, int last) {
		return carDao.getWithPagination(first, last);
	}

	@Override
	public Car getLastCar() {
		return carDao.getLastCar();
	}

}
