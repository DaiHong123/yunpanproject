
var dataFile;


$(function(window, undefined) {
	
	
	
	 $.ajax({
			url : "/file/copyFile",
			type : "get",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			success : function(data) {
				dataFile=data;
				
			}
		});	
	
	
	
	
	
	
	
	
	
	
	
	
	var treeView = tools1.$('#treeView');
	var fileData = dataFile.files;
	treeView.innerHTML = treeHtml(fileData, -2);
	var fileItem = tools1.$('.treeNode');
	var root_icon = tools1.$('.icon-control', fileItem[0])[0];
	root_icon.className = 'icon1 icon-control icon-minus';
	tools1.each(fileItem, function(item) {
		filesHandle(item);
	});

	function treeHtml(fileData, fileId) {
		var _html = '';
		var children = getChildById(fileData, fileId);
		var hideChild = fileId !=-2 ? 'none' : '';
		_html += '<ul class="' + hideChild + '">';
		children.forEach(function(item, index) {
			var level = getLevelById(fileData, item.id);
			var distance = (level - 1) * 20 + 'px';
			var hasChild = hasChilds(fileData, item.id);
			var className = hasChild ? '' : 'treeNode-empty';
			var treeRoot_cls = fileId === -2 ? 'treeNode-cur' : '';
			_html += `
        <li>
          <div class="treeNode ${className} ${treeRoot_cls}" style="padding-left: ${distance}" data-file-id="${item.id}" onclick='get(this)'>
            <i class="icon1 icon-control icon-add"></i>
            <i class="icon1 icon-file"></i>
            <span class="title">${item.title}</span>
          </div>
          ${treeHtml(fileData,item.id)}
        </li>`;
		});
		_html += '</ul>';
		return _html;
	};

	function filesHandle(item) {
		tools1.addEvent(item, 'click', function() {
			var treeNode_cur = tools1.$('.treeNode-cur')[0];
			var fileId = item.dataset.fileId;
			var curElem = document.querySelector('.treeNode[data-file-id="' + fileId + '"]');
			var hasChild = hasChilds(fileData, fileId);
			var icon_control = tools1.$('.icon-control', item)[0];
			var openStatus = true;
			tools1.removeClass(treeNode_cur, 'treeNode-cur');
			tools1.addClass(curElem, 'treeNode-cur');
			if(hasChild) {
				openStatus = tools1.toggleClass(item.nextElementSibling, 'none');
				if(openStatus) {
					icon_control.className = 'icon1 icon-control icon-add';
				} else {
					icon_control.className = 'icon1 icon-control icon-minus';
				}
			}
		});
	};
})(window);