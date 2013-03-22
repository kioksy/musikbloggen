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

    
    /**
     * forwards you to specified blog 
     * @param id of blog
     * @return adress to blog.xhtml
     */
    public String actionListener(Long id) {
        bid = id;
        return "blog?faces-redirect=true";
    }
    
    /**
     * 
     * @return returns blog from this BackingBean
     */
    public Blog getBlog(){
        return MusikBlogg.INSTANCE.getBc().find(bid);
    }

    public BlogForwardBB() {
    }
    
    
}

