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
import java.sql.ResultSet;
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
     
     
    public static UsersDTO isLogin( String loginEmail, String  loginPass) throws SQLException{
        UsersDTO userLogin= new UsersDTO();
        userLogin.setID(-1);
        DriverManager.registerDriver(new ClientDriver());
        Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe","root","root");
        
        PreparedStatement ps = con.prepareStatement("select * from users where email = ?");
        ps.setString(1, loginEmail); 
        
        ResultSet result = ps.executeQuery();
     // ResultSet return data (string or int ) use only get string method or get int (write the column number or name)
        if (result.next())
        {
            userLogin.setID(result.getInt(1));
            userLogin.setUserName(result.getString(2));
            userLogin.setEmail(result.getString(3));
            userLogin.setScore(result.getInt(4));
            userLogin.setUserPass(result.getString("USERPASS"));
        }
             ps.close();;
           con.close();  
        
           return userLogin;
    
    }
     
}





