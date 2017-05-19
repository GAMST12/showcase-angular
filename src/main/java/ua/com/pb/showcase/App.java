package ua.com.pb.showcase;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.dao.entity.Product;

import javax.sql.*;
import java.math.BigDecimal;
import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");

        /*
        DataSource dataSource = context.getBean(DataSource.class);

        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        String sql = "select * from Main_Category";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getLong(1));
            System.out.println(rs.getString(2));
        }

        sql = "select * from Category";
        rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getLong(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getLong(3));
        }

        sql = "select * from product";
        rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getLong(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getLong(3));
            System.out.println(rs.getLong(4));
            System.out.println(rs.getString(5));
            System.out.println(rs.getBigDecimal(6));
            System.out.println(rs.getBoolean(7));
        }


        st.close();
        conn.close();

*/
        ProductDao productDao = context.getBean(ProductDao.class);
        ProducerDao producerDao = context.getBean(ProducerDao.class);

        System.out.println(productDao.findAll());

        System.out.println(productDao.findById(2));
        System.out.println(productDao.findByName("Телевизор Sony C40"));

        System.out.println(productDao.findByProducerId(2));
        System.out.println(productDao.findByCategoryId(1));
        System.out.println(productDao.findByMainCategoryId(1));

        Product product = new Product("Телефон LG L500", new Producer(1,"LG"), new Category(8, "Смартфоны", new MainCategory(4, "Телефоны")), "Экран - 5.5 дюймов, 3 Гб ОЗУ, 32 Гб встроенная память", BigDecimal.valueOf(9000.00), true);
        long productId;
        System.out.println(productId = productDao.create(product));

        System.out.println(productDao.findAll());

        Product updatedProduct = productDao.findById(productId);
        System.out.println(updatedProduct);
        updatedProduct.setPrice(BigDecimal.valueOf(10000.00));
        System.out.println(productDao.update(updatedProduct));
        System.out.println(productDao.findAll());

        System.out.println(productDao.delete(productId));
        System.out.println(productDao.findAll());

        System.out.println(producerDao.findAll());

        context.stop();
    }

}
