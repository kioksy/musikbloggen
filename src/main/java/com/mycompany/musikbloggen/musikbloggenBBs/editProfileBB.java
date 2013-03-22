/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("editProfile")
@ConversationScoped
public class editProfileBB implements Serializable {
    
    
    private Long id;
    private Blog blog;
    
    private String name;
    private String description;
    private String firstName;
    private String lastName;
    private String image;
    private String password;
    private Boolean isAdmin;
    
    private String editPwMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
    public void setImage(String image){
        this.image = image;
    }
    
    public String getImage(){
        return image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private Boolean getIsAdmin(){
        return isAdmin;
    }
    
    private void setIsAdmin(Boolean admin){
        this.isAdmin = admin;
    }
    
    
    public void editProfile(Long id){
        
        this.id = id;
        
        this.blog = MusikBlogg.INSTANCE.getBc().find(id);
        this.name = blog.getName();
        this.description = blog.getDescription();
        this.firstName = blog.getOwner().getFirstName();
        this.lastName = blog.getOwner().getLastName();
        this.isAdmin = blog.getOwner().getIsAdmin();
        this.image=blog.getOwner().getProfilePic();
        
    }
    
    public String confirmEditProfile(){
        
        this.blog = MusikBlogg.INSTANCE.getBc().find(this.id);
        
        this.blog.setName(this.name);
        this.blog.setDescription(this.description);
        this.blog.getOwner().setFirstName(this.firstName);
        this.blog.getOwner().setLastName(this.lastName);
        this.blog.getOwner().setIsAdmin(this.isAdmin);
        this.blog.getOwner().setProfilePic(this.image);
        
        MusikBlogg.INSTANCE.getBc().update(this.blog);
        return "minblog?faces-redirect=true";
    }
    
    
    public String confirmEditPassword(){
        this.blog = MusikBlogg.INSTANCE.getBc().find(this.id);
        
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        String pw = (String) flash.get("password");
        String pw2 = (String) flash.get("password2");
        String pwo = (String) flash.get("passwordold");
        
        if(pw.equals(pw2) && pwo.equals(this.blog.getPassword())){
            this.blog.setPassword(pw);
            MusikBlogg.INSTANCE.getBc().update(this.blog);
            editPwMessage = "";
            return "minblog?faces-redirect=true";
        }else{
            if(pw.equals(pw2)){
                editPwMessage = "Wrong Password!";
            }else{
                editPwMessage = "Passwords don't match!";
            }
            return "editprofile?faces-redirect=true";
        }
    }

    public editProfileBB() {
    }
    
    
    
}
