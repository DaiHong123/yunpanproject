//右侧功能栏点击事件
function asideAll(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>全部文件</span>");
	fundFileByTyPe("All");
}
function asideImg(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>全部图片</span>");
	fundImg();
}
function asideText(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>全部文档</span>");
	fundFileByTyPe("txt");
}
function asidevideo(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>全部视频</span>");
	fundFileByTyPe("mp4");
}
function asideSeed(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>全部种子</span>");
	fundFileByTyPe("bt");
}
function asideMusic(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>全部音乐</span>");
	fundFileByTyPe("mp3");
}
function asideOther(){
	document.getElementById('filesListHeadChangChose').style.display='none';
	document.getElementById('filesListHeadChangBtn').style.display='block';
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".filesListRoute").find("a").remove();
	$(".filesListRoute").find("span").remove();
	$(".filesListRoute").append("<span>其他文件</span>");
	fundFileByTyPe("other");
}

function fundFileByTyPe(type){
	$.ajax({
	    url : "/file/fundFile", 
		type: "post", 
		async:true,
		contentType:"application/x-www-form-urlencoded",
		data: {"type":type},
        success: function(data){//如果调用servlet成功，响应200。请求成功后回调函数。这个方法有两个参数：服务器返回数据，返回状态(可以缺省)。
        	document.getElementById('allChecks').checked = false;
        	$("#filesTab").find("tr").remove();
        	$(".filesListCount").find("span").remove();
        	$(".filesListCount").append("<span>已加载</span><span class='filesCount'>"+data.length+"</span><span>个</span>");
        	$.each(data,function(i,file){
        		var str="<tr data-file-id=\"1\" class=\"active\">";
        		str+="<td><input type=\"checkbox\" class=\"checkstyle\"  onclick=\"allcheck(),display()\"  value="+file.fid+" />";
        		if(file.isdir){
        			str+="<i class=\"fileIcon\"></i>";
        		}else if(file.suffix == "jpg"){
        			str+="<input id = \""+file.fname+"\" value = \""+file.furl+"\" style=\" display:none \">"
        			str+="<i id=\"btn\" onMouseOver=\"showInform(event,\'"+file.fname+"\')\" onMouseOut=\"hiddenInform(event)\" class=\"imgIcon\"></i>";
        		}else if(file.suffix == "txt"){
        			str+="<i class=\"txtIcon\"></i>";
        		}else if(file.suffix == "mp4"){
        			str+="<i class=\"videoIcon\"></i>";
        		}else if(file.suffix == "seed"){
        			str+="<i class=\"seedIcon\"></i>";
        		}else if(file.suffix == "mp3"){
        			str+="<i class=\"musicIcon\"></i>";
        		}else{
        			str+="<i class=\"otherIcon\"></i>";
        		}
        		str+="<a onclick=\"fundFileByParentId(\'"+file.fid+"\',"+file.isdir+")\" href=\"javascript:void(0);\" ><span class=\"fileTitle\" title="+file.fname+">"+file.fname+"</span></a>";
        		str+="<div class=\"filesFns right\">";
        		str+="<a class=\"icon icon-share\" href=\"javascript:;\">分享</a>";
        		str+="<a onclick=\"downFile(\'"+file.fid+"\',\'"+file.furl+"\',\'"+file.fname+"\',\'"+file.suffix+"\',"+file.isdir+")\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
        		str+="<a class=\"icon icon-more\" href=\"javascript:;\">更多</a>";
        		str+="</div></td><td><span>"
        		if(file.fsize){
        			str+=(file.fsize/(1024*1024)).toFixed(2)+"M</span></td>";
        		}else{
        			str+="——</span></td>";
        		}
        		str+="<td><span class=\"fileChangeDate\">"+dateFmt("yyyy-MM-dd",new Date(file.updatetime))+"</span></td></tr>";
        		$("#filesTab").append(str);
        	});
        }
	});
}

function fundImg(){
	$.ajax({
	    url : "/file/fundFile", 
		type: "post", 
		async:true,
		contentType:"application/x-www-form-urlencoded",
		data: {"type":"jpg"},
        success: function(data){//如果调用servlet成功，响应200。请求成功后回调函数。这个方法有两个参数：服务器返回数据，返回状态(可以缺省)。
        	document.getElementById('allChecks').checked = false;
        	$("#filesTab").find("tr").remove();
        	$(".filesListCount").find("span").remove();
        	$(".filesListCount").append("<span>已加载</span><span class='filesCount'>"+data.length+"</span><span>个</span>");
        	$.each(data,function(i,file){
        		var str="<tr data-file-id=\"1\" class=\"active\">";
        		str+="<td><input type=\"checkbox\" class=\"checkstyle\"  onclick=\"allcheck(),display()\"  value="+file.fid+" />";
        		str+="<a href=\"http://192.168.25.175/"+file.furl+"\" target=\"_new\" ><div  style=\" height:100px;width:100px;overflow:hidden;margin-bottom:10px \"><img src=\"http://192.168.25.175/"+file.furl+"\" style=\" height:100px;width:100px;\" /></div></a>";
        		str+="<div class=\"filesFns right\" style=\"margin-top:-68px;margin-right:10px\">";
        		str+="<a class=\"icon icon-share\" href=\"javascript:;\">分享</a>";
        		str+="<a onclick=\"downFile(\'"+file.fid+"\',\'"+file.furl+"\',\'"+file.fname+"\',\'"+file.suffix+"\',"+file.isdir+")\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
        		str+="<a class=\"icon icon-more\" href=\"javascript:;\">更多</a>";
        		str+="</div></td><td><span>"
        		if(file.fsize){
        			str+=(file.fsize/(1024*1024)).toFixed(2)+"M</span></td>";
        		}else{
        			str+="——</span></td>";
        		}
        		str+="<td><span class=\"fileChangeDate\">"+dateFmt("yyyy-MM-dd",new Date(file.updatetime))+"</span></td></tr>";
        		$("#filesTab").append(str);
        	});
        }
	});
}

function dateFmt(fmt,date) 
{ //author: meizz   
  var o = {
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 


//左侧容量显示
function capacity(){
	$.ajax({
		url:"/file/capacity",
		success:function(data){
			var size = "";
			var unit = "";
			if(Math.floor(data/(1024))==0){
				size = data;
				unit = "B";
			}else if(Math.floor(data/(1024*1024))==0){
				size = Math.floor(data/1024);
				unit = "K";
			}else if(Math.floor(data/(1024*1024*1024))==0){
				size = Math.floor(data/(1024*1024));
				unit = "M";
			}else if(Math.floor(data/(1024*1024*1024*1024))==0){
				size = Math.floor(data/(1024*1024*1024));
				unit = "G";
			}
		var ss = Math.floor(data/(1024*1024*1024));
		var ss = Math.floor(data/(1024*1024));
		var b =parseInt(((ss/1024)*100));
		var str ="";
		 str+="<div class='CapacityBar'>";
		str+="<span>"+b+"%</span>";
		str+="</div>";
		str+="<div class='contRightCapacityInfo'>";
		str+="<p class='left' style='font-size:15px'>";
		str+="<span class='UsedAmount' >"+size+"</span>"+unit+"/<span class='allAmount'>1</span>G";
		str+="</p>";
		str+="<a class='right' href='javascript:;'>扩容</a>";
		str+="</div>";
		$('.contRightCapacity').find('div').remove();
		
		$('.contRightCapacity').append(str)
		$('.CapacityBar').find('span').css('width',(b*154)/100);
		}
	})
}
$(function(){
	$.ajax({
		url:"/file/capacity",
		success:function(data){
			var size = "";
			var unit = "";
			if(Math.floor(data/(1024))==0){
				size = data;
				unit = "B";
			}else if(Math.floor(data/(1024*1024))==0){
				size = Math.floor(data/1024);
				unit = "K";
			}else if(Math.floor(data/(1024*1024*1024))==0){
				size = Math.floor(data/(1024*1024));
				unit = "M";
			}
		var ss = Math.floor(data/(1024*1024));
		var b =parseInt(((ss/1024)*100));
		var str ="";
		 str+="<div class='CapacityBar'>";
		str+="<span>"+b+"%</span>";
		str+="</div>";
		str+="<div class='contRightCapacityInfo'>";
		str+="<p class='left' style='font-size:15px'>";
		str+="<span class='UsedAmount' >"+size+"</span>"+unit+"/<span class='allAmount'>1</span>G";
		str+="</p>";
		str+="<a class='right' href='javascript:;'>扩容</a>";
		str+="</div>";
		$('.contRightCapacity').find('div').remove();
		
		$('.contRightCapacity').append(str)
		$('.CapacityBar').find('span').css('width',(b*154)/100);
		}
	})
})


$('#searcher').on('click',function(){
	var ss = $('.txt').val();
	$.ajax({
		url:"/file/searchName",
		data:{"searchName":ss},
		success:function(data){
	    	$('.filesListRoute').find('span').remove();
	    	$('.filesListRoute').append("<span id='search'><a onclick='asideAll()' style='cursor:pointer'>全部文件</a><span><span>>搜索：\""+ss+"\"</span>");
	    	document.getElementById('allChecks').checked = false;
	    	$("#filesTab").find("tr").remove();
	    	$(".filesListCount").find("span").remove();
	    	$(".filesListCount").append("<span>已加载</span><span class='filesCount'>"+data.length+"</span><span>个</span>");
	    	$.each(data,function(i,file){
	    		var str="<tr data-file-id=\"1\" class=\"active\">";
	    		str+="<td><input type=\"checkbox\" class=\"checkstyle\"  onclick=\"allcheck(),display()\"  value="+file.fid+" />";
	    		if(file.isdir){
	    			str+="<i class=\"fileIcon\"></i>";
	    		}else if(file.suffix == "jpg"){
	    			str+="<input id = \""+file.fname+"\" value = \""+file.furl+"\" style=\" display:none \">"
	    			str+="<i id=\"btn\" onMouseOver=\"showInform(event,\'"+file.fname+"\')\" onMouseOut=\"hiddenInform(event)\" class=\"imgIcon\"></i>";
	    		}else if(file.suffix == "txt"){
	    			str+="<i class=\"txtIcon\"></i>";
	    		}else if(file.suffix == "mp4"){
	    			str+="<i class=\"videoIcon\"></i>";
	    		}else if(file.suffix == "seed"){
	    			str+="<i class=\"seedIcon\"></i>";
	    		}else if(file.suffix == "mp3"){
	    			str+="<i class=\"musicIcon\"></i>";
	    		}else{
	    			str+="<i class=\"otherIcon\"></i>";
	    		}
	    		str+="<a onclick=\"fundFileByParentId(\'"+file.fid+"\',"+file.isdir+")\" href=\"javascript:void(0);\" ><span class=\"fileTitle\" title="+file.fname+">"+file.fname+"</span></a>";
	    		str+="<div class=\"filesFns right\">";
	    		str+="<a class=\"icon icon-share\" href=\"javascript:;\">分享</a>";
	    		str+="<a onclick=\"downFile(\'"+file.fid+"\',\'"+file.furl+"\',\'"+file.fname+"\',\'"+file.suffix+"\',"+file.isdir+")\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
	    		str+="<a class=\"icon icon-more\" href=\"javascript:;\">更多</a>";
	    		str+="</div></td><td><span>"
	    		if(file.fsize){
	    			str+=(file.fsize/(1024*1024)).toFixed(2)+"M</span></td>";
	    		}else{
	    			str+="——</span></td>";
	    		}
	    		str+="<td><span class=\"fileChangeDate\">"+dateFmt("yyyy-MM-dd",new Date(file.updatetime))+"</span></td></tr>";
	    		$("#filesTab").append(str);
	    	});
		}	
	})
		
	
	
})




$('#fileSearch').ajaxForm({
	// 设置返回格式
    dataType : "json",
    url : "/file/searchName",
    success : function(data){
    	var names = $('.txt').val();
    	$('.filesListRoute').find('span').remove();
    	$('.filesListRoute').append("<span id='search'><a onclick='asideAll()' style='cursor:pointer'>全部文件</a><span><span>>搜索：\""+names+"\"</span>");
    	document.getElementById('allChecks').checked = false;
    	$("#filesTab").find("tr").remove();
    	$(".filesListCount").find("span").remove();
    	$(".filesListCount").append("<span>已加载</span><span class='filesCount'>"+data.length+"</span><span>个</span>");
    	$.each(data,function(i,file){
    		var str="<tr data-file-id=\"1\" class=\"active\">";
    		str+="<td><input type=\"checkbox\" class=\"checkstyle\"  onclick=\"allcheck(),display()\"  value="+file.fid+" />";
    		if(file.isdir){
    			str+="<i class=\"fileIcon\"></i>";
    		}else if(file.suffix == "jpg"){
    			str+="<input id = \""+file.fname+"\" value = \""+file.furl+"\" style=\" display:none \">"
    			str+="<i id=\"btn\" onMouseOver=\"showInform(event,\'"+file.fname+"\')\" onMouseOut=\"hiddenInform(event)\" class=\"imgIcon\"></i>";
    		}else if(file.suffix == "txt"){
    			str+="<i class=\"txtIcon\"></i>";
    		}else if(file.suffix == "mp4"){
    			str+="<i class=\"videoIcon\"></i>";
    		}else if(file.suffix == "seed"){
    			str+="<i class=\"seedIcon\"></i>";
    		}else if(file.suffix == "mp3"){
    			str+="<i class=\"musicIcon\"></i>";
    		}else{
    			str+="<i class=\"otherIcon\"></i>";
    		}
    		str+="<a onclick=\"fundFileByParentId(\'"+file.fid+"\',"+file.isdir+")\" href=\"javascript:void(0);\" ><span class=\"fileTitle\" title="+file.fname+">"+file.fname+"</span></a>";
    		str+="<div class=\"filesFns right\">";
    		str+="<a class=\"icon icon-share\" href=\"javascript:;\">分享</a>";
    		str+="<a onclick=\"downFile(\'"+file.fid+"\',\'"+file.furl+"\',\'"+file.fname+"\',\'"+file.suffix+"\',"+file.isdir+")\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
    		str+="<a class=\"icon icon-more\" href=\"javascript:;\">更多</a>";
    		str+="</div></td><td><span>"
    		if(file.fsize){
    			str+=(file.fsize/(1024*1024)).toFixed(2)+"M</span></td>";
    		}else{
    			str+="——</span></td>";
    		}
    		str+="<td><span class=\"fileChangeDate\">"+dateFmt("yyyy-MM-dd",new Date(file.updatetime))+"</span></td></tr>";
    		$("#filesTab").append(str);
    	});
    }
})
	
$('#filesSortId').on('click',function(){
	var ss = $('.txt').val();
	var s1 = $('#search').text();
	if(s1==""){
		ss = "";
	}
	var group = $('.show').attr('title')
	$.ajax({
		url:"/file/group",
		data:{"group":group,
			"searchName":ss},
		success:function(data){
				document.getElementById('allChecks').checked = false;
		    	$("#filesTab").find("tr").remove();
		    	$(".filesListCount").find("span").remove();
		    	$(".filesListCount").append("<span>已加载</span><span class='filesCount'>"+data.length+"</span><span>个</span>");
				$.each(data,function(i,file){
	        		var str="<tr data-file-id=\"1\" class=\"active\">";
	        		str+="<td><input type=\"checkbox\" class=\"checkstyle\" value="+file.fid+" onclick=\"allcheck(),display()\"/>";
	        		if(file.isdir){
	        			str+="<i class=\"fileIcon\"></i>";
	        		}else if(file.suffix == "jpg"){
	        			str+="<input id = \""+file.fname+"\" value = \""+file.furl+"\" style=\" display:none \">"
	        			str+="<i id=\"btn\" onMouseOver=\"showInform(event,\'"+file.fname+"\')\" onMouseOut=\"hiddenInform(event)\" class=\"imgIcon\"></i>";
	        		}else if(file.suffix == "txt"){
	        			str+="<i class=\"txtIcon\"></i>";
	        		}else if(file.suffix == "mp4"){
	        			str+="<i class=\"videoIcon\"></i>";
	        		}else if(file.suffix == "seed"){
	        			str+="<i class=\"seedIcon\"></i>";
	        		}else if(file.suffix == "mp3"){
	        			str+="<i class=\"musicIcon\"></i>";
	        		}else{
	        			str+="<i class=\"otherIcon\"></i>";
	        		}
	        		str+="<a onclick=\"fundFileByParentId(\'"+file.fid+"\',"+file.isdir+")\" href=\"javascript:void(0);\" ><span class=\"fileTitle\" title="+file.fname+">"+file.fname+"</span></a>";
	        		str+="<div class=\"filesFns right\">";
	        		str+="<a class=\"icon icon-share\" href=\"javascript:;\">分享</a>";
	        		str+="<a onclick=\"downFile(\'"+file.fid+"\',\'"+file.furl+"\',\'"+file.fname+"\',\'"+file.suffix+"\',"+file.isdir+")\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
	        		str+="<a class=\"icon icon-more\" href=\"javascript:;\">更多</a>";
	        		str+="</div></td><td><span>"
	        		if(file.fsize){
	        			str+=(file.fsize/(1024*1024)).toFixed(2)+"M</span></td>";
	        		}else{
	        			str+="——</span></td>";
	        		}
	        		str+="<td><span class=\"fileChangeDate\">"+dateFmt("yyyy-MM-dd",new Date(file.updatetime))+"</span></td></tr>";
	        		$("#filesTab").append(str);
	        	});
		}
	})
})



