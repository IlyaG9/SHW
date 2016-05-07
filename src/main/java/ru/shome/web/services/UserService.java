
package ru.shome.web.services;

import java.util.List;

import ru.shome.web.beans.User;

/**
 * Smart Home Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface UserService {

	public User getUserById(Long id);
    public User getUser(String firstName);
    public Boolean isUserValid(String firstName, String pass);
    public void saveUser(User user);
    public List<User> getUserAllUsers();
}
