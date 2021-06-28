package rs.raf.ZavrsniProjekat.services;

import rs.raf.ZavrsniProjekat.entities.Category;
import rs.raf.ZavrsniProjekat.repositories.subject.NewsRepositorty;

import javax.inject.Inject;
import java.util.List;

public class CategoryService {

    @Inject
    private NewsRepositorty newsRepositorty;

    public List<Category> allCategory() { return this.newsRepositorty.allCategory(); }

    public Category addCategory(Category category) { return this.newsRepositorty.addCategory(category); }

    public Category updateCategory(Category category, Integer id) {
        return this.newsRepositorty.updateCategory(category, id);
    }

    public Object deleteCategory(Integer id){
        this.newsRepositorty.deleteCategory(id);
        return null;
    }
}
