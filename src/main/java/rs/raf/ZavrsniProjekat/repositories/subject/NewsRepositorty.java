package rs.raf.ZavrsniProjekat.repositories.subject;

import rs.raf.ZavrsniProjekat.entities.Category;
import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.entities.UserTipe;

import java.util.List;

public interface NewsRepositorty {
    //User
    public List<UserTipe> allUserTipes();
    public User findUser(String email, String password);
    //Category
    public List<Category> allCategory();
    public Category addCategory(Category category);
    public void updateCategory(Category category, Integer id);
    public void deleteCategory(Integer id);
    //News
    public List<News> allNews();
    public News addNews(News news);
    public News deleteNews(Integer id);
    public List<News> searchNews(String text);
    //Admin
    public List<User> allUsers();
    public User addUser(User user);
    public User updateUser(User user, Integer id);
    public User changeUserStatus(User user, Integer id);
}
