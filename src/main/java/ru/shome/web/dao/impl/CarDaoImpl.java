package ru.shome.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ru.shome.web.beans.Car;
import ru.shome.web.dao.AbstractDao;
import ru.shome.web.dao.CarDao;

@Repository
public class CarDaoImpl extends AbstractDao<Car> implements CarDao {

	public CarDaoImpl() {
		super(Car.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Car getLastCar() {
		Car car = null;
		Query query = getSession().createQuery("from Car");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Car> list = query.list();
		if (list != null && !list.isEmpty()) {
			car = list.get(0);
		}
		return car;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getWithPagination(int start, int max) {
		Query query = getSession().createQuery("from Car");
		query.setFirstResult(start);
		query.setMaxResults(max);
		return query.list();
	}

}
