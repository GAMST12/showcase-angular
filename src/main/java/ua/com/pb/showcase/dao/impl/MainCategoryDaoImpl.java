package ua.com.pb.showcase.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.pb.showcase.dao.MainCategoryDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.MainCategory;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.dao.entity.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainCategoryDaoImpl implements MainCategoryDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<MainCategory> findAll() {
        String sql = "select mnc_mcategory_id, mnc_mcategory from Main_category";

        List<MainCategory> mainCategoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();){
            try (ResultSet rs = st.executeQuery(sql);){
                while (rs.next()) {
                    MainCategory mainCategory = new MainCategory();

                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                    mainCategoryList.add(mainCategory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainCategoryList;

    }

    @Override
    public MainCategory findById(long id) {
        String sql = "select mnc_mcategory_id, mnc_mcategory " +
                "where mnc_mcategory_id = ?";
        MainCategory mainCategory = new MainCategory();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);){
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    mainCategory.setId(rs.getLong("mnc_mcategory_id"));
                    mainCategory.setName(rs.getString("mnc_mcategory"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainCategory;

    }

    @Override
    public MainCategory findByName(String name) {
        return null;
    }

    @Override
    public long create(MainCategory product) {
        return 0;
    }

    @Override
    public int update(MainCategory product) {
        return 0;
    }

    @Override
    public int delete(long productId) {
        return 0;
    }
}
