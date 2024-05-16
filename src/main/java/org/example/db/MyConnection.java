package org.example.db;

import org.example.common.CommonUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class MyConnection {

    public static Connection connection = null;

    public static Logger logger = Logger.getLogger(String.valueOf(Connection.class));

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/encrypter?useSSL=false","root","root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info(CommonUtils.CONNECTION_SUCCESSFUL);
        return connection;
    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
