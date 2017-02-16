/**
 * 
 */
window.onload = function(){
	waterfall();
    

}
function waterfall(){
    var $array = $(".box");
    var heigthArry = [];
    var cols = Math.floor($("#content_pic").width()/$array.eq(0).outerWidth());
    var width = $array.eq(0).outerWidth();
    var minHeight;
    var minHeightIndex;
    $.each($array, function(index, val) {
        if(index<cols){
        heigthArry[index] = $array.eq(index).outerHeight();
        }
        else{
            /*console.log(heigthArry);*/
            minHeight = Math.min.apply(null,heigthArry);
            minHeightIndex = $.inArray(minHeight, heigthArry);
            $(val).css({
                "position":"absolute",
                "left": width*minHeightIndex+"px",
                "top":minHeight+"px",
            })
            console.log("meizha"+" "+$(".pic img").eq(index).height());
            if($(".box").eq(index).outerHeight()==37){
                $(".box").eq(index).outerHeight();
                /*console.log("zhala"+" "+$(".pic img").eq(index).height())*/
            }
            heigthArry[minHeightIndex] += $(".box").eq(index).outerHeight();
        }
      
    });
}
