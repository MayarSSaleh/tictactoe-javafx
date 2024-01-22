package conn;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClintSide{
   public static Socket serverSide;
    public static DataInputStream listenFromServer;
    public static PrintStream printedMessageToServer;

   public static void startConnection(){
             try {
            serverSide = new Socket("127.0.0.1", 2000);
            listenFromServer = new DataInputStream(serverSide.getInputStream());
            printedMessageToServer = new PrintStream(serverSide.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   } 

    
    

