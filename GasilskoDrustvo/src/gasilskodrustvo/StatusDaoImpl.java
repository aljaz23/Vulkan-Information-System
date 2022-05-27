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

/**
 *
 * @author aljaz
 */
public class StatusDaoImpl {

    String dbURL = "jdbc:ucanaccess://D:/NetBeans - programiranje/clan.accdb";
    String SQL_GET_ALL = "SELECT id, naziv FROM Status order by id";
    String SQL_GET_BY_ID = "SELECT id,naziv FROM Status WHERE id=?";

    public ArrayList<Status> getAllStatus() {
        Connection conn;
        Statement stmt;
        ResultSet rs;

        ArrayList<Status> stat = new ArrayList();
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            while (rs.next()) {
                stat.add(new Status(rs.getInt("id"), rs.getString("naziv")));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return stat;
    }

    public Status getStatusById(int id) {

        Status stat = new Status();
        Connection conn;
        PreparedStatement preparedStatement;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection(dbURL);
            preparedStatement = conn.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                stat.setId(id);
                stat.setNaziv(rs.getString("naziv"));
            }

            rs.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return stat;
    }
}
