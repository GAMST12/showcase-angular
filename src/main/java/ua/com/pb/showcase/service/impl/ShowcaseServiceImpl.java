package ua.com.pb.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.showcase.dao.CategoryDao;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.model.filter.ProductFilter;
import ua.com.pb.showcase.service.ShowcaseService;

import java.util.List;

@Service
public class ShowcaseServiceImpl implements ShowcaseService{
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();

    }
}
