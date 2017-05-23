package ua.com.pb.showcase.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.model.filter.ProductFilter;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Product> findAll() {
        String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id ";

        List<Product> products = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();){
            try (ResultSet rs = st.executeQuery(sql);){
                while (rs.next()) {
                    Product product = new Product();
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(long id) {
        String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id " +
                "and prd_product_id = ?";
        Product product = new Product();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findByName(String name) {
        String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id " +
                "and prd_name = ?";
        Product product = new Product();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByProducerId(long producerId) {
        String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id " +
                "and pdc_producer_id = ? ";

        List<Product> products = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setLong(1, producerId);
            try (ResultSet rs = pst.executeQuery();){
                while (rs.next()) {
                    Product product = new Product();
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByCategoryId(long categoryId) {
        String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id " +
                "and ctg_category_id = ? ";

        List<Product> products = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setLong(1, categoryId);
            try (ResultSet rs = pst.executeQuery();){
                while (rs.next()) {
                    Product product = new Product();
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByFilter(ProductFilter productFilter) {
        StringBuilder sqlBuilder = new StringBuilder().append("select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id " +
                "and prd_price >= " + productFilter.getPriceFrom() + " " +
                "and prd_price <= " + productFilter.getPriceTo() + " ");

        if (productFilter.getCategoryId() != 0) {
            sqlBuilder.append("and ctg_category_id  = " + productFilter.getCategoryId() + " ");
        }
        if (productFilter.getProducerId() != 0) {
            sqlBuilder.append("and pdc_producer_id  = " + productFilter.getProducerId() + " ");
        }
        if (productFilter.isOnlyAvailable()) {
            sqlBuilder.append("and prd_fl_availability  = true ");
        }

        System.out.println(sqlBuilder.toString());

        List<Product> products = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();){
            try (ResultSet rs = st.executeQuery(sqlBuilder.toString());){
                while (rs.next()) {
                    Product product = new Product();
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public List<Product> findByMainCategoryId(long mainCategoryId) {
        String sql = "select prd_product_id, prd_name, pdc_producer_id, pdc_producer, ctg_category_id, ctg_category, " +
                "mnc_mcategory_id, mnc_mcategory, prd_description, prd_price, prd_fl_availability " +
                "from Product, Producer, Category, Main_category " +
                "where prd_category_id = ctg_category_id " +
                "and prd_producer_id = pdc_producer_id " +
                "and ctg_mcategory_id = mnc_mcategory_id " +
                "and mnc_mcategory_id = ? ";

        List<Product> products = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setLong(1, mainCategoryId);
            try (ResultSet rs = pst.executeQuery();){
                while (rs.next()) {
                    Product product = new Product();
                    Producer producer = new Producer();
                    Category category = new Category();
                    MainCategory mainCategory = new MainCategory();

                    product.setId(rs.getLong("prd_product_id"));
                    product.setName(rs.getString("prd_name"));
                    producer.setId(rs.getLong("pdc_producer_id"));
                    producer.setName(rs.getString("pdc_producer"));
                    product.setProducer(producer);
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    category.setId(rs.getLong("ctg_category_id"));
                    category.setName(rs.getString("ctg_category"));
                    category.setMainCategory(mainCategory);
                    product.setCategory(category);
                    product.setDescription(rs.getString("prd_description"));
                    product.setPrice(rs.getBigDecimal("prd_price"));
                    product.setAvailable(rs.getBoolean("prd_fl_availability"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public long create(Product product) {
        String sql = "insert into Product(prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability) " +
                "values (?, ?, ?, ?, ?, ?)";
        long productId = 0;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            pst.setString(1, product.getName());
            pst.setLong(2, product.getProducer().getId());
            pst.setLong(3, product.getCategory().getId());
            pst.setString(4, product.getDescription());
            pst.setBigDecimal(5, product.getPrice());
            pst.setBoolean(6, product.isAvailable());
            pst.executeUpdate();
            try (ResultSet rs = pst.getGeneratedKeys();){
                while (rs.next()) {
                    productId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productId;

    }

    @Override
    public int update(Product product) {
        String sql = "update Product " +
                "set prd_name = ? " +
                ", prd_producer_id = ? " +
                ", prd_category_id = ? " +
                ", prd_description = ? " +
                ", prd_price = ? " +
                ", prd_fl_availability = ? " +
                "where prd_product_id = ? ";

        int res = 0;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setString(1, product.getName());
            pst.setLong(2, product.getProducer().getId());
            pst.setLong(3, product.getProducer().getId());
            pst.setString(4, product.getDescription());
            pst.setBigDecimal(5, product.getPrice());
            pst.setBoolean(6, product.isAvailable());
            pst.setLong(7, product.getId());
            res = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(long productId) {
        String sql = "delete from Product " +
                "where prd_product_id= ? ";

        int res = 0;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setLong(1, productId);
            res = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;

    }
}
