package ua.com.pb.showcase.service;

import org.springframework.stereotype.Service;
import ua.com.pb.showcase.dao.entity.Product;

import java.util.List;

@Service
public interface WSProductService {
    List<Product> getAllProducts();

    Product getProduct(long id);

    long addProduct(Product product);

    int updateProduct(Product product);

    int deleteProductById(long id);

}
