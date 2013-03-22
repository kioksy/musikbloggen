/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("blogs")
@SessionScoped
public class BlobBB implements Serializable{
    
    private Long id;
    
    
    /**
     * 
     * @return list of all blogs
     */
    @Inject
    public List<Blog> getAll(){
        List<Blog> reversed = BlogCatalogueBean.getAll();
        Collections.reverse(reversed);
        return reversed;
    }
    
    /**
     * 
     * @return returns 8 latest created blogs
     */
    @Inject
    public List<Blog> getLatestOwners(){
        List<Blog> reversed = BlogCatalogueBean.getCount(0,8);
        Collections.reverse(reversed);
        return reversed;
    }
    
    
}
