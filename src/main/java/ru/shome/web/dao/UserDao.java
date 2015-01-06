
package ru.shome.web.dao;

import ru.shome.web.beans.User;
import ru.shome.web.services.UserService;

/**
 * Smart Homne Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface UserDao {

   public User getUser(String firstName);
   public Boolean isUserValid(User user);
}
