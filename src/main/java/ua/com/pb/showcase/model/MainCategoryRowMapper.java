package ua.com.pb.showcase.model;


import org.springframework.jdbc.core.RowMapper;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.dao.entity.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainCategoryRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        MainCategory mainCategory = new MainCategory();
        mainCategory.setId(resultSet.getLong("mnc_mcategory_id"));
        mainCategory.setName(resultSet.getString("mnc_mcategory"));
        return mainCategory;

    }
}
