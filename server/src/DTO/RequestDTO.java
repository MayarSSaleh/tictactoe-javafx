package DTO;

import java.util.ArrayList;

public class RequestDTO {

    private String Email;
    private String route;
    private String pass;
    private String validation;
    private int score;
    private String userNamewhoSentInvetation;
    private ArrayList<UsersDTO> availablePlayers;
    private String invetPlayer;
    private String playerWhoSendInvetationName;
    private int playerWhoSendInvetationScore;
    private String sendInvetationToEmail;

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

    
    
    
    
    private boolean invitationRespons;

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

    public String getuserNamewhoSentInvetation() {
        return userNamewhoSentInvetation;
    }

    public void setuserNamewhoSentInvetation(String userNamewhoSentInvetation) {
        this.userNamewhoSentInvetation = userNamewhoSentInvetation;
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
