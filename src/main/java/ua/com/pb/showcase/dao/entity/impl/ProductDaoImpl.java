package ua.com.pb.showcase.dao.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.dao.entity.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                    "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_available " +
                    "from Product, Producer, Category, Main_category " +
                    "where prd_category_id = ctg_category_id" +
                    "and prd_producer_id = pdc_producer_id" +
                    "and ctg_mcategory_id = mnc_mcategory_id";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                Producer producer = new Producer();
                Category category = new Category();
                MainCategory mainCategory = new MainCategory();

                product.setId(rs.getLong("prd_product_id"));
                product.setName(rs.getString("prd_name"));
                producer.setId(rs.getLong("pdc_producer_id"));
                producer.setProducer(rs.getString("pdc_producer"));
                product.setProducer(producer);
                mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                mainCategory.setName(rs.getString("mnc_mcategory"));
                category.setId(rs.getLong("ctg_category_id"));
                category.setName(rs.getString("ctg_category"));
                category.setMainCategory(mainCategory);
                product.setCategory(category);
                product.setDescription(rs.getString("prd_description"));
                product.setPrice(rs.getBigDecimal("prd_price"));
                product.setAvailable(rs.getBoolean("prd_available"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(long id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByProducer(Producer producer) {
        return null;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return null;
    }

    @Override
    public long create(Product product) {
        return 0;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
