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

    static BlogCatalogue newInstance(String name) {
        return new BlogCatalogue(name);
    }
    
    private BlogCatalogue(String name) {
        super(Blog.class, name);
    }
    
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
    
    public Blog find(String name){        /////// skalll göras om så att namnet inte behöver stämma exakt för att hittas
        for(Blog b : getAll()){
            if(b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }
    
    public Blog findByEmail(String email){        /////// skalll göras om så att namnet inte behöver stämma exakt för att hittas
        for(Blog b : getAll()){
            if(b.getOwner().getEmail().equals(email)){
                return b;
            }
        }
        return null;
    }

    public Boolean containsName(String bname) {
        for(Blog b : getAll()){
            if(b.getName().equals(bname)){
                return true;
            }
        }
        return false;
    }

    public boolean containsEmail(String email) {
        for(Blog b : getAll()){
            if(b.getOwner().getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    
    
}
