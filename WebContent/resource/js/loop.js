/**
 * 
 */
 var i = 0;
$(document).ready(function(){
    var img = new Image();
    img.src =$("#toptag img").attr("src") ;
    var imgHeight = img.height;
    var divHeight = $("#toptag").height();
    var count = imgHeight/divHeight;
    setInterval(function(){loop(divHeight,count)},4000);
})
function loop(divHeight,count){  
    if(i==5){
        i = 0;
        $("#img").animate({top:"-"+divHeight*(i++)+"px"},1000);
        return;
    }
    $("#img").animate({top:"-"+divHeight*(i++)+"px"},2000);
}