package DTO;

import java.util.ArrayList;

public class RequestDTO {

    private String Email;
    private String route;
    private String pass;
    private String validation;
    private int score;
    private String userName;
    private String opponentEmail;
    private int row;
    private int col;
    private char move;
    private boolean PlayerOneTurn;
    private String playState;
    private String playerWhoSendInvetationName;
    private int playerWhoSendInvetationScore;
    private String playerWhoSendInvetationEmail;

    private String invetPlayer;
    private String sendInvetationToEmail;

    private ArrayList<UsersDTO> availablePlayers;
    private String record;

    private ArrayList<String> allRecords;

    public ArrayList<String> getAllRecords() {
        return allRecords;
    }

    public void setAllRecords(ArrayList<String> allRecords) {
        this.allRecords = allRecords;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getPlayState() {
        return playState;
    }

    public void setPlayState(String playState) {
        this.playState = playState;
    }

    public boolean isPlayerOneTurn() {
        return PlayerOneTurn;
    }

    public void setPlayerOneTurn(boolean PlayerOneTurn) {
        this.PlayerOneTurn = PlayerOneTurn;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getMove() {
        return move;
    }

    public void setMove(char move) {
        this.move = move;
    }

    public String getOpponentEmail() {
        return opponentEmail;
    }

    public void setOpponentEmail(String opponentEmail) {
        this.opponentEmail = opponentEmail;

    }
    private String user;

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
