window.onload = function() {
	$(".asideAll").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideImg").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideText").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asidevideo").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideSeed").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMusic").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideOther").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
	$(".asideMyShare").css({"background":"rgba(0,0,0,.05)","color":"#3b8cff"});
	$(".asideRecycle").css({"background":"rgba(0,0,0,.01)","color":"#424e67"});
}

// 点击复制按钮
function copy(obj) {
	var code = $(obj).attr("data");
	var clipboard = new ClipboardJS(obj, {
        text: function() {
            return "http://localhost:8080/openfile?code="+code;
        }
    });
    clipboard.on('success', function(e) {//复制成功执行的回调，可选
        alert("复制到剪切板了，粘贴给您的朋友吧。");
        clipboard.destroy();
    });
    clipboard.on('error', function(e) {//复制失败执行的回调，可选
    	alert("复制失败了T_T");
    	if(clipboard) {
            clipboard.destroy();
        }
    });
}
function cancel1(id) {
	if(confirm("确认取消分享？")) {
		$.ajax({
			url:"/cancelShare",
			type:"POST",
			contentType:"application/x-www-form-urlencoded",
			data:{"sid":id},
			success:function(data) {
				data = JSON.parse(data);
				alert(data);
				window.location.href="/myshare"; 
			},
			error:function() {
				alert("取消分享出错");
			}
		});
	 }
}