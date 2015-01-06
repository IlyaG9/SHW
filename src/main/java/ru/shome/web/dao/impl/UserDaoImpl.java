package ru.shome.web.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;
import ru.shome.web.beans.User;
import ru.shome.web.dao.UserDao;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Service
public class UserDaoImpl implements UserDao {

    private final ArrayList<User> base = new ArrayList<User>();

    public UserDaoImpl() {
        base.add(new User("Илья", "ilya.golovachev9@gmail.com", "pass"));
        for (long i = 1; i <= 10; i++) {
            base.add(new User(i, "FirtsName " + i, "SecondName " + i, new Date(), "Email " + i, true, false, "Password1"));
        }
    }

    @Override
    public User getUser(String firstName) {
        User user = null;
        for (User u : base) {
            if (u.getFirstName().equals(firstName)) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public Boolean isUserValid(User user) {
        boolean result = false;
        for (User u : base) {
            if (u.equals(user)) {
                result = true;
            }
        }
        return result;
    }

}
