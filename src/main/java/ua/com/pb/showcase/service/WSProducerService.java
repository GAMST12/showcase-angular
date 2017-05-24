package ua.com.pb.showcase.service;

import ua.com.pb.showcase.dao.entity.Producer;

import java.util.List;

public interface WSProducerService {
    List<Producer> getAllProducers();

    Producer getProducer(long id);

    long addProducer(Producer producer);

    int updateProducer(Producer producer);

    int deleteProducerById(long id);
}
