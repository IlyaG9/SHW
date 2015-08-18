package ru.shome.web.dao;

import ru.shome.web.beans.Car;

public interface CarDao extends BaseDao{

	Car getLastCar();
	
	
}
