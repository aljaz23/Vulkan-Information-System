/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasilskodrustvo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CinDaoImpl {
    String dbURL = "jdbc:ucanaccess://D:/NetBeans - programiranje/clan.accdb";
    String SQL_GET_ALL = "SELECT id, naziv FROM Cin order by id";
    String SQL_GET_BY_ID = "SELECT id,naziv FROM Cin WHERE id=?";

    
    public ArrayList<Cin> getAllCin() {
        Connection conn;
        Statement stmt;
        ResultSet rs;

        ArrayList<Cin> cn = new ArrayList();
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            while (rs.next()) {
                cn.add(new Cin(rs.getInt("id"), rs.getString("naziv")));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return cn;
    }

      public Cin getCinById(int id) {

        Cin cn = new Cin();
        Connection conn;
        PreparedStatement preparedStatement;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection(dbURL);
            preparedStatement = conn.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cn.setId(id);
                cn.setNaziv(rs.getString("naziv"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return cn;
    }
}
