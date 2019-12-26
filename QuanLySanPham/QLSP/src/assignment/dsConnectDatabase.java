/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HongGiang
 */
public class dsConnectDatabase {
    String connectionString = "jdbc:sqlserver://ADMIN-PC/SQLEXPRESS:1433;" // doan nay ne, chac bi loi gi doan nay thoi, xoa port 1433 coi
            + "databaseName=QLSanPham;user=sa;password=123456;";
    Connection conn;
    public dsConnectDatabase(){
       
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);
           
            if(conn != null){
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }
            else{
                System.out.println("Kết nối CSDL SQL Server thất bại");
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }   
    }
    
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
