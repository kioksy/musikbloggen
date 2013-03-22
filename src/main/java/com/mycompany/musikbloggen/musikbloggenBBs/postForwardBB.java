/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import com.mycompany.musikbloggen.Post;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("postForward")
@SessionScoped
public class postForwardBB implements Serializable{
    
    private Post post;
    private Blog postedBy;
    private int views;

    public Post getPost() {
        return post;
    }

    public Blog getPostedBy() {
        return postedBy;
    }
    
    public int getViews(){
        return views;
    }

    /**
     * forwards you to big version of post
     * @param post
     * @return forward adress
     */
    public String actionListener(Post post) {
        this.post = post;
        this.postedBy = MusikBlogg.INSTANCE.getBc().find(post.getBlogerId());
        this.post.incViews();
        return "bigpost?faces-redirect=true";

    }

    public postForwardBB() {
    }
}
