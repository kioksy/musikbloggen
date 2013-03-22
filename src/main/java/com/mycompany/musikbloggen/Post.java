/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author kloek
 */

@Entity
public class Post implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    
    private List<String> tags;
    
    private Boolean hasUri;
    
    private String content;
    
    private Long blogerId;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    
    private String spotifyUri;
    
    private int views;

    public Post() {
        
        Calendar cal = Calendar.getInstance();
        this.created = cal.getTime();
        
        views = 0;
        
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated() {
        return created.toString();
    }

    public List<String> getTags() {
        return tags;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpotifyUri() {
        return spotifyUri;
    }

    public void setSpotifyUri(String spotifyUri) {
        String[] test = spotifyUri.split(":");
        if(test[0].equals("spotify")){
            hasUri = true;
            this.spotifyUri = spotifyUri;
        }else{
            hasUri = false;
        }
    }
    
    public String getPlayer(){
        return "https://embed.spotify.com/?uri=" + spotifyUri;
    }
    
    public Boolean hasUri(){
        return hasUri;
    }

    public Long getBlogerId() {
        return blogerId;
    }

    public void setBlogerId(Long blogerId) {
        this.blogerId = blogerId;
    }

    public int getViews() {
        return views;
    }
    
    public void incViews(){
        views++;
    }
    
    
    
    
}
