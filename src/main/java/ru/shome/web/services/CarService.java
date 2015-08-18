package ru.shome.web.services;

import java.util.List;

import ru.shome.web.beans.Car;

public interface CarService {

	void saveCar(Car car);
	List<Car> getCarList(int first,int last);
	Car getLastCar();
}
