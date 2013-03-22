/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("register")
@RequestScoped
public class RegisterBB implements Serializable {
    
    private String bname;
    private String fname;
    private String ename;
    private String profilePic;
    private String email;
    private String password;
    private String password2;
    private String message = "";

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setProfilePic(String profilePic){
        this.profilePic = profilePic;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public String getMessage(){
        return message;
    }

    
    public String addBlog(){
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        bname = (String) flash.get("bname");
        fname = (String) flash.get("fname");
        ename = (String) flash.get("ename");
        email = (String) flash.get("email");
        profilePic = (String) flash.get("profilePic");
        password = (String) flash.get("password");
        password2 = (String) flash.get("password2");
        
        if(!password.equals(password2)){
            message = "Lösenorden stämmer inte överäns";
            return "register?faces-redirect=true";
        }else if(MusikBlogg.INSTANCE.getBc().containsEmail(email)){
            
            message = "Mail adressen finns redan i vår databas";
            return "register?faces-redirect=true";
            
        }
        else{
            Blog blog = new Blog();
            blog.setName(bname);
            blog.getOwner().setFirstName(fname);
            blog.getOwner().setLastName(ename);
            blog.getOwner().setEmail(email);
            if(profilePic == null || profilePic.equals("") || !testUrl(profilePic)){
                blog.getOwner().setProfilePic("client/images/Default-Avatar.jpg");
            }else{
                blog.getOwner().setProfilePic(profilePic);
            }
            blog.setPassword(password); 
            blog.getOwner().setIsAdmin(Boolean.FALSE);
            MusikBlogg.INSTANCE.getBc().add(blog);
            return "bloggar?faces-redirect=true";
        }
    }
    
    
    
    private Boolean testUrl(String s){
        try {
            URL u = new URL (s); 
            HttpURLConnection huc =  (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET"); 
            huc.connect(); 
            huc.getResponseCode();
            int code = huc.getResponseCode();
            if(code == 200){
                return true;
            }else{
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(RegisterBB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public RegisterBB() {
    }
    
    
}
