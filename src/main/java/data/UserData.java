package data;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    public static List<User> getInitialUsers(){
        List<User> users = new ArrayList<>();

        users.add(new User("lucieri.sofia@example.com", "123456"));
        users.add(new User("fernandez.claudio@hospital.com", "123456"));
        users.add(new User("russo.elena@clinica.com" , "123456"));

        return users;

    }
}
