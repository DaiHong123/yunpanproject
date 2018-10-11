function createFile() {
	this.obj = document.getElementById('filesTab');
	this.child = this.obj.children;
	var str = "<tr data-file-id='2' class='active' >";
	str += "<td>";
	str += "<input type='checkbox' class='checkstyle' value='2' onclick='allcheck(),display()' />";
	str += "<i class='fileIcon'></i>";
	str += "<span class='fileTitle' title='新建文件夹'>新建文件夹</span>";
	str += "<div class='filesFns right'>";
	str += "<a class='icon icon-share' href='javascript:;' title='分享'>分享</a>";
	str += "<a class='icon icon-download' href='javascript:;' title='下载'>下载</a>";
	str += "<a class='icon icon-more' href='javascript:;' title='更多'>更多</a>";
	str += "</div>";
	str += "</td>";
	str += "<td>";
	str += "<span></span>";
	str += "</td>";
	str += "<td>";
	str += "<span class='fileChangeDate'>"+getNowFormatDate()+"	</span>";
	str += "</tr>";
	this.obj.innerHTML = str + this.obj.innerHTML;
	var obj = {
		title: "新建文件夹"
	};

	rename(this.child[0], obj, function() { /*传入后台数据*/ }, function() {
		this.obj.removeChild(this.child[0]);
	});
}


//重命名
function rename(domObj, dataObj, success, fail) {
	var _this = this;
	var moduleName = document.getElementById('moduleFlieName');
	var topNum = domObj.offsetTop,
		leftNum = domObj.offsetLeft;
	//控制输入框的位置
	moduleName.style.display = 'block';
	moduleName.style.top = topNum + 37 + 'px';
	moduleName.style.left = leftNum + 'px';
	var oInput = moduleName.getElementsByTagName('input')[0];
	var aSpans = moduleName.getElementsByTagName('span');
	oInput.value = dataObj.title;
	//将输入框中的东西全选中
	oInput.select();
	aSpans[0].onclick = function() {
		var newName = oInput.value;
		dataObj.title = newName;
		var a = document.getElementsByClassName('fileTitle');
		//判断是否有重名现象
		var s = 0;
		var b = 0;
		var count = 0;
		for(var i = 0; i < a.length; i++) {
			if(a[i].innerHTML == "新建文件夹") {
				count++;
			}
		}
		while(true) {
			if(s == 0) {
				var name = newName;
			} else {
				var name = newName + "(" + s + ")";
			}
			for(var i = 0; i < a.length; i++) {
				if(name == a[i].innerHTML) {
					s++;
					break;
				}
				b = i;
			}
			if(b == a.length - 1) {
				break;
			}

		}
		if(newName == "新建文件夹") {
			if(count == 1) {
				getByClass('fileTitle', domObj)[0].innerHTML = newName;
				getByClass('fileTitle', domObj)[0].title = newName;
			} else {
				getByClass('fileTitle', domObj)[0].innerHTML = newName + '(' + s + ')';
				getByClass('fileTitle', domObj)[0].title = newName + '(' + s + ')';
			}
		} else {
			if(s == 0) {
				getByClass('fileTitle', domObj)[0].innerHTML = newName;
				getByClass('fileTitle', domObj)[0].title = newName;
			} else {
				getByClass('fileTitle', domObj)[0].innerHTML = newName + '(' + s + ')';
				getByClass('fileTitle', domObj)[0].title = newName + '(' + s + ')';
			}
		}
		success && success();
		moduleName.style.display = 'none';
	}
	aSpans[1].onclick = function() {
		fail && fail();
		moduleName.style.display = 'none';
	}
}

//获取当前的所有className
function getByClass(className, parent) {
	parent = parent ? parent : document;
	if(parent.getElementsByClassName) {
		return parent.getElementsByClassName(className);
	} else {
		var ele = parent.getElementsByTagName('*');
		var arr = [];
		for(var i = 0; i < ele.length; i++) {
			if(tools.hasClass(ele[i].className, className)) {
				arr.push(ele[i]);
			}
		}
		return arr;
	}
}

function addClass(obj, className) {
	obj.className = className;
}


//选择并重命名
function check() {
	var obj = {
		title: "1"
	};
	this.obj = document.getElementById('filesTab');
	this.child = this.obj.children;
	var ss = document.getElementsByClassName('checkstyle');
	var flag = -1;
	var count = 0;
	for(var i = 0; i < ss.length; i++) {
		if(ss[i].checked) {
			flag = i;
			count++;
		}
	}
	if(count==1){
		obj.title = document.getElementsByClassName('fileTitle')[flag].title;
		rename(this.child[flag],obj);
	}

}

function deletefile(){
	
}

//全选和全不选
function ckAll(){
        var flag=document.getElementById("allChecks").checked;
        var cks=document.getElementsByClassName('checkstyle');
        for(var i=0;i<cks.length;i++){
            cks[i].checked=flag;
        }
    }

//控制全选和部分选后的全选按钮的改变
function allcheck(){
	var cks=document.getElementsByClassName('checkstyle');
	var s = 0;
	 for(var i=0;i<cks.length;i++){
           if(cks[i].checked==true){
           		s++;
           }
        }
	 if(s==cks.length){
	 	
	 	document.getElementById('allChecks').checked = true;
	 }else {
		document.getElementById('allChecks').checked = false;
	 }
}


//展示和隐藏前端的下载和重命名等
function display(){
	var cks=document.getElementsByClassName('checkstyle');
	var dis=document.getElementById('filesListHeadChangChose');
	var rdis=document.getElementById('headResetName');
	var adis = document.getElementById('filesListHeadChangBtn');
	var s = 0;
	 for(var i=0;i<cks.length;i++){
          if(cks[i].checked==true){
          		s++;
          }
       }
	 if(s>=1){		
		 dis.style.display = "block";
		 adis.style.display='none'
		 if(s>=2){
			 rdis.style.cursor=' ';
			 rdis.style.color='#aaaacc';
		 }else {
			 rdis.style.cursor='pointer';
			 rdis.style.color='#3b8cff';
		 }
	 }else if(s==0){
		 dis.style.display = 'none';
		 adis.style.display='block'
	 }
}

//获取当前时间
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
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
