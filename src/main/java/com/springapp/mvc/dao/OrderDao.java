package com.springapp.mvc.dao;

import com.springapp.mvc.dao.manager.OperationManager;
import com.springapp.mvc.dao.mapper.OrderMapper;
import com.springapp.mvc.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by boro on 23.03.15.
 */
@Repository
public class OrderDao implements Dao<Order> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Order order) throws IOException, SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ORDERS VALUES (DEFAULT,?,?,?)";
        try {
            jdbcTemplate.update(sql, order.getSellerId(), order.getCustomerId(), order.getTotalAmount());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Order get(int id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT * FROM ORDERS WHERE id = " + id;
        Order order = null;
        try {
            order = (Order) jdbcTemplate.query(sql, new OrderMapper()).get(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getAll() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT * FROM ORDERS";
        List<Order> orders = null;
        try {
          orders = jdbcTemplate.query(sql, new OrderMapper());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void update(Order order) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE ORDERS SET sellerId = ?, customerId = ?,  totalAmount = ?  WHERE id = ?";
        try {
            jdbcTemplate.update(sql, order.getSellerId(), order.getCustomerId(), order.getTotalAmount(), order.getId());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM  ORDERS WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT COUNT (*) FROM  ORDERS";
        int count = 0;
        try {
           count = jdbcTemplate.queryForObject(sql, Integer.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
