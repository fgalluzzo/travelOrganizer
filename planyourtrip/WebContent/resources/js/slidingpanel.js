function slidePanel(){
	$("#slidingPanel").show("slide", { direction: "up" }, 1000);				
	
	$("#slidingPanel:visible").delay(5000).hide("slide", { direction: "up" }, 1000);	
	
} 



