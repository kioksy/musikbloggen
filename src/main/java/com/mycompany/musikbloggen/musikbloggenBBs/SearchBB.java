/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.MusikBlogg;
import com.mycompany.musikbloggen.Post;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author ante89
 */
@Named("search")
@ManagedBean
@SessionScoped
public class SearchBB implements Serializable{
    
        private String getInput;    
    
        public SearchBB(){
            
        }
    
        /**
         * 
         * @return list of posts
         */
        @Inject
        public List<Post> getSearchResult(){
        List<Post> posts = MusikBlogg.INSTANCE.getQp().getSearch(getInput);
        return posts; 
        }
        
        
        public String makeSearch(){
            Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            getInput = (String) flash.get("input");
            return "search?faces-redirect=true";
        }
    
}
