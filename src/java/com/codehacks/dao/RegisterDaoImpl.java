package com.codehacks.dao;

import com.codehacks.model.RegisteredUser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author E238958
 */
public class RegisterDaoImpl implements RegisterDAO {

    private final Map<String, RegisteredUser> registeredUser = new HashMap<>();

    private void createRegisteredUsers() {
        RegisteredUser user1 = new RegisteredUser("Tom", "Tom", "Tommy", "tommy@gmail.com", "tom123");
        RegisteredUser user2 = new RegisteredUser("Pat", "Lowe", "Pavlov", "larry@gmail.com", "larry");
        RegisteredUser user3 = new RegisteredUser("John", "Booke", "Johnny", "harry@gmail.com", "harry");
        RegisteredUser user4 = new RegisteredUser("Jude", "Gray", "Glow", "parry@gmail.com", "parry");
        RegisteredUser user5 = new RegisteredUser("Blue", "Tom", "Groovy", "garry@gmail.com", "garry");
        registeredUser.put(user1.getEmail(), user1);
        registeredUser.put(user2.getEmail(), user2);
        registeredUser.put(user3.getEmail(), user3);
        registeredUser.put(user4.getEmail(), user4);
        registeredUser.put(user5.getEmail(), user5);
    }
    
    @Override
    public void registerUser(RegisteredUser user) {
        createRegisteredUsers();
        String email = user.getEmail();
        registeredUser.put(email, user);
        System.out.println(user.toString());
    }

    @Override
    public boolean checkIfUserExist(RegisteredUser user) {
        return registeredUser.containsKey(user.getEmail());
    }

    @Override
    public RegisteredUser getUser(String email) {
        createRegisteredUsers();
        RegisteredUser user = registeredUser.get(email);
        return user;
    }

    @Override
    public void updateUser(RegisteredUser user) {

    }

    @Override
    public boolean deleteUser(String email) {
        createRegisteredUsers();
        RegisteredUser user = registeredUser.get(email);
        return registeredUser.remove(email, user);
    }
}
