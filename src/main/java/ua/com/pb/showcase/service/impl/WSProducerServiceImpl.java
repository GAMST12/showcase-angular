package ua.com.pb.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.service.WSProducerService;

import java.util.List;

@Service
public class WSProducerServiceImpl implements WSProducerService{
    @Autowired
    private ProducerDao producerDao;

    @Override
    public List<Producer> getAllProducers() {
        return producerDao.findAll();
    }

    @Override
    public Producer getProducer(long id) {
        return producerDao.findById(id);
    }

    @Override
    public long addProducer(Producer producer) {
        return producerDao.create(producer);
    }

    @Override
    public int updateProducer(Producer producer) {
        return producerDao.update(producer);
    }

    @Override
    public int deleteProducerById(long id) {
        return producerDao.delete(id);
    }
}
