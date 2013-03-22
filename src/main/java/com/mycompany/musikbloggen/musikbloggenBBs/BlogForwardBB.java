/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("blogForward")
@SessionScoped
public class BlogForwardBB implements Serializable {
    
    private Blog blog;
    private Long bid;

    public String actionListener(Long id) {
        bid = id;
        return "blog?faces-redirect=true";
    }
    
   /* public String forward(){
        return "blog?faces-redirect=true";
    }*/
    
    public Blog getBlog(){
        return MusikBlogg.INSTANCE.getBc().find(bid);
    }

    public BlogForwardBB() {
    }
    
    
}

