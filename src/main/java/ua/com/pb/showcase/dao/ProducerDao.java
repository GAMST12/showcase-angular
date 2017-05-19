package ua.com.pb.showcase.dao;

import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.dao.entity.Producer;

import java.util.List;

public interface ProducerDao {

    List<Producer> findAll();
    Producer findById(long id);
    Producer findByName(String name);
    long create(Producer producer);
    int update(Producer producer);
    int delete(long producerId);
}
