(function(w){
	/*
		问题：
			每次渲染完数据，元素的事件函数就要重新添加
	*/
	
	function otherEvent(id) {
		if (typeof id == 'string') {
			this.obj = document.getElementById(id);
		} else {
			this.obj = id;
		}
	}
	otherEvent.prototype.addEvent = function (Event,fn,ele) {
		var that = this;
		this.obj = ele || this.obj;
		this.obj.addEventListener(Event,function(){
			fn(that.obj);
		});
	}

	//页面初始化
	setBodyHei();//设置页面宽高
	//顶部头像 加鼠标移入移出
	headPic('headIn','headInfoCaption','headInShow');
	//排序按钮 加鼠标移入移出
	headPic('filesSortId','filesSortList','filesSortListShow',true);
	//循环  排列顺序的span列表,给span加鼠标移入移出事件
	circuleEv('filesSortId','#filesList .filesSortList span','active');
	
	
	
	//列表展示的样式，在showListStyle函数中设置
	var vlistStyle = 'list';
	//判断展示列表样式的按钮
	var oShowList = document.getElementById('showList');
	
	
	//首页全部文件初始化
	var dataRand = new DataRander('filesHead','filesTab');//需修改
	
	//调用文件列表展示样式函数
	showListStyle(oShowList);
	
	//文件列表展示样式按钮添加点击事件
	var showList = new otherEvent('showList');
	showList.addEvent('click',showListStyle);
	
	
	
	
	
	
	
	
	//展示列表样式的函数
	function showListStyle(obj){
		var arr = obj.className.split(' ');
		if ( tools.arrIndexOf('icon-list',arr) == -1 ) {
			//列表展示
			tools.rmClass(obj,'icon-grid');
			tools.addClass(obj,'icon-list');
			//改变列表展示的样式
			vlistStyle = 'list';
			
		} else { 
			//大图展示
			tools.rmClass(obj,'icon-list');
			tools.addClass(obj,'icon-grid');
			
			//改变列表展示的样式
			vlistStyle = 'grid';
		}
		dataRand.init(data.files,0,vlistStyle);//数据、加载进入的文件列表id
	}
	//循环排列顺序的span列表加,给span加鼠标移入移出事件
	function circuleEv(id,selector,className) {
		var spans = tools.$(selector);
		if(spans.length>1) {
			for ( var i=0; i<spans.length; i++ ) {
				var otherE = new otherEvent(id);
				otherE.addEvent('mouseover',function(obj){
					tools.addClass(obj,className);
				},spans[i]);
				otherE.addEvent('mouseout',function(obj){
					tools.rmClass(obj,className);
				},spans[i]);
				otherE.addEvent('click',function(obj){
					var prev = obj.parentNode.getElementsByClassName('show')[0];
					var i = obj.getElementsByTagName('i')[0];
					tools.rmClass(prev,'show');
					tools.addClass(i,'show');
				},spans[i]);
			}
		}
	}
	//顶部头像/排序按钮   加鼠标移入移出
	function headPic(id,className,addClass,beal) {
		beal = beal || false;
		var otherE = new otherEvent(id);
		otherE.addEvent('mouseover',function(obj){
			var list = obj.getElementsByClassName(className)[0];
			clearTimeout(list.timer);
			if ( beal ) {
				obj = list;
			}
			tools.addClass(obj,addClass);
		});
		otherE.addEvent('mouseout',function(obj){
			var list = obj.getElementsByClassName(className)[0];
			list.timer = setTimeout(function(){
				if ( beal ) {
					obj = list;
				}
				tools.rmClass(obj,addClass);
			},200)
		});
	}
	//设置页面宽高
	function setBodyHei() {
		var oWrap = document.getElementById('tBody');
		var oHeader = document.getElementById('header');
		var H = document.documentElement.clientHeight || document.body.clientHeight;
		var h = H - oHeader.offsetHeight < 500? 500: H - oHeader.offsetHeight;
		oWrap.style.height = h + 'px';	
	}
})(window)
