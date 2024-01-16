/*
 * To change this license header, ch
 *
 * @author mostaoose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import DTO.RequestDTO;
import DTO.SocketDTO;
import com.google.gson.Gson;

import DTO.UsersDTO;
import RouteHandler.Handler;
import static RouteHandler.Handler.SignUp;
import static RouteHandler.Handler.login;
import db.DataAccessLayer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mosta
 */
public class ServerHandler {
    ServerSocket serverSocket;
    
        public ServerHandler()
        {
   
            try {
                serverSocket = new ServerSocket(2000);
                
                while(true){
                    Socket clientSocket = serverSocket.accept();
                    new RouteHandler(clientSocket,"");
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
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
        UsersDTO data;
        String email , route;

        static Vector<RouteHandler> clientsVector =new Vector<RouteHandler>(); 
        
        public RouteHandler(Socket s ,String email)
        {
            
            try 
            {
                
                listenFromClient = new DataInputStream(s.getInputStream());
                printedMessageToClient = new PrintStream(s.getOutputStream());
                start();
            } 
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        public void run()
        {   Gson json = new Gson();
            while(true)
            {
                try 
                {
                        String message = listenFromClient.readLine();
                        System.out.print(message);
//                        SocketDTO clint = json.fromJson(message, SocketDTO.class);
//                        Handler.connSwitch(clint.getRoute(), clint.getMessage());
                           RequestDTO clint = json.fromJson(message, RequestDTO.class);

            route = clint.getRoute();
   switch(route)
        {
            case "login":
                 login(clint);
//                 data=login(clint.getMessage());
                
//                 if(data != null)
//                 {
//                     email = data.getEmail();
//                     RouteHandler.clientsVector.add(this);
//
//                 }
//                 SocketDTO send=null;
//                         if(data!=null)
//                         {   
//                            email=data.getEmail();
//                            send = new SocketDTO("login", json.toJson(data));
//                             RouteHandler.clientsVector.add(this);
//                             sendMessageTo(json.toJson(send) , email);
//
//                         }
                break;
            case "signup":
                int ret = SignUp();
                break;
                default:

                break;
        }
//                      UsersDTO data=Handler.login();
//                         System.out.print(data.getEmail());
                        
                      
//System.out.println("Before calling sendMessageTo with Email: " + Email);
//System.out.println("After calling sendMessageTo");
//                            sendMessageToAll(json.toJson(send));
////                            printedMessageToClient.println("hi omar");
//                clientsVector.get(1).printedMessageToClient.println("hi omar");

//                            printedMessageToClient.flush();
                } catch (IOException ex) 
                {
                    ex.printStackTrace();
                } 
            }
        }
        
        
    
        
void sendMessageTo(String msg , String email) {
    System.out.println("Inside sendMessageTo");
    String omarEmail ="omaaar@gmail.com";
    if (email != null) {
        
        for (RouteHandler root : clientsVector) {
            System.out.println("for loop");
            if (root.email.equals(email)) {
                            System.out.println("found");
            System.out.println(msg);

                root.printedMessageToClient.println(msg);
                            System.out.println("kkk");

            }else{
                            System.out.println("false");

            }
        }
    } else {
        System.out.println("Email is null");
    }
}

        
//        void sendMessageToAll(String msg)
//        {
//            for(int i=0 ; i<clientsVector.size() ; i++)
//            {
//                 clientsVector.get(i).printedMessageToClient.println(msg);
//                 
//            }
//        }
                
        void sendMessageToAll(String msg)
        {
            for(int i=0 ; i<clientsVector.size() ; i++)
            {
                 System.out.println(i +"    "+clientsVector.get(i).email);
                 clientsVector.get(i).printedMessageToClient.println(msg);
                   
                 
            }
        }
        
        void login(RequestDTO clint){
            try {
             int res = DataAccessLayer.isLogin(clint.getEmail(), clint.getPass());
             RequestDTO response = new RequestDTO();
                          response.setRoute("login");
                                         Gson json = new Gson();  

             if(res ==1){
             response.setValidation("confirmed");
               String msg = json.toJson(response);
             printedMessageToClient.println(msg);
              printedMessageToClient.flush(); 
             }else if(res == 0){
             response.setValidation("invalid");
               String msg = json.toJson(response);
             printedMessageToClient.println(msg);
              printedMessageToClient.flush(); 
             }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
}
