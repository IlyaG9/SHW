package ru.shome.web.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDao<T> implements BaseDao<T>{
	@Autowired
	private SessionFactory sessionFactory;

	private Class<? extends T> entity;

	public AbstractDao(Class<? extends T> target) {
		entity = target;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void createOrUpdate(T object) {

		getSession().saveOrUpdate(object);

	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		try {
			return getSession().createCriteria(entity).list();
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		return (T) getSession().get(entity, id);
	}
}
