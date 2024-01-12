/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

/**
 *
 * @author mosta
 */
public class SocketDTO {
    
    private int userId;
    private String route;
    private String message;
    private String input;
    
    
    public void signUp(String msg)
    {
        route="signUp";
        message=msg;
        
    }
    public void login(String msg)
    {
        route="login";
        message=msg;
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
}
