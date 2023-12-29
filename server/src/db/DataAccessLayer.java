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
import org.apache.derby.jdbc.ClientDriver;


/**
 *
 * @author mosta
 */
public class DataAccessLayer {
     public static int Register(UsersDTO user) throws SQLException
    {
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
}
