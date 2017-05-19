package ua.com.pb.showcase.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ua.com.pb.showcase.dao.MainCategoryDao;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.model.MainCategoryRowMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcMainCategoryDaoImpl extends JdbcDaoSupport implements MainCategoryDao {

    @Override
    public List<MainCategory> findAll() {
        String sql = "select mnc_mcategory_id, mnc_mcategory from Main_category";

        List<MainCategory> mainCategories = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            MainCategory mainCategory = new MainCategory();
            mainCategory.setId(Integer.parseInt(String.valueOf(row.get("mnc_mcategory_id"))));
            mainCategory.setName((String) row.get("mnc_mcategory"));
            mainCategories.add(mainCategory);
        }
        return mainCategories;

    }

    @Override
    public MainCategory findById(long id) {
        String sql = "select mnc_mcategory_id, mnc_mcategory from Main_category " +
                "where mnc_mcategory_id = ?";
        MainCategory mainCategory = (MainCategory)getJdbcTemplate().queryForObject(
                sql, new Object[] { id }, new MainCategoryRowMapper());
        return mainCategory;
                }

    @Override
    public MainCategory findByName(String name) {
        String sql = "select mnc_mcategory_id, mnc_mcategory from Main_category " +
                "where mnc_mcategory = ?";

        MainCategory mainCategory = (MainCategory)getJdbcTemplate().queryForObject(
                sql, new Object[] { name }, new MainCategoryRowMapper());
        return mainCategory;

    }

    @Override
    public long create(MainCategory mainCategory) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());
        jdbcInsert.withTableName("Main_category").usingGeneratedKeyColumns(
                "mnc_mcategory_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("mnc_mcategory", mainCategory.getName());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(
                parameters));
        return key.longValue();

    }

    @Override
    public int update(MainCategory mainCategory) {
        String sql = "update Main_category set mnc_mcategory = ? where mnc_mcategory_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{mainCategory.getName(), mainCategory.getId()});

    }

    @Override
    public int delete(long mainCategoryId) {
        String sql = "delete from Main_category where mnc_mcategory_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{mainCategoryId});
    }
}
