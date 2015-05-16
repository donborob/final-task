package com.springapp.mvc.dao.manager;

import com.springapp.mvc.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by boro on 23.03.15.
 */
@Repository
public class OperationManager{
    private Connection connection;

    @Autowired
    private DataSource dataSource;

    public Connection setConnection() throws IOException, SQLException, ClassNotFoundException {
        connection = dataSource.getConnection();
        return connection;
    }

    public void closeConnection() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
