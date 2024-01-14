/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RouteHandler;

import com.google.gson.Gson;
import model.User;

/**
 *
 * @author mosta
 */
public class Handler {
    
    private static Gson json;
    private static String route;
    private static String msg;

    
   public static void connSwitch(String route,String msg)
    {
        Handler.route=route;
        Handler.msg=msg;
      switch(route)
      {
          case "login":
              
              User data=login();
              break;
              default:
                  
              break;
      }
    }
    public static User login()
    {
       User myData= json.fromJson(msg, User.class); 
       return myData;
    }
    
}
