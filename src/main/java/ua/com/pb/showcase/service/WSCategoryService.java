package ua.com.pb.showcase.service;

import ua.com.pb.showcase.dao.entity.Category;

import java.util.List;

public interface WSCategoryService {
    List<Category> getAllCategories();

    Category getCategory(long id);

    long addCategory(Category category);

    int updateCategory(Category category);

    int deleteCategoryById(long id);
}
