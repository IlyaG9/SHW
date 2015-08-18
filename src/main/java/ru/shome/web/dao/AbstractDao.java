package ru.shome.web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao implements BaseDao{
private SessionFactory sessionFactory;
	
	@Autowired
	public AbstractDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(Object object) {
		getCurrentSession().save(object);
		
	}
}
