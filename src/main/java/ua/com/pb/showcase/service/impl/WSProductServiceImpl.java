package ua.com.pb.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.service.WSProductService;

import java.util.List;

@Service
public class WSProductServiceImpl implements WSProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productDao.findById(id);
    }

    @Override
    public long addProduct(Product product) {
        return productDao.create(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.update(product);
    }

    @Override
    public int deleteProductById(long id) {
        return productDao.delete(id);
    }

}
