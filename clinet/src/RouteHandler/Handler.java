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
    
   public  static void connSwitch(String route,String msg)
    {
        
      switch(route)
      {
          case "login":
              User data=login(msg);
              if(data!=null)
              {
                  
              }
              else
              {
                  
              }
              break;
              default:
                  
              break;
      }
    }
    public static User login(String msg)
    {
       User myData= json.fromJson(msg, User.class); 
       return myData;
    }
    
}
