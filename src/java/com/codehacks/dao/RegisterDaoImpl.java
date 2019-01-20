package com.codehacks.dao;

import com.codehacks.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author E238958
 */
public class RegisterDaoImpl implements RegisterDAO {

    private final Map<String, User> registeredUser = new HashMap<>();

    @Override
    public void registerUser(User user) {
        String email = user.getEmail();
        registeredUser.put(email, user);
        System.out.println(user.toString());
    }

    @Override
    public boolean checkIfUserExist(User user) {
        return registeredUser.containsKey(user.getEmail());
    }

    @Override
    public User getUser(String email) {
        User user = registeredUser.get(email);
        return user;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public boolean deleteUser(String email) {
        User user = registeredUser.get(email);
        return registeredUser.remove(email, user);
    }
}
