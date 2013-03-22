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

    /**
     * 
     * @return post id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @return post title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @return date when created formated as string
     */
    public String getCreated() {
        return created.toString();
    }

    /**
     * 
     * @return list of tags ( string)
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * 
     * @return string content in a post
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param title (string)
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @param tags list of strings
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @param content String
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return the spotify uri or null
     */
    public String getSpotifyUri() {
        return spotifyUri;
    }

    /**
     * checks if it "looks" like a real spotify uri and adds it to the post
     * @param spotifyUri (string)
     */
    public void setSpotifyUri(String spotifyUri) {
        String[] test = spotifyUri.split(":");
        if(test[0].equals("spotify")){
            hasUri = true;
            this.spotifyUri = spotifyUri;
        }else{
            hasUri = false;
        }
    }
    
    /**
     * 
     * @return the url for embeded spotify whith this uri 
     */
    public String getPlayer(){
        return "https://embed.spotify.com/?uri=" + spotifyUri;
    }
    
    /**
     * 
     * @return if post has spotify uri
     */
    public Boolean hasUri(){
        return hasUri;
    }

    /**
     * 
     * @return the id of the blog owning this post
     */
    public Long getBlogerId() {
        return blogerId;
    }

    public void setBlogerId(Long blogerId) {
        this.blogerId = blogerId;
    }

    /**
     * 
     * @return nr of views
     */
    public int getViews() {
        return views;
    }
    
    /**
     * increases the number of views by one.
     */
    public void incViews(){
        views++;
    }
    
    
    
    
}
