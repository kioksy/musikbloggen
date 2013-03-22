/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.swing.ImageIcon;


/**
 *
 * @author kloek
 */
@Embeddable
public class Owner implements Serializable{

    
    private String firstName;
    private String lastName;
    private String email;
    
    private Boolean isAdmin;
    
    private String profilePic;
    

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Boolean getIsAdmin(){
        return this.isAdmin;
    }
    
    public void setIsAdmin(Boolean admin){
        this.isAdmin = admin;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Owner() {
    }

    public Owner(String Name, String email) {
        this.firstName = Name;
        this.email = email;
    }
    
}
