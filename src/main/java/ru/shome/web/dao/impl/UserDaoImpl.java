package ru.shome.web.dao.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.shome.web.beans.User;
import ru.shome.web.dao.UserDao;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String firstName) {

		List<User> list = getCurrentSession()
				.createQuery("from User where login = :login")
				.setString("login", firstName).list();
		User user = null;
		if (list.size() > 0) {
			user = (User) list.get(0);
		}
		return user;
	}

	@Override
	public void saveUser(User user) {
		getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = getCurrentSession().createQuery("from User ").list();

		return list;
	}

	@Override
	public User getUserById(Long id) {
		User object = (User) getCurrentSession().get(User.class, id);
		return object;
	}

}
