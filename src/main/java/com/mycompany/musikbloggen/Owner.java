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
    

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * @return if person is admin
     */
    public Boolean getIsAdmin(){
        return this.isAdmin;
    }
    
    /**
     * sets admin priviledge
     * @param admin 
     */
    public void setIsAdmin(Boolean admin){
        this.isAdmin = admin;
    }
    
    /**
     * 
     * @return first name of owner
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * change first name og person
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return last name of person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setts last name of person
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return email adress
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @return url to profile pic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * setts url to profile pic
     * @param profilePic 
     */
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
