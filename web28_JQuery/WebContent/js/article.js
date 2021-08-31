$(function(){
 		var firstP = $('p:eq(1)');
 		// alert(firstP.html()); // val()은 form값 넣거나 받아올 때만 사용
 	
 		$('a.more').click(function () {
    		if(firstP.is(':hidden')){ // 2번째 p태그가 안보인다면
    			firstP.slideToggle('slow');
    			$(this).html('read less');
    		} else{
    			firstP.slideToggle('slow');
    			$(this).html('read more');
    		}
		});
		
		// 현재 크기를 먼저 알아낸다.
		var speech = $('div.speech');
		var defaultSize = speech.css('fontSize');
		
		var num = parseInt(defaultSize, 10);
		
		$('#switcher>button').click(function () {
    		switch(this.id){
    			default :
    				num = parseInt(defaultSize, 10);	
    			break;
    			
    			case 'switcher-large' :
    				num+=5;
    			break;
    			
    			case 'switcher-small' :
    				num-=5;
    			break;
    		} // switch
    		// 반드시 animate() 적용
    		speech.animate({fontSize:num+'px'}, 'slow');
    		
		}); // click
	}); //ready