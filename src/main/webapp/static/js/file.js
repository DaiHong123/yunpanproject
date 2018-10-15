
var sures;
var namecm;
function createFile() {
	this.obj = document.getElementById('filesTab');
	this.child = this.obj.children;
	var fid = "";
	var str = "<tr data-file-id='2' class='active' >";
	str += "<td>";
	str += "<input type='checkbox' class='checkstyle' value='2' onclick='allcheck(),display()' />";
	str += "<i class='fileIcon'></i>";
	str += "<a onclick=\"\" href=\"javascript:void(0);\" class='acreateFile'><span class='fileTitle' title='新建文件夹' >新建文件夹</span></a>";
	str += "</td>";
	str += "<td>";
	str += "<span></span>";
	str += "</td>";
	str += "<td>";
	str += "<span class='fileChangeDate'>" + getNowFormatDate() + "	</span>";
	str += "</tr>";
	this.obj.innerHTML = str + this.obj.innerHTML;
	var obj = {
		title : "新建文件夹"
	};
	var name = "create";
	rename(name,this.child[0], obj, function() {

		
	}, function() {
		this.obj.removeChild(this.child[0]);
	});
	
}

// 重命名
function rename(names,domObj, dataObj, success, fail) {
	var fid = "";
	var _this = this;
	var moduleName = document.getElementById('moduleFlieName');
	var topNum = domObj.offsetTop, leftNum = domObj.offsetLeft;
	// 控制输入框的位置
	moduleName.style.display = 'block';
	moduleName.style.top = topNum + 37 + 'px';
	moduleName.style.left = leftNum + 'px';
	var oInput = moduleName.getElementsByTagName('input')[0];
	var aSpans = moduleName.getElementsByTagName('span');
	oInput.value = dataObj.title;
	// 将输入框中的东西全选中
	oInput.select();
	aSpans[0].onclick = function() {
		var newName = oInput.value;
		dataObj.title = newName;
		var a = document.getElementsByClassName('fileTitle');
		// 判断是否有重名现象
		var s = 0;
		var b = 0;
		var count = 0;
		for (var i = 0; i < a.length; i++) {
			if (a[i].innerHTML == "新建文件夹") {
				count++;
			}
		}
		while (true) {
			if (s == 0) {
				var name = newName;
			} else {
				var name = newName + "(" + s + ")";
			}
			for (var i = 0; i < a.length; i++) {
				if (name == a[i].innerHTML) {
					s++;
					break;
				}
				b = i;
			}
			if (b == a.length - 1) {
				break;
			}

		}
		if (newName == "新建文件夹") {
			if (count == 1) {
				getByClass('fileTitle', domObj)[0].innerHTML = newName;
				getByClass('fileTitle', domObj)[0].title = newName;
			} else {
				getByClass('fileTitle', domObj)[0].innerHTML = newName + '('
						+ s + ')';
				getByClass('fileTitle', domObj)[0].title = newName + '(' + s
						+ ')';
			}
			newName = getByClass('fileTitle', domObj)[0].innerHTML;
		} else {
			if (s == 0) {
				getByClass('fileTitle', domObj)[0].innerHTML = newName;
				getByClass('fileTitle', domObj)[0].title = newName;
			} else {
				getByClass('fileTitle', domObj)[0].innerHTML = newName + '('
						+ s + ')';
				getByClass('fileTitle', domObj)[0].title = newName + '(' + s
						+ ')';
				newName = getByClass('fileTitle', domObj)[0].innerHTML;
			}
		}
		if(names=="create"){
			$.ajax({
				url : "/file/createFile",
				type : "post",
				async : false,
				contentType : "application/x-www-form-urlencoded",
				data : {
					"fname" : newName
				}, 
				success : function(data) {
					if (data != null) {
						fid = data.fid;
						alert("创建成功");
					} else {
						alert("网络异常创建失败");
					}
				}
			});	
			getByClass('checkstyle', domObj)[0].value = fid;
			$('.acreateFile').attr("onclick","fundFileByParentId(\'"+fid+"\',true)");	
			
			

			
			
		}else if(names=="resname"){
			var fid ;
			 $("input[class='checkstyle']:checked").each(function() { // 遍历选中的checkbox
				 fid = $(this).val();
		     });
			$.ajax({
				url : "/file/rename",
				type : "get",
				async : false,
				contentType : "application/x-www-form-urlencoded",
				data : {
					"fname" : newName,
					"fid":fid
				}, 
				success : function(data) {
					if(data){
						alert("重命名成功")
					}else{
						alert("网络异常失败");
					}
				}
			});
		}
			
		
		
		
		success && success();
		moduleName.style.display = 'none';
	}
	aSpans[1].onclick = function() {
		fail && fail();
		moduleName.style.display = 'none';
	}
}

// 获取当前的所有className
function getByClass(className, parent) {
	parent = parent ? parent : document;
	if (parent.getElementsByClassName) {
		return parent.getElementsByClassName(className);
	} else {
		var ele = parent.getElementsByTagName('*');
		var arr = [];
		for (var i = 0; i < ele.length; i++) {
			if (tools.hasClass(ele[i].className, className)) {
				arr.push(ele[i]);
			}
		}
		return arr;
	}
}

function addClass(obj, className) {
	obj.className = className;
}

// 选择并重命名
function check() {
	var obj = {
		title : "1"
	};
	this.obj = document.getElementById('filesTab');
	this.child = this.obj.children;
	var ss = document.getElementsByClassName('checkstyle');
	var flag = -1;
	var count = 0;
	for (var i = 0; i < ss.length; i++) {
		if (ss[i].checked) {
			flag = i;
			count++;
		}
	}
	if (count == 1) {
		obj.title = document.getElementsByClassName('fileTitle')[flag].title;
		var name = "resname";
		rename(name,this.child[flag], obj);
	}
}
// 全选和全不选
function ckAll() {
	var flag = document.getElementById("allChecks").checked;
	var cks = document.getElementsByClassName('checkstyle');
	for (var i = 0; i < cks.length; i++) {
		cks[i].checked = flag;
	}
}

// 控制全选和部分选后的全选按钮的改变
function allcheck() {
	var cks = document.getElementsByClassName('checkstyle');
	var s = 0;
	for (var i = 0; i < cks.length; i++) {
		if (cks[i].checked == true) {
			s++;
		}
	}
	if (s == cks.length) {

		document.getElementById('allChecks').checked = true;
	} else {
		document.getElementById('allChecks').checked = false;
	}
}

// 展示和隐藏前端的下载和重命名等
function display() {
	var cks = document.getElementsByClassName('checkstyle');
	var dis = document.getElementById('filesListHeadChangChose');
	var rdis = document.getElementById('headResetName');
	var adis = document.getElementById('filesListHeadChangBtn');
	var s = 0;
	for (var i = 0; i < cks.length; i++) {
		if (cks[i].checked == true) {
			s++;
		}
	}
	if (s >= 1) {
		dis.style.display = "block";
		adis.style.display = 'none'
		if (s >= 2) {
			rdis.style.cursor = ' ';
			rdis.style.color = '#aaaacc';
		} else {
			rdis.style.cursor = 'pointer';
			rdis.style.color = '#3b8cff';
		}
	} else if (s == 0) {
		dis.style.display = 'none';
		adis.style.display = 'block'
	}
}

// 获取当前时间
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1
			+ strDate;
	return currentdate;
}


//删除文件
function deletefile(){
	var fids = [];
	var i = 0;
	 $("input[class='checkstyle']:checked").each(function() { // 遍历选中的checkbox
		 fids[i] = $(this).val();
		 i++;
         n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
         $("table.files").find("tr:eq("+n+")").remove();
     });
	 $.ajax({
			url : "/file/deleteFile",
			type : "get",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			data : {
				 fids
			}, 
			success : function(data) {
				document.getElementById('allChecks').checked = false;
				document.getElementById('filesListHeadChangChose').style.display='none';
				document.getElementById('filesListHeadChangBtn').style.display='block';
				alert("删除成功");
			}
		});	
}



//选择复制还是移动
function isCopyOrMove(names){
	var str ="";
	str+="<span class='dialog-header-title'><em class='select-text' >"+names+"</em></span>";
	document.getElementById('aa').innerHTML = str;
	document.getElementById('module-canvas').style.display='block';
	document.getElementById('fileTreeDialog').style.display='block';
	namecm = names;
	
}





function get(obj){
	sures = obj.attributes['data-file-id'].nodeValue;
}

//取消
function cancel(){
	document.getElementById('module-canvas').style.display='none';
	document.getElementById('fileTreeDialog').style.display='none';
}
function sure(){
	if(namecm=='复制到'){
		var fids = [];
		var i = 0;
		 $("input[class='checkstyle']:checked").each(function() { // 遍历选中的checkbox
			 fids[i] = $(this).val();
			 i++;
	         n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
	     });
		 $.ajax({
				url : "/file/copyFiles",
				type : "get",
				async : false,
				contentType : "application/x-www-form-urlencoded",
				data : {
					pid:sures,
					 fids
				}, 
				success : function(data) {
					if(data){
						alert("复制成功")
					}else{
						alert("复制失败")
					}
				}
			});		 
	}else{
		var fids = [];
		var i = 0;
		 $("input[class='checkstyle']:checked").each(function() { // 遍历选中的checkbox
			 fids[i] = $(this).val();
			 i++;
	         n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
	         $("table.files").find("tr:eq("+n+")").remove();
	     });
		 $.ajax({
				url : "/file/moveFiles",
				type : "get",
				async : false,
				contentType : "application/x-www-form-urlencoded",
				data : {
					pid:sures,
					 fids
				}, 
				success : function(data) {
					if(data){
						alert("移动成功")
					}else{
						alert("移动失败")
					}
				}
			});	
	}
	   

}

//分享
function shareFile() {
	var str ="";
	str+="<span class='dialog-header-title'><em class='select-text' >创建分享</em></span>";
	$('#bb').html(str);
	var str1 = '';
	str1 += '<a class="g-button g-button-large" title="取消分享" style="float: right; padding-left: 50px;"><span class="g-button-right" style="padding-right: 50px;"><span class="text" style="width: auto;" onclick="cancelShare()">取消分享</span></span></a><a class="g-button g-button-blue-large" title="创建分享" style="float: right; padding-left: 50px;" onclick="createShare()"><span class="g-button-right" style="padding-right: 50px;"><span class="text" style="width: auto;">创建分享</span></span></a>';
	$("#shareSelect").html(str1);
	var str2 = '';
	str2 += '<div class="context">创建分享后，可以让任何人查看或下载，是否确认创建分享？</div>';
	$("#shareContext").html(str2);
	$("#module-share").css("display", "block");
	$("#shareDialog").css("display", "block");
}

// 取消分享
function cancelShare() {
	$("#module-share").css("display", "none");
	$("#shareDialog").css("display", "none");
}

// 创建分享
function createShare() {
	// 获取到选中文件的id，然后使用AJAX异步创建分享，显示文件访问链接
	var fids = '';
	var i = 0;
	$("input[class='checkstyle']:checked").each(function() { // 遍历选中的checkbox
		if( i != 0 ) fids += ',';
		fids += $(this).val();
		i++;
        n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
    });
	$.ajax({
		url:'/share',
		type:'POST',
		async : false,
		contentType : "application/x-www-form-urlencoded",
		data: {'fids': fids},
		success: function(data) {
			data = JSON.parse(data);
			if( data.code == 1 ) {// 分享成功
				var url = data.url;
				var str = '';
				str += '<div class="success-context"><div class="url-info">';
				str += '<span class="share-success"><em class="icon"></em>成功创建分享链接 </span>';
				str += '<div class="url-context"><div class="copy-button-section" onclick="copyurl()">';
				str += '<a class="g-button g-button-blue copy-button" id="copyShare">';
				str += '<span class="g-button-right"><span class="text public" id="cc">复制链接</span>';
				str += '</span></a><div class="copy-tips" id="copy-tips" style="display: none;">复制链接成功</div>';
				str += '</div><div class="url"><div class="share-url-border">';
				str += '<input type="text" spellingcheck="false" readonly="readonly" id="surl" class="share-url" value="'+url+'"/>';
				str += '</div></div></div></div></div>';
				$("#shareContext").html(str);
				var str1 = '';
				str1 += '<a class="g-button g-button-large" title="关闭" style="float: right; padding-left: 50px;"><span class="g-button-right" style="padding-right: 50px;"><span class="text" style="width: auto;" onclick="cancelShare()">关闭</span></span></a>'
				$("#shareSelect").html(str1);
			} else { // 分享失败
				console.log("分享出错");
			}
		},
		error: function() {
			alert("分享失败");
		}
	});
}

function copyurl() {
	var obj = document.getElementById('cc');
	var url = $("#surl").val();
	var clipboard = new ClipboardJS(obj, {
        text: function() {
            return url;
        }
    });
    clipboard.on('success', function(e) {//复制成功执行的回调，可选
        $("#copy-tips").css("display", "block");
        clipboard.destroy();
    });
    clipboard.on('error', function(e) {//复制失败执行的回调，可选
    	alert("复制失败了T_T");
    	if(clipboard) {
            clipboard.destroy();
        }
    });
}