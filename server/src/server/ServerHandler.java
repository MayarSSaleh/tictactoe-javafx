/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mosta
 */
public class ServerHandler {
    ServerSocket serverSocket;
        public ServerHandler(){
   
            try {
                serverSocket = new ServerSocket(2000);
                while(true){
                    Socket clientSocket = serverSocket.accept();
                    new RouteHandler(clientSocket);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("not accepted");
            }finally {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          }
}

class RouteHandler extends Thread
{
        DataInputStream listenFromClient;
        PrintStream printedMessageToClient;
        static Vector<RouteHandler> clientsVector =new Vector<RouteHandler>(); 
        
        public RouteHandler(Socket s)
        {
            try 
            {
                listenFromClient = new DataInputStream(s.getInputStream());
                printedMessageToClient = new PrintStream(s.getOutputStream());
                RouteHandler.clientsVector.add(this);
                start();
            } 
            catch (IOException ex)
            {
                Logger.getLogger(RouteHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void run()
        {
            while(true)
            {
                try 
                {
                        String message = listenFromClient.readLine();
                        System.out.println(message);
                        sendMessageToAll(message);
                } catch (IOException ex) 
                {
                    Logger.getLogger(RouteHandler.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
        
        void sendMessageToAll(String msg)
        {
            for(int i=0 ; i<clientsVector.size() ; i++)
            {
                 clientsVector.get(i).printedMessageToClient.println(msg);
                 
            }
        }
        
}
