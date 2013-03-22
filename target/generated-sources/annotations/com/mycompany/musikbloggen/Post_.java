package com.mycompany.musikbloggen;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-22T16:55:35")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Long> id;
    public static volatile SingularAttribute<Post, List> tags;
    public static volatile SingularAttribute<Post, String> content;
    public static volatile SingularAttribute<Post, String> title;
    public static volatile SingularAttribute<Post, String> spotifyUri;
    public static volatile SingularAttribute<Post, Date> created;
    public static volatile SingularAttribute<Post, Long> blogerId;
    public static volatile SingularAttribute<Post, Integer> views;
    public static volatile SingularAttribute<Post, Boolean> hasUri;

}