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
public class ClanDaoImpl {

    String dbURL = "jdbc:ucanaccess://D:/NetBeans - programiranje/clan.accdb";
    String SQL_GET_BY_ID = "SELECT ImePriimek, Starost, Ulica, datumRojstva, telSt, Clanarina, priznanjaOdlike,specialnost,IDCina,IDStatus FROM Clan WHERE id=?";
    String SQL_GET_ALL = "SELECT * FROM Clan";
    String SQL_INSERT = "INSERT INTO Clan (ImePriimek, Starost, Ulica, datumRojstva, telSt, Clanarina, priznanjaOdlike,specialnost,IDCina,IDStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String SQL_UPDATE = "UPDATE Clan SET ImePriimek =?,Starost =?, Ulica=?, datumRojstva=?, telSt=?, Clanarina=?, priznanjaOdlike=?,specialnost=?,IDCina=?,IDStatus=? WHERE id =?";
    String SQL_DELETE = "DELETE FROM Clan WHERE id =?";

    public Clan getClanById(int id) {

        Clan cl = new Clan();
        Connection conn;
        PreparedStatement preparedStatement;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection(dbURL);
            preparedStatement = conn.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                cl.setId(id);
                cl.setImePriimek(rs.getString("ImePriimek"));
                cl.setStarost(rs.getInt("Starost"));
                cl.setUlica(rs.getString("Ulica"));
                cl.setDatumRoj(rs.getString("datumRojstva"));
                cl.setTelSt(rs.getString("telSt"));
                cl.setClanarina(rs.getString("Clanarina"));
                cl.setPrizOdlike(rs.getString("priznanjaOdlike"));
                cl.setSpecialnost(rs.getString("specialnost"));
                cl.setIdCina(rs.getInt("IDCina"));
                cl.setIdStatus(rs.getInt("IDStatus"));
            }
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return cl;
    }

    public ArrayList<Clan> getAllClan() {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList<Clan> cl = new ArrayList();

        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            while (rs.next()) {
                cl.add(new Clan(
                        rs.getInt("Id"),
                        rs.getString("ImePriimek"),
                        rs.getInt("Starost"),
                        rs.getString("Ulica"),
                        rs.getString("datumRojstva"),
                        rs.getString("telSt"),
                        rs.getString("Clanarina"),
                        rs.getString("priznanjaOdlike"),
                        rs.getString("specialnost"),
                        rs.getInt("IDCina"),
                        rs.getInt("IDStatus")));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return cl;
    }

    public void insertClan(Clan cl) {
        Connection conn;
        PreparedStatement preparedStatement;
        try {
            conn = DriverManager.getConnection(dbURL);
            preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cl.getImePriimek());
            preparedStatement.setInt(2, cl.getStarost());
            preparedStatement.setString(3, cl.getUlica());
            preparedStatement.setString(4, cl.getDatumRoj());
            preparedStatement.setString(5, cl.getTelSt());
            preparedStatement.setString(6, cl.getClanarina());
            preparedStatement.setString(7, cl.getPrizOdlike());
            preparedStatement.setString(8, cl.getSpecialnost());
            preparedStatement.setInt(9, cl.getIdCina());
            preparedStatement.setInt(10, cl.getIdStatus());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cl.setId(generatedKeys.getInt(1));
                }
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    
    public void updateClan(Clan cl) {
        Connection conn;
        PreparedStatement preparedStatement;
        try {
            conn = DriverManager.getConnection(dbURL);
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, cl.getImePriimek());
            preparedStatement.setInt(2, cl.getStarost());
            preparedStatement.setString(3, cl.getUlica());
            preparedStatement.setString(4, cl.getDatumRoj());
            preparedStatement.setString(5, cl.getTelSt());
            preparedStatement.setString(6, cl.getClanarina());
            preparedStatement.setString(7, cl.getPrizOdlike());
            preparedStatement.setString(8, cl.getSpecialnost());
            preparedStatement.setInt(9, cl.getIdCina());
            preparedStatement.setInt(10, cl.getIdStatus());
            preparedStatement.setInt(11, cl.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

    
    public void deleteClan(int id) {
        Connection conn;
        PreparedStatement preparedStatement;

        try {
            conn = DriverManager.getConnection(dbURL);

            preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
