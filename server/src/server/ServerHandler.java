///*
// * To change this license header, ch
// *
// * @author mostaoose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package server;
//
//
//import DTO.RequestDTO;
//import com.google.gson.Gson;
//
//import DTO.UsersDTO;
//
//import db.DataAccessLayer;
//
//import java.io.DataInputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.sql.SQLException;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author mosta
// */
//public class ServerHandler {
//    ServerSocket serverSocket;
//    
//        public ServerHandler()
//        {
//   
//            try {
//                serverSocket = new ServerSocket(2000);
//                
//                while(true){
//                    Socket clientSocket = serverSocket.accept();
//                    new RouteHandler(clientSocket,"");
//                    
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//                System.out.println("not accepted");
//            }finally {
//                try {
//                    serverSocket.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//          }
//}
//
//class RouteHandler extends Thread
//{
//        DataInputStream listenFromClient;
//        PrintStream printedMessageToClient;
//        UsersDTO data;
//        String email , route;
//
//        static Vector<RouteHandler> clientsVector =new Vector<RouteHandler>(); 
//        
//        public RouteHandler(Socket s ,String email)
//        {
//            
//            try 
//            {
//                clientsVector.add(this);
//                listenFromClient = new DataInputStream(s.getInputStream());
//                printedMessageToClient = new PrintStream(s.getOutputStream());
//                start();
//            } 
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
//        }
//
//        public void run()
//        {   Gson json = new Gson();
//            while(true)
//            {
//                try 
//                {
//                        String message = listenFromClient.readLine();
//                        System.out.print(message);
//                           RequestDTO clint = json.fromJson(message, RequestDTO.class);
//
//            route = clint.getRoute();
//   switch(route)
//        {
//            case "login":
//                 login(clint);
//                break;
//            case "signup":
//                
//                break;
//            case "board":
//                onlineBoard(clint);
//                break;
//                default:
//
//                break;
//        }
//                sendMessageToAll();
//
//                } catch (IOException ex) 
//                {
//                    ex.printStackTrace();
//                } 
//            }
//
//        }
//        
//        
//    
//        
//void sendMessageTo(String msg , String email) {
//    System.out.println("Inside sendMessageTo");
//    String omarEmail ="omaaar@gmail.com";
//    if (email != null) {
//        
//        for (RouteHandler root : clientsVector) {
//            System.out.println("for loop");
//            if (root.email.equals(email)) {
//                            System.out.println("found");
//            System.out.println(msg);
//
//                root.printedMessageToClient.println(msg);
//                            System.out.println("kkk");
//
//            }else{
//                            System.out.println("false");
//
//            }
//        }
//    } else {
//        System.out.println("Email is null");
//    }
//}
//
//
//                
//        void sendMessageToAll()
//        {
//            for(int i=0 ; i<clientsVector.size() ; i++)
//            {
//                 System.out.println(i +"    "+clientsVector.get(i).email);
////                 clientsVector.get(i).printedMessageToClient.println(msg);
//                   
//                 
//            }
//        }
//        
//        void login(RequestDTO clint){
//            try {
//                
//             int res = DataAccessLayer.isLogin(clint.getEmail(), clint.getPass());
//             RequestDTO response = new RequestDTO();
//                          response.setRoute("login");
//               Gson json = new Gson();  
//
//             if(res ==1){
//             UsersDTO userData = DataAccessLayer.getUserDataByEmail(clint.getEmail());
//             response.setValidation("confirmed");
//             response.setEmail(clint.getEmail());
//             response.setUserName(userData.getUserName());
//             response.setScore(userData.getScore());
//               String msg = json.toJson(response);
//               email = clint.getEmail();
//             printedMessageToClient.println(msg);
//              printedMessageToClient.flush(); 
//             }else if(res == -1){
//             response.setValidation("invalid");
//               String msg = json.toJson(response);
//               System.out.println(res + msg);
//             printedMessageToClient.println(msg);
//              printedMessageToClient.flush(); 
//             }
//                
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//void onlineBoard(RequestDTO client) {
//    System.out.println("server.RouteHandler.onlineBoard()");
//    RequestDTO response = new RequestDTO();
//
//    if (email != null) {
//        for (RouteHandler root : clientsVector) {
//            if (root.email.equals(client.getOpponentEmail())) {
//                // Assuming client includes the move information
//                response.setRow(client.getRow());
//                response.setCol(client.getCol());
//                response.setMove(client.getMove());
//
//                Gson json = new Gson();
//                String msg = json.toJson(response);
//                System.out.println("msg online board " + msg);
//                root.printedMessageToClient.println(msg);
//                root.printedMessageToClient.flush();
//            }
//        }
//    } else {
//        System.out.println("Email is null");
//    }
//}
//
//}
package server;

import DTO.RequestDTO;
import DTO.UsersDTO;
import com.google.gson.Gson;
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

public class ServerHandler {
    private ServerSocket serverSocket;

    public ServerHandler() {
        try {
            serverSocket = new ServerSocket(2000);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new RouteHandler(clientSocket, "");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("not accepted");
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class RouteHandler extends Thread {
    private DataInputStream listenFromClient;
    private PrintStream printedMessageToClient;
    private UsersDTO data;
    private String email, route;

    private static Vector<RouteHandler> clientsVector = new Vector<>();
    private static boolean isOmaaarTurn = true; // Initial turn

    private String playerXEmail = "omaaar@gmail.com";
    private String playerOEmail = "ezz@gmail.com";

    public RouteHandler(Socket s, String email) {
        try {
            listenFromClient = new DataInputStream(s.getInputStream());
            printedMessageToClient = new PrintStream(s.getOutputStream());
            this.email = email;
            clientsVector.add(this);
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        Gson json = new Gson();
        while (true) {
            try {
                String message = listenFromClient.readLine();
                System.out.print(message);
                RequestDTO clientRequest = json.fromJson(message, RequestDTO.class);
                route = clientRequest.getRoute();

                switch (route) {
                    case "login":
                        login(clientRequest);
                        break;
                    case "signup":
                        // Handle signup
                        break;
                    case "board":
                        onlineBoard(clientRequest);
                        break;
                    default:
                        // Handle other routes
                        break;
                }

                sendMessageToAll();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean isPlayerTurn(String currentPlayerEmail) {
        return (currentPlayerEmail.equals(playerXEmail) && isOmaaarTurn) ||
               (currentPlayerEmail.equals(playerOEmail) && !isOmaaarTurn);
    }

    private void togglePlayerTurn(String currentPlayerEmail, String opponentPlayerEmail) {
        if (currentPlayerEmail.equals(playerXEmail) && isOmaaarTurn) {
            isOmaaarTurn = false;
        } else if (currentPlayerEmail.equals(playerOEmail) && !isOmaaarTurn) {
            isOmaaarTurn = true;
        }
    }

    void sendMessageTo(String msg, String email) {
        if (email != null) {
            for (RouteHandler root : clientsVector) {
                if (root.email.equals(email)) {
                    root.printedMessageToClient.println(msg);
                    root.printedMessageToClient.flush();
                }
            }
        } else {
            System.out.println("Email is null");
        }
    }

    void sendMessageToAll() {
        for (int i = 0; i < clientsVector.size(); i++) {
            System.out.println(i + "    " + clientsVector.get(i).email);
        }
    }

    void login(RequestDTO clientRequest) {
        try {
            int res = DataAccessLayer.isLogin(clientRequest.getEmail(), clientRequest.getPass());
            RequestDTO response = new RequestDTO();
            response.setRoute("login");
            Gson json = new Gson();

            if (res == 1) {
                UsersDTO userData = DataAccessLayer.getUserDataByEmail(clientRequest.getEmail());
                response.setValidation("confirmed");
                response.setEmail(clientRequest.getEmail());
                response.setUserName(userData.getUserName());
                response.setScore(userData.getScore());
                String msg = json.toJson(response);
                email = clientRequest.getEmail();
                printedMessageToClient.println(msg);
                printedMessageToClient.flush();
            } else if (res == -1) {
                response.setValidation("invalid");
                String msg = json.toJson(response);
                System.out.println(res + msg);
                printedMessageToClient.println(msg);
                printedMessageToClient.flush();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void onlineBoard(RequestDTO clientRequest) {
        RequestDTO response = new RequestDTO();

        if (email != null) {
            for (RouteHandler root : clientsVector) {
                if (!root.email.equals(email) && isPlayerTurn(email) && !isPlayerTurn(root.email)) {
                    // Assuming client includes the move information
                    response.setRow(clientRequest.getRow());
                    response.setCol(clientRequest.getCol());
                    response.setMove(clientRequest.getMove());
                    response.setPlayerOneTurn(true);
                    Gson json = new Gson();
                    String msg = json.toJson(response);
                    System.out.println("msg online board " + msg);
                    root.printedMessageToClient.println(msg);
                    root.printedMessageToClient.flush();

                    // Toggle turn after sending the move
                    togglePlayerTurn(email, root.email);
                }
            }
        } else {
            System.out.println("Email is null");
        }
    }
}
