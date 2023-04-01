package com.example.shoepping.dao;

import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.exception.DAOException;
import com.example.shoepping.model.User;

import java.io.IOException;
import java.sql.*;


public class UserDAOJDBC implements UserDao {

    @Override
    public boolean checkLogin(User instance) throws SQLException, ClassNotFoundException, IOException {

        int rs;
        Connection conn = DaoUtility.prepareQuery();

        // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
        rs = SimpleQueries.selectUser(conn, instance.getUsername(), instance.getPassword());

        return rs == 1;
    }

    @Override
    public boolean checkExistence(User instance) throws ClassNotFoundException, SQLException, IOException {
        int rs;
        Connection conn = DaoUtility.prepareQuery();

        // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
        rs = SimpleQueries.checkUserExistence(conn, instance.getUsername());

        return rs == 1;
    }

    public void addUser(User instance) throws ClassNotFoundException, SQLException, IOException, DAOException {

        Connection conn = DaoUtility.prepareQuery();

        // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
        SimpleQueries.insertUser(conn, instance.getUsername(), instance.getPassword(), instance.getEmail());
    }
}