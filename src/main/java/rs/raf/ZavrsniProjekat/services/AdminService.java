package rs.raf.ZavrsniProjekat.services;

import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class AdminService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<User> allUsers(){ return this.newsRepositorty.allUsers(); }

    public User addUser(User user){ return this.newsRepositorty.addUser(user); }

    public User updateUser(User user, Integer id) { return this.newsRepositorty.updateUser(user, id); }

    public User changeUserStatus(User user, Integer id) { return this.newsRepositorty.changeUserStatus(user, id); }
}
