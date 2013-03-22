package com.mycompany.musikbloggen;

import com.mycompany.musikbloggen.Owner;
import com.mycompany.musikbloggen.Post;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-22T16:55:35")
@StaticMetamodel(Blog.class)
public class Blog_ { 

    public static volatile SingularAttribute<Blog, Long> id;
    public static volatile SingularAttribute<Blog, Date> created;
    public static volatile SingularAttribute<Blog, String> description;
    public static volatile SingularAttribute<Blog, Integer> views;
    public static volatile SingularAttribute<Blog, String> name;
    public static volatile SingularAttribute<Blog, Owner> owner;
    public static volatile ListAttribute<Blog, Post> posts;
    public static volatile SingularAttribute<Blog, String> password;

}