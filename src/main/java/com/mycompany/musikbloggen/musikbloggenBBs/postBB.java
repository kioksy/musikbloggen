/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import com.mycompany.musikbloggen.Post;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("post")
@RequestScoped
public class postBB implements Serializable{
    
    
    private Blog user;
    private Long id;


    public postBB() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String makePost(Long id){
        this.id = id;
        return "makepost?faces-redirect=true";
    }
    public String confirmPost(){
        
        this.user = MusikBlogg.INSTANCE.getBc().find(id);
        
        
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        String title = (String) flash.get("title");
        String content = (String) flash.get("content");
        String uri = (String) flash.get("uri");
        
        Post post = new Post();
        
        post.setBlogerId(user.getId());
        
        post.setTitle(title);
        post.setContent(content);
        post.setSpotifyUri(uri);
        
        user.addPost(post);
                        
        MusikBlogg.INSTANCE.getBc().update(user);
        
        return "minblog?faces-redirect=true";
    }
        
        @Inject
        public List<Post> getLatestLists(){
        List<Post> posts = MusikBlogg.INSTANCE.getQp().getLatestLists(10);
        return posts; 
        }
        
        @Inject
        public List<Post> getLatestPosts(){
        List<Post> posts = MusikBlogg.INSTANCE.getQp().getLatestBlogPosts(10);
        return posts; 
        }
        
        @Inject
        public List<Post> getTopPosts(){
        List<Post> posts = MusikBlogg.INSTANCE.getQp().getTopPosts(25);
        return posts;    
        }
    
        
}
