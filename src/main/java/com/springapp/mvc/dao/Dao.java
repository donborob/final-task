package com.springapp.mvc.dao;

import com.springapp.mvc.models.Model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by boro on 23.03.15.
 */
public interface Dao<T extends Model> {
   void  create(T t) throws IOException, SQLException, ClassNotFoundException;
    T get(int id) throws SQLException, IOException, ClassNotFoundException;
    List<T> getAll() throws SQLException, IOException, ClassNotFoundException;
    void update(T t) throws SQLException, IOException, ClassNotFoundException;
    void delete(int id) throws SQLException, IOException, ClassNotFoundException;
    int getCount() throws SQLException, IOException, ClassNotFoundException;

}
