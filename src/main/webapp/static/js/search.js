//右侧功能栏点击事件
function asideAll(){
	$(".asideAll").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}
function asideImg(){
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}
function asideText(){
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}
function asidevideo(){
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}
function asideSeed(){
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}
function asideMusic(){
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}
function asideOther(){
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.05)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#3b8cff"});
}

function fundFile(type){
	$.ajax({
	    url : "/file/fundFile", 
		type: "post", 
		async:true,
		contentType:"application/x-www-form-urlencoded",
		data: {"type":type},
        success: function(data){//如果调用servlet成功，响应200。请求成功后回调函数。这个方法有两个参数：服务器返回数据，返回状态(可以缺省)。
        	
        }
	});
}