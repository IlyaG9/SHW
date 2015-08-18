package ru.shome.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.shome.web.beans.Car;
import ru.shome.web.dao.AbstractDao;
import ru.shome.web.dao.CarDao;

@Repository
@Transactional
public class CarDaoImpl extends AbstractDao implements CarDao{

	
	@Autowired
	public CarDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Car getLastCar() {
		Car car=null;
		Query query = getCurrentSession().createQuery("from Car");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Car> list = query.list();
		if(list!=null&&!list.isEmpty()){
			car=list.get(0);
		}
		return car;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getWithPagination(int start, int max) {
		Query query = getCurrentSession().createQuery("from Car");
		query.setFirstResult(start);
		query.setMaxResults(max);
		return query.list();
	}

}
