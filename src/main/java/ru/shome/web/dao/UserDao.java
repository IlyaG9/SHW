
package ru.shome.web.dao;

import ru.shome.web.beans.User;

/**
 * Smart Home Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface UserDao {

   User getUser(String firstName);
   void saveUser(User user);
}
