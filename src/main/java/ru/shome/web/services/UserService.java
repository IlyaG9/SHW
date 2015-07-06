
package ru.shome.web.services;

import ru.shome.web.beans.User;

/**
 * Smart Home Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface UserService {

    public User getUser(String firstName);
    public Boolean isUserValid(String firstName, String pass);
}
