package ua.com.pb.showcase.dao;

import ua.com.pb.showcase.dao.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    Category findById(long id);
    Category findByName(String name);
    List<Category> findByMainCategoryId(long mainCategoryId);
    long create(Category category);
    int update(Category category);
    int delete(long categoryId);

}
