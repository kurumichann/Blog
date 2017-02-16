$(document).ready(function(){
    var $picture =   $("#element ul li:has('a')")
    $picture.click(function(){
    	$("#articles").detach();
    	$("#pages_ul").detach();
    	$("#con").load("album.jsp #album");
    	

    })
    
 
})