function cancel(id) {
	if(confirm("确认取消分享？")) {
		$.ajax({
			url:"/cancelShare",
			type:"POST",
			contentType:"application/x-www-form-urlencoded",
			data:{"sid":id},
			success:function(data) {
				data = JSON.parse(data);
				alert(data);
				if( data == "取消成功") window.close();
			},
			error:function() {
				alert("取消分享出错");
			}
		});
	 }
}

function login(uid) {
	if( uid == null || uid.trim() == '' ) {
		alert("请先登录");
		return false;
	}
}