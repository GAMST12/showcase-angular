package ua.com.pb.showcase.model;

import org.springframework.jdbc.core.RowMapper;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.MainCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("ctg_category_id"));
        category.setName(resultSet.getString("ctg_category"));
        category.setMainCategory(new MainCategory(resultSet.getLong("mnc_mcategory_id"), resultSet.getString("mnc_mcategory")));
        return category;

    }
}
