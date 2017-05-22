package ua.com.pb.showcase.dao;


import org.springframework.stereotype.Component;
import ua.com.pb.showcase.dao.entity.MainCategory;

import java.util.List;

public interface MainCategoryDao {

    List<MainCategory> findAll();
    MainCategory findById(long id);
    MainCategory findByName(String name);
    long create(MainCategory mainCategory);
    int update(MainCategory mainCategory);
    int delete(long mainCategoryId);

}
