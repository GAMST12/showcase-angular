package ua.com.pb.showcase.model;


import org.springframework.jdbc.core.RowMapper;
import ua.com.pb.showcase.dao.entity.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProducerRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Producer producer = new Producer();
        producer.setId(resultSet.getLong("pdc_producer_id"));
        producer.setName(resultSet.getString("pdc_producer"));
        producer.setAddress(resultSet.getString("pdc_address"));
        return producer;
    }
}
