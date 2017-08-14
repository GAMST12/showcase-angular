package ua.com.pb.showcase.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.model.ProducerRowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcProducerDaoImpl extends JdbcDaoSupport implements ProducerDao{

    @Override
    public List<Producer> findAll() {
        String sql = "select pdc_producer_id, pdc_producer, pdc_address from Producer";

        List<Producer> producers = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Producer producer = new Producer();
            producer.setId(Integer.parseInt(String.valueOf(row.get("pdc_producer_id"))));
            producer.setName((String) row.get("pdc_producer"));
            producer.setAddress((String) row.get("pdc_address"));
            producers.add(producer);
        }
        return producers;
    }

    @Override
    public Producer findById(long id) {
        String sql = "select pdc_producer_id, pdc_producer, pdc_address from Producer where pdc_producer_id = ?";

        Producer producer = (Producer)getJdbcTemplate().queryForObject(
                sql, new Object[] { id }, new ProducerRowMapper());
        return producer;
    }

    @Override
    public Producer findByName(String name) {
        String sql = "select pdc_producer_id, pdc_producer, pdc_address from Producer where pdc_producer = ?";

        Producer producer = (Producer)getJdbcTemplate().queryForObject(
                sql, new Object[] { name }, new ProducerRowMapper());
        return producer;

    }

    @Override
    public long create(Producer producer) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());
        jdbcInsert.withTableName("Producer").usingGeneratedKeyColumns(
                "pdc_producer_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("pdc_producer", producer.getName());
        parameters.put("pdc_address", producer.getAddress());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(
                parameters));
        return key.longValue();

    }

    @Override
    public int update(Producer producer) {
        String sql = "update Producer set pdc_producer = ?, pdc_address = ? where pdc_producer_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{producer.getName(), producer.getAddress(), producer.getId()});
    }

    @Override
    public int delete(long producerId) {
        String sql = "delete from Producer where pdc_producer_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{producerId});
    }
}
