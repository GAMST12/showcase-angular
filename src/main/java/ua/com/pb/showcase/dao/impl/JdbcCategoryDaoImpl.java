package ua.com.pb.showcase.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ua.com.pb.showcase.dao.CategoryDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.model.CategoryRowMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class JdbcCategoryDaoImpl extends JdbcDaoSupport implements CategoryDao {
    @Override
    public List<Category> findAll() {
        String sql = "select ctg_category_id, ctg_category, mnc_mcategory_id, mnc_mcategory " +
                "from Category, Main_category " +
                "where ctg_mcategory_id = mnc_mcategory_id ";


        List<Category> categories = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Category category = new Category();
            category.setId(Integer.parseInt(String.valueOf(row.get("ctg_category_id"))));
            category.setName((String) row.get("ctg_category"));
            category.setMainCategory(new MainCategory(Integer.parseInt(String.valueOf(row.get("mnc_mcategory_id"))), (String) row.get("mnc_mcategory")));
            categories.add(category);
        }
        return categories;

    }

    @Override
    public Category findById(long id) {
        String sql = "select ctg_category_id, ctg_category, mnc_mcategory_id, mnc_mcategory " +
                "from Category, Main_category " +
                "where ctg_mcategory_id = mnc_mcategory_id " +
                "and ctg_category_id = ? ";
        Category category = (Category)getJdbcTemplate().queryForObject(
                sql, new Object[] { id }, new CategoryRowMapper());
        return category;


    }

    @Override
    public Category findByName(String name) {
        String sql = "select ctg_category_id, ctg_category, mnc_mcategory_id, mnc_mcategory " +
                "from Category, Main_category " +
                "where ctg_mcategory_id = mnc_mcategory_id " +
                "and ctg_category = ? ";
        Category category = (Category)getJdbcTemplate().queryForObject(
                sql, new Object[] { name }, new CategoryRowMapper());
        return category;

    }

    @Override
    public List<Category> findByMainCategoryId(long mainCategoryId) {
        String sql = "select ctg_category_id, ctg_category, mnc_mcategory_id, mnc_mcategory " +
                "from Category, Main_category " +
                "where ctg_mcategory_id = mnc_mcategory_id " +
                "and mnc_mcategory = ?";

        List<Category> categories = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Category category = new Category();
            category.setId(Integer.parseInt(String.valueOf(row.get("ctg_category_id"))));
            category.setName((String) row.get("ctg_category"));
            category.setMainCategory(new MainCategory(Integer.parseInt(String.valueOf(row.get("mnc_mcategory_id"))), (String) row.get("mnc_mcategory")));
            categories.add(category);
        }
        return categories;


    }

    @Override
    public long create(Category category) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());
        jdbcInsert.withTableName("Category").usingGeneratedKeyColumns(
                "ctg_category_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ctg_category", category.getName());
        parameters.put("ctg_mcategory_id", category.getMainCategory().getId());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(
                parameters));
        return key.longValue();

    }

    @Override
    public int update(Category category) {
        String sql = "update Category set ctg_category = ?, ctg_mcategory_id = ? where ctg_category_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{category.getName(), category.getMainCategory().getId(), category.getId()});

    }

    @Override
    public int delete(long categoryId) {
        String sql = "delete from Category  where ctg_category_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{categoryId});

    }
}
