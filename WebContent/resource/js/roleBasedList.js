/**
 * 
 */
$(function(){
	var Role = $("#login_user");;
	var manaement = $("#management");
	if(manaement.length>0){
		$(manaement).css({ "display":"none"});
		$(Role).hover( function(){
        $(management).is(':visible')?$(management).css({ "display":"none"}):
            $(management).css({ "display":"block"});
    });
	}	

	$(manaement).click(function(){
		$("#con").load("management");
	})
	
})