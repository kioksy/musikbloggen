/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;



/**
 *
 * @author kloek
 */

public final class BlogCatalogue extends AbstractDAO<Blog, Long> implements IDAO<Blog, Long>,Serializable{
    
    private static EntityManagerFactory emf;

    /**
     * 
     * @param name persisten unit name
     * @return New BlogCatalogue instance.
     */
    static BlogCatalogue newInstance(String name) {
        return new BlogCatalogue(name);
    }
    
    private BlogCatalogue(String name) {
        super(Blog.class, name);
    }
    
    /**
     * 
     * @param name
     * @return list of blogs with matching names
     */
    public List<Blog> search(String name){        /////// skalll göras om så att namnet inte behöver stämma exakt för att hittas
        List<Blog> lb = new LinkedList<>();
        for(Blog b : getAll()){
            if(!(name == null)){
                if(name.toLowerCase().contains(b.getName().toLowerCase()) || name.toLowerCase().contains(b.getOwner().getFirstName().toLowerCase()) || name.toLowerCase().contains(b.getOwner().getLastName().toLowerCase())){
                lb.add(b);
                }
            }
        }
        return lb;
    }
    
    /**
     * 
     * @param name
     * @return blog with exact name
     */
    public Blog find(String name){        /////// skalll göras om så att namnet inte behöver stämma exakt för att hittas
        for(Blog b : getAll()){
            if(b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param email
     * @return finds blog by email
     */
    public Blog findByEmail(String email){        /////// skalll göras om så att namnet inte behöver stämma exakt för att hittas
        for(Blog b : getAll()){
            if(b.getOwner().getEmail().equals(email)){
                return b;
            }
        }
        return null;
    }

    /**
     * checks if blog blog with bname exists
     * @param bname
     * @return bool
     */
    public Boolean containsName(String bname) {
        for(Blog b : getAll()){
            if(b.getName().equals(bname)){
                return true;
            }
        }
        return false;
    }

    /**
     * checks if email is already used in database
     * @param email
     * @return bool
     */
    public boolean containsEmail(String email) {
        for(Blog b : getAll()){
            if(b.getOwner().getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    
    
}
