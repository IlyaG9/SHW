
package ru.shome.web.dao;

import java.util.List;

import ru.shome.web.beans.User;

/**
 * Smart Home Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface UserDao {

   User getUser(String firstName);

	void saveUser(User user);

	List<User> getAllUsers();
}
