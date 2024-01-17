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
<<<<<<< HEAD

    public static int Register(UsersDTO user) throws SQLException {
=======
     public static int Register(String email , String userName , String pass) throws SQLException
    {
>>>>>>> d951fb945270d0bfb4440231f2cfab5fa042e1c6
//        ArrayList<UsersDTO>arr= new ArrayList<UsersDTO>();
//        UsersDTO u = new UsersDTO();
//        arr.add(u)

        int ret = 0;
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe", "root", "root");
        PreparedStatement ps = con.prepareStatement("insert into users (username,email,userpass,score) values (?,?,?,0,offline)");
<<<<<<< HEAD
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getUserPass());
        ret = ps.executeUpdate();
=======
        ps.setString(1, userName);
        ps.setString(2, email);
        ps.setString(3, pass);     
        ret=ps.executeUpdate();
>>>>>>> d951fb945270d0bfb4440231f2cfab5fa042e1c6
        con.close();
        return ret;
    }

<<<<<<< HEAD
    public static UsersDTO isLogin(String loginEmail, String loginPass) throws SQLException {
        UsersDTO userLogin = new UsersDTO();
=======

     
    public static int isLogin( String loginEmail, String  loginPass) throws SQLException{
        int res = -1;
        UsersDTO userLogin= new UsersDTO();
>>>>>>> d951fb945270d0bfb4440231f2cfab5fa042e1c6
        userLogin.setID(-1);
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe", "root", "root");

        PreparedStatement ps = con.prepareStatement("select * from users where email = ?");
        ps.setString(1, loginEmail);

        ResultSet result = ps.executeQuery();
        // ResultSet return data (string or int ) use only get string method or get int (write the column number or name)
        if (result.next()) {
            userLogin.setID(result.getInt(1));
            userLogin.setUserName(result.getString(2));
            userLogin.setEmail(result.getString(3));
            userLogin.setScore(result.getInt(4));
            userLogin.setUserPass(result.getString("USERPASS"));
            if(loginPass.equals(userLogin.getUserPass()))
            {
                res = 1;
            }else{
                res = 0;
            }
        }
<<<<<<< HEAD
        ps.close();;
        con.close();

        return userLogin;

    }

    public static int updateScore(UsersDTO user) throws SQLException {
        int result = 0;
=======
             ps.close();
           con.close();
           //System.out.println(userLogin.getEmail());
        
           return res;
    
    }

  public static UsersDTO getUserDataByEmail(String email) throws SQLException {
    UsersDTO user = null;
    
    DriverManager.registerDriver(new ClientDriver());
    try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe", "root", "root");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?")) {
        
        ps.setString(1, email);
        ResultSet result = ps.executeQuery();
        
        if (result.next()) {
            user = new UsersDTO();
            user.setID(result.getInt(1));
            user.setUserName(result.getString(2));
            user.setEmail(result.getString(3));
            user.setScore(result.getInt(4));
            user.setUserPass(result.getString("USERPASS"));
        }
    }
    
    return user;
}  
>>>>>>> d951fb945270d0bfb4440231f2cfab5fa042e1c6

        // Load the driver
        DriverManager.registerDriver(new ClientDriver());

        // Connection
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe", "root", "root");

        // Statement
        PreparedStatement ps = con.prepareStatement(
                "UPDATE users set score = ? WHERE ID=?"
        );
        ps.setInt(1, user.getScore());
        ps.setInt(2, user.getID());
        result = ps.executeUpdate();
        ps.close();
        con.close();

        return result;
    }

    public static ArrayList<UsersDTO> getAllOnline() throws SQLException {

        ArrayList<UsersDTO> arr = new ArrayList<UsersDTO>();

        UsersDTO user;

        DriverManager.registerDriver(new ClientDriver());

        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe", "root", "root");

        PreparedStatement ps = con.prepareStatement("select * from users where status = ?");
        ps.setString(1, "online");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            user = new UsersDTO(result.getInt(1), result.getString(2), result.getString(3), result.getString(5), result.getInt(4), result.getString(6));
            arr.add(user);
        }

        con.close();
        return arr;
    }

    public static void printAvilableUser() {
        try {
            ArrayList<UsersDTO> availablePlayers = getAllOnline();
            for (UsersDTO user : availablePlayers) {
              // loop to use all emails as you want
//              System.out.println(user.getEmail());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
