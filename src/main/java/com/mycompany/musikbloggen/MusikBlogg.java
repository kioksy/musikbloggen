/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kloek
 */
public enum MusikBlogg {
    
    INSTANCE;
    private final BlogCatalogue bc = BlogCatalogue.newInstance("music_pu");
    private final QueryProcessor qp = new QueryProcessor("music_pu");

    
    
    private MusikBlogg(){
        Logger.getAnonymousLogger().log(Level.INFO, "Blog alive {0}", this.hashCode());
    }


    public BlogCatalogue getBc() {
        return bc;
    }

    public QueryProcessor getQp() {
        return qp;
    }
    
}
