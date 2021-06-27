package rs.raf.ZavrsniProjekat.services;

import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.entities.UserTipe;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class UserService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<UserTipe> allUserTipes(){ return this.newsRepositorty.allUserTipes(); }

    public User findUser(String email, String password){ return this.newsRepositorty.findUser(email, password); }
    public User addUser(User user){ return this.newsRepositorty.addUser(user); }
}
