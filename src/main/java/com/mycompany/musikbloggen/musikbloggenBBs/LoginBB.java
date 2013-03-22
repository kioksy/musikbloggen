package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("login")
@ManagedBean
@SessionScoped
public class LoginBB implements Serializable{
    
    private Boolean isSignedIn;
    private String email;
    private String password;
    private Long blogId;
    
    private String message;

    public Boolean getIsSignedIn() {
        return isSignedIn;
    }

    public String getEmail() {
        return email;
    }
    

    public String getMessage() {
        return message;
    }
    
    public String signinBtnAction(){
        if(isSignedIn){
            signOut();
            return "index?faces-redirect=true";
        }else{
            return "login?faces-redirect=true";
        }
    }
    
       
    public String signinBtnTxt(){
        if(isSignedIn){
            return "Logga ut";
        }else{
            return "Logga in";
        }
    }
    
    public String registerBtnAction(){
        if(isSignedIn){
            return "minblog?faces-redirect=true";
        }else{
            return "register?faces-redirect=true";
        }
        
    }
    
       
    public String registerBtnTxt(){
        if(isSignedIn){
            return "Min Blogg";
        }else{
            return "Registrera";
        }
    }

    public String authenticate(){ 
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        email = (String) flash.get("email");
        password = (String) flash.get("password");
        Blog b = MusikBlogg.INSTANCE.getBc().findByEmail(email);
        blogId = b.getId();
        if(b == null){
            message = "Fel email eller Lösenord";           
            return "login?faces-redirect=true";
            
        }else if(b.getPassword().equals(password)) {
            isSignedIn = true;
            message = "Inloggad som: " + b.getName();
            return "minblog?faces-redirect=true";
            
        }else{
            //fel lösenord!!
            message = "Fel email eller Lösenord";
            return "login?faces-redirect=true";
        }
    }

    public LoginBB() {
        isSignedIn = false;
    }

    private void signOut() {
        isSignedIn = false;
        blogId = null;
        password = null;
        email = null;
        message = "";
    }

    public Blog getBlog() {
        return MusikBlogg.INSTANCE.getBc().find(blogId);
    }
    
    
    public Boolean me(Long id){
        if(this.isSignedIn){
            if(this.blogId == id){
                return true;
            }
        }
        return false;
    }
    
    
}