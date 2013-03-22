/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen.musikbloggenBBs;

import com.mycompany.musikbloggen.Blog;
import com.mycompany.musikbloggen.MusikBlogg;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kloek
 */

@Named("BlogCatalogueBean")
@SessionScoped
public class BlogCatalogueBean implements Serializable {
    
    
    
    public static List<Blog> getAll(){
        return MusikBlogg.INSTANCE.getBc().getAll();
    }
    
    public static List<Blog> getCount(int first, int total){
        return MusikBlogg.INSTANCE.getBc().getRange(first, total);
    }
    
    
}
