
package conn;

import RouteHandler.Handler;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;


public class ClintSide extends Thread{
    Socket serverSide;
    DataInputStream listenFromServer;
    PrintStream printedMessageToServer;
    Gson json = new Gson();
    
    public ClintSide()
    {
        try {
            serverSide = new Socket("127.0.0.1", 2000);
            listenFromServer = new DataInputStream(serverSide.getInputStream());
            printedMessageToServer = new PrintStream(serverSide.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void sendMassage(String route,String msg)
    {
       
        SocketDTO send= new SocketDTO(route,msg);
        printedMessageToServer.println(json.toJson(send));
    }
    public void sendMassageTo(String msg)
    {
        
        
        printedMessageToServer.println(msg);
    }

    @Override
    public void run() {
          while(true)
            {
                try {
                   
                    String msg = listenFromServer.readLine();
                    
                     SocketDTO recive= json.fromJson(msg, SocketDTO.class);
                     
                    Handler.connSwitch(recive.getRoute(),recive.getMessage());
                   
                } 
                catch(SocketException c)
                     {
                       
                          break;  
                     }
                
                catch (IOException ex) {
                    Logger.getLogger(ClintSide.class.getName()).log(Level.SEVERE, null, ex);
                  
                    break;

                }
            }
    }
    
    
    

    
    
}
