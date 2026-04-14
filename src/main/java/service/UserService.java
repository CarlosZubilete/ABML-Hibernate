package service;

import entity.User;
import repository.Repository;

public class UserService extends GenericService<User>{

    public UserService(){
        super(new Repository<>(User.class));
    }

}
