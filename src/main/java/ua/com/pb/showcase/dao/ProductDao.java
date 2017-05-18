package ua.com.pb.showcase.dao;

import ua.com.pb.showcase.dao.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();
    Product findById(long id);
    Product findByName(String name);
    List<Product> findByProducerId(long producedId);
    List<Product> findByCategoryId(long categoryId);
    List<Product> findByMainCategoryId(long mainCategoryId);
    long create(Product product);
    int update(Product product);
    int delete(long productId);

}
