package model;

import java.util.ArrayList;

public class RequestDTO {

    private String route;
    private String user;
    private String Email;
    private String pass;
    private String validation;
    private int score;
    private String playerWhoSendInvetationName;
    private int playerWhoSendInvetationScore;
    private String playerWhoSendInvetationEmail;
    private String invetPlayer;
    private String sendInvetationToEmail;
    private ArrayList<UsersDTO> availablePlayers;
    private boolean invitationRespons;


    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPlayerWhoSendInvetationEmail() {
        return playerWhoSendInvetationEmail;
    }
    public void setPlayerWhoSendInvetationEmail(String playerWhoSendInvetationEmail) {
        this.playerWhoSendInvetationEmail = playerWhoSendInvetationEmail;
    }


    public String getSendInvetationToEmail() {
        return sendInvetationToEmail;
    }

    public void setSendInvetationToEmail(String sendInvetationToEmail) {
        this.sendInvetationToEmail = sendInvetationToEmail;
    }

    public String getPlayerWhoSendInvetationName() {
        return playerWhoSendInvetationName;
    }

    public void setPlayerWhoSendInvetationName(String playerWhoSendInvetationName) {
        this.playerWhoSendInvetationName = playerWhoSendInvetationName;
    }

    public int getPlayerWhoSendInvetationScore() {
        return playerWhoSendInvetationScore;
    }

    public void setPlayerWhoSendInvetationScore(int playerWhoSendInvetationScore) {
        this.playerWhoSendInvetationScore = playerWhoSendInvetationScore;
    }


    public boolean isInvitationRespons() {
        return invitationRespons;
    }

    public void setInvitationRespons(boolean invitationRespons) {
        this.invitationRespons = invitationRespons;
    }

    public String getInvetPlayer() {
        return invetPlayer;
    }

    public void setInvetPlayer(String invetPlayer) {
        this.invetPlayer = invetPlayer;
    }

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

    public String getplayerWhoSendInvetationEmail() {
        return playerWhoSendInvetationEmail;
    }

    public void setplayerWhoSendInvetationEmail(String playerWhoSendInvetationEmail) {
        this.playerWhoSendInvetationEmail = playerWhoSendInvetationEmail;
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
