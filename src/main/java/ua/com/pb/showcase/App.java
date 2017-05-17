package ua.com.pb.showcase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.*;
import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");

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


        context.stop();
    }

}
