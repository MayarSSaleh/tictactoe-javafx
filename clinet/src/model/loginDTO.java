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
public class loginDTO {
    private String Email;
    private String Pass;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public loginDTO(String Email, String Pass) {
        this.Email = Email;
        this.Pass = Pass;
    }

    public loginDTO() {
    }
    
    
}
