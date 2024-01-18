/*
 * To change this license header, ch
 *
 * @author mostaoose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DTO.RequestDTO;
import com.google.gson.Gson;

import DTO.UsersDTO;

import db.DataAccessLayer;
import static db.DataAccessLayer.getAllOnline;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mosta
 */
public class ServerHandler {

    ServerSocket serverSocket;

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

    DataInputStream listenFromClient;
    PrintStream printedMessageToClient;
    UsersDTO data;
    String email, route;

    static Vector<RouteHandler> clientsVector = new Vector<RouteHandler>();

    public RouteHandler(Socket s, String email) {

        try {

            listenFromClient = new DataInputStream(s.getInputStream());
            printedMessageToClient = new PrintStream(s.getOutputStream());
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
                RequestDTO clint = json.fromJson(message, RequestDTO.class);

                route = clint.getRoute();
                switch (route) {
                    case "login":
                        login(clint);
                        break;
                    case "signup":

                        break;

                    case "getAvialblePlayers":
                        RequestDTO response = new RequestDTO();
                        response.setRoute("getAvialblePlayers");
                        response.setAvailablePlayers(getAllOnline());

                        Gson jsonAvailable = new Gson();
                        String msg = jsonAvailable.toJson(response);

                        printedMessageToClient.println(msg);
                        printedMessageToClient.flush();
                        break;

                    case "sendInvetation":
                        transInvetationTo(clint.getInvetPlayer(), clint.getEmail(), clint.getScore());
                        break;

                    default:
                        break;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(RouteHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    void sendMessageTo(String msg, String email) {
        System.out.println("Inside sendMessageTo");
        String omarEmail = "omaaar@gmail.com";
        if (email != null) {

            for (RouteHandler root : clientsVector) {
                System.out.println("for loop");
                if (root.email.equals(email)) {
                    System.out.println("found");
                    System.out.println(msg);
                    root.printedMessageToClient.println(msg);
                    root.printedMessageToClient.flush();

                } else {
                    System.out.println("false");

                }
            }
        } else {
            System.out.println("Email is null");
        }
    }

    void transInvetationTo(String intvitedEmail, String invitingEmail, int invitingScore) {
        System.out.println("sendInvetationTo");
        for (RouteHandler root : clientsVector) {
            if (root.email.equals(intvitedEmail)) {

                RequestDTO resendIinvetation = new RequestDTO();
                resendIinvetation.setPlayerWhoSendInvetationName(invitingEmail);
                resendIinvetation.setPlayerWhoSendInvetationScore(invitingScore);
                resendIinvetation.setRoute("youGetInvetation");
                Gson jsonAvailable = new Gson();
                String msg = jsonAvailable.toJson(resendIinvetation);
                root.printedMessageToClient.println(msg);
                root.printedMessageToClient.flush();

            }
        }

    }

    void sendMessageToAll(String msg
    ) {
        for (int i = 0; i < clientsVector.size(); i++) {
            System.out.println(i + "    " + clientsVector.get(i).email);
            clientsVector.get(i).printedMessageToClient.println(msg);

        }
    }

    void login(RequestDTO clint
    ) {
        try {

            int res = DataAccessLayer.isLogin(clint.getEmail(), clint.getPass());
            RequestDTO response = new RequestDTO();
            response.setRoute("login");
            Gson json = new Gson();

            if (res == 1) {
                UsersDTO userData = DataAccessLayer.getUserDataByEmail(clint.getEmail());
                response.setValidation("confirmed");
                response.setEmail(clint.getEmail());
                response.setUserName(userData.getUserName());
                response.setScore(userData.getScore());
                String msg = json.toJson(response);
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

}
