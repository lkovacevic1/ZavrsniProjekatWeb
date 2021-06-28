package rs.raf.ZavrsniProjekat.services.platformaService;

import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.entities.WholeNews;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class HomePageService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<News> latestNews() { return this.newsRepositorty.latestNews(); }

    public List<News> mostPopular() { return  this.newsRepositorty.mostPopular(); }

    public List<News> kategoryNews(Integer category) { return this.newsRepositorty.categoryNews(category); }

}
