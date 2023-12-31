/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import DTO.UsersDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.derby.jdbc.ClientDriver;


/**
 *
 * @author mosta
 */
public class DataAccessLayer {
     public static int Register(UsersDTO user) throws SQLException
    {
//        ArrayList<UsersDTO>arr= new ArrayList<UsersDTO>();
//        UsersDTO u = new UsersDTO();
//        arr.add(u)
                
        int ret=0;
        DriverManager.registerDriver(new ClientDriver());
        Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe","root","root");
        PreparedStatement ps = con.prepareStatement("insert into users (username,email,userpass,score) values (?,?,?,0)");
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getUserPass());     
        ret=ps.executeUpdate();
        con.close();
        return ret;
    }
 public static int updateScore(UsersDTO user) throws SQLException
     {
         int result = 0;
         
          // Load the driver
        DriverManager.registerDriver(new ClientDriver());

        // Connection
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe","root","root");

        // Statement
        PreparedStatement ps = con.prepareStatement(
            "UPDATE users set score = ? WHERE ID=?"
        );
        ps.setInt(1,user.getScore());
        ps.setInt(2,user.getID());
        result = ps.executeUpdate();
        ps.close();
        con.close();
         
         return result;
     }
     
}
