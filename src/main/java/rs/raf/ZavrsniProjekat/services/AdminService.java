package rs.raf.ZavrsniProjekat.services;

import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class AdminService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<User> allUsers(){ return this.newsRepositorty.allUsers(); }
}
