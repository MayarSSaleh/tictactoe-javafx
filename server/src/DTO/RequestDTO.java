
package DTO;

import java.util.ArrayList;

public class RequestDTO {

    private String Email;
    private String route;
    private String pass;
    private String validation;
    private int score;
    private String userName;
    private ArrayList<UsersDTO> availablePlayers;

    
    
    public ArrayList<UsersDTO> getAvailablePlayers() {
        return availablePlayers;
    }

    public void setAvailablePlayers(ArrayList<UsersDTO> availablePlayers) {
        this.availablePlayers = availablePlayers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
