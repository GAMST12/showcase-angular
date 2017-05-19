package ua.com.pb.showcase.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.entity.Producer;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProducerDaoImpl extends JdbcDaoSupport implements ProducerDao{

    @Override
    public List<Producer> findAll() {
        String sql = "select pdc_producer_id, pdc_producer from Producer";

        List<Producer> producers = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Producer producer = new Producer();
            producer.setId(Integer.parseInt(String.valueOf(row.get("pdc_producer_id"))));
            producer.setProducer((String)row.get("pdc_producer"));
            producers.add(producer);
        }
        return producers;
    }

    @Override
    public Producer findById(long id) {
        return null;
    }

    @Override
    public Producer findByName(String name) {
        return null;
    }

    @Override
    public long create(Producer producer) {
        return 0;
    }

    @Override
    public int update(Producer producer) {
        return 0;
    }

    @Override
    public int delete(long producerId) {
        return 0;
    }
}
