package ua.com.pb.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.model.filter.ProductFilter;
import ua.com.pb.showcase.service.ShowcaseService;

import java.util.List;

public class ShowcaseServiceImpl implements ShowcaseService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProductsByFilter(ProductFilter productFilter) {
        System.out.println(productFilter);
        List<Product> products = productDao.findByFilter(productFilter);
        return products;
    }
}
