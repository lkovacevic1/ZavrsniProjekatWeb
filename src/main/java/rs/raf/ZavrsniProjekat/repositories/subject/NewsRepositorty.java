package rs.raf.ZavrsniProjekat.repositories.subject;

import rs.raf.ZavrsniProjekat.entities.*;

import java.util.List;

public interface NewsRepositorty {
    //User
    public List<UserTipe> allUserTipes();
    public User findUser(User user);
    //Category
    public List<Category> allCategory();
    public Category addCategory(Category category);
    public Category updateCategory(Category category, Integer id);
    public void deleteCategory(Integer id);
    //News
    public List<News> allNews();
    public News findeNews(Integer id);
    public News addNews(News news);
    public News updateNews(News news, Integer id);
    public News deleteNews(Integer id);
    public List<News> searchNews(String text);
    public Comments addComment(Comments comments, Integer id, Integer idKorisnika);
    //Admin
    public List<User> allUsers();
    public User addUser(User user);
    public User updateUser(User user, Integer id);
    public User changeUserStatus(User user, Integer id);
    //Platforma za citanje
    public List<News> latestNews();
    public List<News> mostPopular();
    public List<News> categoryNews(Integer id);
    public List<WholeNews> wholeNews(Integer id);
    public List<Tag> allTags();
    public List<TagNews> tagNews(Integer id);
}
