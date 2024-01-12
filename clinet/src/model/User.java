/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mosta
 */
public class User
{
    private int ID;
    private String userName;
    private String email;
    private String userPass;
    private int score;
    private String status;


    public User() {
    }

    public User(int ID, String userName, String email, String userPass, int score,String status) {
        this.ID = ID;
        this.userName = userName;
        this.email = email;
        this.userPass = userPass;
        this.score = score;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public User(int id)
    {
    ID=id;
    }

//    public UsersDTO(int aInt, String string, String string0, String string1, int aInt0, String string2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
  public void incrementScore()
    {
        score++;
    }  
    
    
}