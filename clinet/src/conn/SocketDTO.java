/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

/**
 *
 * @author mosta
 */
public class SocketDTO {
    
    private String Email;
    private String route;
    private String message;
    private String input;

    public SocketDTO(String route, String message) {
        this.route = route;
        this.message = message;
    }

    public SocketDTO() {
    }
    
    
    public void login(String msg)
    {
        route="signUp";
        message=msg;
        
    }
    public void signUp(String Email,String msg)
    {   this.Email=Email;
        route="login";
        message=msg;
        
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
