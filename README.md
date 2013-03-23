Musikbloggen
============

Repo for our project (musikbloggen) on the course Webb-applikationer (DAT076) HT2012

##About MusikBloggen


MusikBloggen is a blog where you can register and publish your playlists from Spotify.

##Group and names

Musikbloggen-gruppen with members:

<b>Antonios Kioksoglou</b> - antkio@student.chalmers.se<br/>
<b>Anton Kloek</b> - kloek@student.chalmers.se


##General overview of the system

####What is this? In which area is this system supposed to be used and what is it supposed to do?

Musiklbloggen is a simple blog where you can register and publish your playlists from Spotify. This is supposed to be used for people
who want to find more playlists and therefore also find more music (new artists, new songs etc.). 
This is supposed to help people find more music.

####Possible user/roles
Since this is only in alpha-stage there is only simple bloggers and no admins. Everyone can register and start publishing their playlists.


####Use cases:

- Create accounts
- Login/signout
- Edit profile
- Add post (with/without Spotify uri)
- Check toplistor (only posts with spotify uri should end up here)
- Search (only for posts in alpha)
- Checkout bigPost by clicking i post.

##Technical info

####webpages + helpers
- HTML5 structure (XHTML pages)
- CSS
- some javascript
In theese pages you get the front-end part of the webpage

####com.mycompany.musikbloggen
This package contains the main java files for the system.

- AbstractDAO.java: Is our abstract data access object which handles methods like add, delete, find, getall etc.
- IDAO.java: Interface for the data access object
- Blog.java: object for a blog
- BlogCatalogue.java: Script for storing all blogs
- MusikBlogg.java: Creates singletons of Blogcatalogue and queryprocessor
- Owner.java: object for an owner of a blog
- Post.java: object for a blogpost
- QueryProcessor.java: Here we created some querys with SQL that our AbstractDAO couldn't handle.

####com.mycompany.musikbloggenBBs
This package contains all the backing beans we made for all different types of problems.
One bean never solves more than a few things.

- BlobBB.java : backing bean for getting all blogs and also getting latest members.
- BlogCatalogueBean.java: getting latest blogs and also posibility for special interval.
- BlogForwardBB.java: forwarding bean with actionlistener to find clicked blog.
- LoginBB.java: bean that handles login part.
- RegisterBB.java : handles the registration on the page.
- SearchBB.java : handles searching on the site.
- editProfileBB.java: handles all profile changes a bloger does.
- PostBB.java : handles a blog post.
- PostForwardBB.java: forwarding bean with actionlistener to find clicked post.

####Database
All our inserts are handeld with JDBC but we were forced to use some plain SQL for presenting different results that our
AbstractDAO couldn't handle. Therefore we included a queryprocessor (Queryprocessor.java) that takes care of this.

##Strong and week parts
The strongest part with MusikBloggen is that we made a really beautiful integration between spotify lists and the website.
Just by adding a spotify uri to your post you can add post name and description and get all this in a really nice view.

Bad parts: Since this is only in alpha stage you can't delete any blog or posts, you can also not edit any posts. You can also only search for a
post (you must type the name of the post correctly) and not search for bloggers. Theese are also the parts we would have fixed for a beta stage.

##Javadoc
We also included javadoc for easier understanding of the classes

The javadoc can be found in [target/site/apidocs](https://github.com/kioksy/musikbloggen/tree/master/target/site/apidocs)

###Cheers
