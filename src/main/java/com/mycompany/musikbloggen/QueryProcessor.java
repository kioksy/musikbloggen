/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musikbloggen;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author kloek
 */
public class QueryProcessor {

    private static EntityManagerFactory emf;
    
    public QueryProcessor(String s) {
        emf = Persistence.createEntityManagerFactory(s);
    }
    
     public List<Post> getLatestLists(int nrOfLists){
        EntityManager em = emf.createEntityManager();
        String s;
        s = "SELECT p from Post p WHERE p.hasUri=:id ORDER BY p.id DESC";
        Query q = em.createQuery(s).setParameter("id", Boolean.TRUE);
        List<Post> posts = q.getResultList();
        posts = posts.subList(0, ((posts.size() <= nrOfLists) ? posts.size() : nrOfLists));
        return posts;
    }
     
     public List<Post> getLatestBlogPosts(int nrOfPosts){
        EntityManager em = emf.createEntityManager();
        String s;
        s = "SELECT p from Post p WHERE p.hasUri=:id ORDER BY p.id DESC";
        Query q = em.createQuery(s).setParameter("id", Boolean.FALSE);
        List<Post> posts = q.getResultList();
        posts = posts.subList(0, ((posts.size() <= nrOfPosts) ? posts.size() : nrOfPosts));
        return posts;
     }
     
     public List<Post> getSearch(String input){
        EntityManager em = emf.createEntityManager();
        String s;
        s = "SELECT p from Post p WHERE p.title =:title ORDER BY p.created DESC";
        Query q = em.createQuery(s).setParameter("title", input);
        List<Post> posts = q.getResultList();
        return posts;
     }
     
     public List<Post> getTopPosts(int nrOfPosts){
        EntityManager em = emf.createEntityManager();
        String s;
        s = "SELECT p from Post p WHERE p.hasUri=:id ORDER BY p.views DESC";
        Query q = em.createQuery(s).setParameter("id", Boolean.TRUE);
        List<Post> posts = q.getResultList();
        posts = posts.subList(0, ((posts.size() <= nrOfPosts) ? posts.size() : nrOfPosts));
        return posts;
     }
     
     public void incViews(Long postId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Post p SET p.views=p.views+1 WHERE p.id = :pid")
                            .setParameter("pid", postId)
                            .executeUpdate();
        em.getTransaction().commit();
     }
   
      public void deletePost(Long postId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Post q WHERE q.id = :qpid")
                            .setParameter("qpid", postId)
                            .executeUpdate();
        em.getTransaction().commit();
     }
    
}
