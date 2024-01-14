/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RouteHandler;

import DTO.LoginDTO;
import DTO.SignUpDTO;
import DTO.UsersDTO;
import com.google.gson.Gson;
import db.DataAccessLayer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mosta
 */
public class Handler {
        private static Gson json =new Gson();
    private static String route;
    private static String msg;

    
   public static void connSwitch(String route,String msg)
    {
        Handler.route=route;
        Handler.msg=msg;
      switch(route)
      {
          case "login":
              
              UsersDTO data=login();
              break;
          case "signup":
              int ret = SignUp();
              break;
              default:
                  
              break;
      }
    }
    public static UsersDTO login()
    {
       LoginDTO myData= json.fromJson(msg, LoginDTO.class);
       UsersDTO user=null;
            try {
                user = DataAccessLayer.isLogin(myData.getEmail(), myData.getPass());
                //System.out.println(user.getEmail());
            } catch (SQLException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       return user;
    }
    
        public static int SignUp()
    {
        int ret = 0;
       SignUpDTO myData= json.fromJson(msg, SignUpDTO.class);
      
            try {
                ret =DataAccessLayer.Register(myData.getEmail(), myData.getUserName(), myData.getPass() );
                //System.out.println(user.getEmail());
            } catch (SQLException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       return ret;
    }
    
}
