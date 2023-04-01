
package com.example.shoepping.dao.queries;


import com.example.shoepping.exception.DAOException;

import java.sql.*;

public class SimpleQueries {

    private SimpleQueries() {
        throw new IllegalStateException("Utility class");
    }


    public static int selectUser(Connection conn, String username, String passd) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call login(?,?,?)}");
        cs.setString(1, username);
        cs.setString(2, passd);
        cs.registerOutParameter(3, Types.NUMERIC);
        cs.executeQuery();
        return cs.getInt(3);
    }

    public static void insertUser(Connection conn, String username, String passd, String email) throws DAOException {
        try {
            CallableStatement cs = conn.prepareCall("{call addNewUser(?, ?, ?)}");
            cs.setString(1, username);
            cs.setString(2, passd);
            cs.setString(3, email);

            cs.executeQuery();
        }catch (SQLException e){
            throw new DAOException("Failed insert: " + e.getMessage());
        }

    }

    public static int checkUserExistence(Connection conn, String username) throws SQLException {

        CallableStatement cs = conn.prepareCall("{call checkUserExistence(?, ?)}");
        cs.setString(1, username);
        cs.registerOutParameter(2, Types.NUMERIC);

        cs.executeQuery();
        return cs.getInt(2);
    }
}