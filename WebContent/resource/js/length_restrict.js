/**
 * 
 */
$(document).ready(function() {
    var count = $(".arti_img h1").length;
    for(var i = 0 ; i < count ; i++){
        var text = $(".arti_img h1").eq(i).text();
        
        if($(".arti_img h1").eq(i).text().length < 100){
        	continue;
        }
        
        $(".arti_img h1").eq(i).text(text.substring(0,100))
        .append("<a id = continue>继续阅读 →</a>");
    }
    
});