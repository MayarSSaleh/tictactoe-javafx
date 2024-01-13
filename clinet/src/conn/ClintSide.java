
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
    
    public ClintSide()
    {
        try {
            serverSide = new Socket("127.0.0.1", 2000);
            listenFromServer = new DataInputStream(serverSide.getInputStream());
            printedMessageToServer = new PrintStream(serverSide.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClintSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMassage(String msg)
    {
        printedMessageToServer.println(msg);
    }

    @Override
    public void run() {
          while(true)
            {
                try {
                   
                    String msg = listenFromServer.readLine();
                    Gson json = new Gson();
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
