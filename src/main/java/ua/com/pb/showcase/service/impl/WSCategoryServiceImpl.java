package ua.com.pb.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.showcase.dao.CategoryDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.service.WSCategoryService;

import java.util.List;

@Service
public class WSCategoryServiceImpl implements WSCategoryService{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategory(long id) {
        return categoryDao.findById(id);
    }

    @Override
    public long addCategory(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public int deleteCategoryById(long id) {
        return categoryDao.delete(id);
    }

}
