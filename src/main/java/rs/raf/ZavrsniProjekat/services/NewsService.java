package rs.raf.ZavrsniProjekat.services;

import rs.raf.ZavrsniProjekat.entities.Comments;
import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class NewsService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<News> allNews() { return this.newsRepositorty.allNews(); }

    public News findeNews(Integer id) { return this.newsRepositorty.findeNews(id); }

    public News updateNews(News news, Integer id) { return this.newsRepositorty.updateNews(news, id); }

    public News addNews(News news) { return  this.newsRepositorty.addNews(news); }

    public News deleteNews(Integer id) { return this.newsRepositorty.deleteNews(id); }

    public List<News> searchNews(String text) { return  this.newsRepositorty.searchNews(text); }

    public Comments addComment(Comments comments, Integer id, Integer idKorisnika) { return this.newsRepositorty.addComment(comments, id, idKorisnika); }
}
