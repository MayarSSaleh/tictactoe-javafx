package db;

import DTO.RequestDTO;
import DTO.UsersDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.derby.jdbc.ClientDriver;

public class DataAccessLayer {

    public static int Register(RequestDTO clint) throws SQLException {

        int ret = 0;
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe", "root", "root");
        PreparedStatement ps = con.prepareStatement("INSERT INTO users (username,email,score,status,userpass) VALUES (?,?,?,?,?)");

        ps.setString(1, clint.getUser());
        ps.setString(2, clint.getEmail());
        ps.setInt(3, clint.getScore());
        ps.setString(4, clint.getPlayState());
        ps.setString(5, clint.getPass());
        ret = ps.executeUpdate();

        con.close();
        return ret;
    }
    

    public static int isLogin(String loginEmail, String loginPass) throws SQLException {
        int res = -1;
        UsersDTO userLogin = new UsersDTO();
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
            if (loginPass.equals(userLogin.getUserPass())) {
                res = 1;
            } else {
                res = 0;
            }
        }
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

    public static int updateScore(UsersDTO user) throws SQLException {
        int result = 0;

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
        ps.setString(1, "Avilable");
        ResultSet result = ps.executeQuery();

        while (result.next()) {
            user = new UsersDTO(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
            arr.add(user);
        }

        con.close();
        System.out.println(arr.size());
        return arr;
    }

}
