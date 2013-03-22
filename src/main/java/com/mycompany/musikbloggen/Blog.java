/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author kloek
 */
@Entity
@CascadeOnDelete
public class Blog implements Serializable {
    
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToOne
    private Owner owner;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @CascadeOnDelete
    private List<Post> posts = new LinkedList<>();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    private String password;
    private int views;
    
    
    public Blog() {
        
        this.owner = new Owner();
        
        views = 0;
        
        Calendar cal = Calendar.getInstance();
        this.created = cal.getTime();
    }


    /**
     * 
     * @return blog id 
     */
    public Long getId() {
        return id;
    }
    

    /**
     * 
     * @return blog name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param new name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    

    /**
     * 
     * @return date when created formated as string
     */
    public String getCreated() {
        return created.toString();
    }

    /**
     * adds post to this blog
     * 
     * @param post 
     */
    public void addPost(Post post){
        posts.add(post);
    }


    /**
     * 
     * @return list of all posts belonging to this blog
     */
    public List<Post> getPosts() {
        Collections.reverse(posts);
        return posts;
    }
    
    /**
     * 
     * @return nr of posts
     */
    public int getNrOfPosts(){
        return posts.size();
    }

    /**
     * 
     * @return returns owner as Owner Object
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * 
     * @return String description of blog
     */
    public String getDescription() {
        return description;
    }

    /**
     * setts the description of this blog.
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * change the password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", created=" + created + '}';
    }

    public Post find(Long pid) {
        for(Post p: posts){
            if(p.getId().equals(pid)){
                return p;
            }
        }
        return null;
    }
    
    
    public int getViews() {
        return views;
    }
    
    public void incViews(){
        views++;
    }
}
