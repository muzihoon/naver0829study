$(function(){
	//h1.title을 클릭시 .music-list 를 slideDown 한다
	$("h1.title").click(function(){
		$(".music-list").slideDown('slow');
	});
	//노래 제목을 클릭시 클릭한곳의 제목을 얻어서 h1.title 에 넣은 후 slideUp 한다. 제목은 li.text
	$("ul.music-list li").click(function(){
		//노래 제목
		let title = $(this).text();
		//적용
		$("h1.title").text(title);
		//class를 얻는다
		let selectClass = $(this).attr("class");
		
		//적용 -animate
		$("#cd").animate({width:'0'},'slow',function(){
			//cd변경
			$("#cd").attr("class",selectClass);
			//너비를 다시 300으로 변경
			$(this).animate({width:'300px'},'slow');
		});
		
		$("ul.music-list").slideUp('slow');
	});
	
});