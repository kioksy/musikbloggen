 
 $(this).scroll(function() {
    if ($(this).scrollTop() > 80) { 
        $("#main").css({ "position": "fixed", "top": "0px" });
    } else {
        $("#main").css({ "position": "absolute", "top": "80px" });
    }   			
});