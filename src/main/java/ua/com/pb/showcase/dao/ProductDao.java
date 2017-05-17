package ua.com.pb.showcase.dao;

import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.dao.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();
    Product findById(long id);
    Product findByName(String name);
    List<Product> findByProducer(Producer producer);
    List<Product> findByCategory(Category category);
    long create(Product product);
    void update(Product product);
    void delete(Product product);


}
