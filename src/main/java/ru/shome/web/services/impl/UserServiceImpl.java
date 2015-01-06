package ru.shome.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shome.web.beans.User;
import ru.shome.web.dao.UserDao;
import ru.shome.web.services.UserService;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String firstName) {
        return userDao.getUser(firstName);
    }

    @Override
    public Boolean isUserValid(String firstName, String pass) {
        User user = new User(firstName, pass);
        return userDao.isUserValid(user);
    }

}
