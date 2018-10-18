function fundFileByParentId(parentId,isdir){
	if(isdir){
		$.ajax({
		    url : "/file/fundFileByParentId", 
			type: "post",
			async:true,
			contentType:"application/x-www-form-urlencoded",
			data: {"parentId":parentId},
	        success: function(data){//如果调用servlet成功，响应200。请求成功后回调函数。这个方法有两个参数：服务器返回数据，返回状态(可以缺省)。
	        	document.getElementById('allChecks').checked = false;
	        	document.getElementById('filesListHeadChangChose').style.display='none';
				document.getElementById('filesListHeadChangBtn').style.display='block';
	        	$(".filesListRoute").find("a").remove();
	        	$(".filesListRoute").find("span").remove();
	        	//路径链
	        	var link="";
	        	$.each(data.parent,function(i,file){
	        		if(i==(data.parent.length-1)){
	        			link+="<span>"+file.fname+"</span>";
	        		} else if(i == 0) {
	        			link+="<a href=\"/openfile?code="+urlcode+"\"><span>"+file.fname+"</span></a>"
	        			link+="<span>></span>";
	        		} else {
	        			link+="<a onclick=\"fundFileByParentId(\'"+file.fid+"\',"+file.isdir+")\" href=\"javascript:void(0);\"><span>"+file.fname+"</span></a>"
	        			link+="<span>></span>";
	        		}
	        	});
	        	$(".filesListRoute").append(link);
	        	$("#filesTab").find("tr").remove();
	        	$(".filesListCount").find("span").remove();
	        	$(".filesListCount").append("<span>已加载</span><span class='filesCount'>"+data.files.length+"</span><span>个</span>");
	        	$.each(data.files,function(i,file){
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
	        		str+="<a onclick=\"downFile(\'"+file.fid+"\',\'"+file.furl+"\',\'"+file.fname+"\',\'"+file.suffix+"\',"+file.isdir+")\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
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
}

//文件下载
function downFile(fid,fileurl , fileName , suffix , isdir){
	if(isdir){
		$.ajax({
			url:"/file/dirdownload",
			type: "post",
			async:true,
			contentType:"application/x-www-form-urlencoded",
			data: {"fid":fid},
			success: function(data){
				if(data=='200')
					alert('下载成功,请在桌面查看');
				else{
					alert('下载失败!!!');
				}
			},
			error: function(){
				alert('下载失败!!!');
			}
		})
	}else{
		$.ajax({
		    url : "/file/downlowd",
			type: "post",
			async:true,
			contentType:"application/x-www-form-urlencoded",
			data: {"fileurl":fileurl,'fileName':fileName,'suffix':suffix},
			success: function(data){
				if(data=='200')
					alert('下载成功,请在桌面查看');
				else{
					alert('下载失败!!!');
				}
			},
			error: function(){
				alert('下载失败!!!');
			}
	   });
	}
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