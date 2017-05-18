package ua.com.pb.showcase.dao;


import ua.com.pb.showcase.dao.entity.MainCategory;

import java.util.List;

public interface MainCategoryDao {
    List<MainCategory> findAll();
    MainCategory findById(long id);
    MainCategory findByName(String name);
    long create(MainCategory product);
    int update(MainCategory product);
    int delete(long productId);

}
