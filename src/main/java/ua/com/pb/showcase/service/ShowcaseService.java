package ua.com.pb.showcase.service;

import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.model.filter.ProductFilter;
import ua.com.pb.showcase.model.message.ResponseMessage;

import java.util.List;

public interface ShowcaseService {
    /**
     */
    List<Product> getProductsByFilter(ProductFilter productFilter);

}
