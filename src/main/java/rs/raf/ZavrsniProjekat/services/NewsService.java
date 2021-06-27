package rs.raf.ZavrsniProjekat.services;

import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class NewsService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<News> allNews() { return this.newsRepositorty.allNews(); }

    public News addNews(News news) { return  this.newsRepositorty.addNews(news); }

    public News deleteNews(Integer id) { return this.newsRepositorty.deleteNews(id); }

    public List<News> searchNews(String text) { return  this.newsRepositorty.searchNews(text); }
}
