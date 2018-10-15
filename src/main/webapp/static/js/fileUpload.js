 // form 内的文件选择内容被改变则立即提交
  $('#fileUpload').on('change', function()
  {
    // 当 file 框内容改变则提交 form
    $('#formUpload').submit();
    console.log('formUpload to submit');
  });
 
  // 定义的热点被单击则打开文件选择框
  $('#clickUpload').on('click', function()
  {
    UploadFileOnSelect();
    console.log('object on click');
  });
 
  // 选需要上载的文件 上载完毕清除 form
  function UploadFileOnSelect()
  {
    // 打开文件选择框
    console.log('select file');
    var input = document.getElementById("fileUpload");
    input.click();
    // 提交完毕后初始化 form
    $('#formUpload').resetForm();
    console.log('selected file ' + input.value);
  }
 
  // jquery.form upload
  $('#formUpload').ajaxForm({
    // 设置返回格式
    dataType : "json",
    url : "/file/uploadFile",
    success : function(data)
    {
    	alert("上传成功");
		var str="<tr data-file-id=\"1\" class=\"active\">";
		str+="<td><input type=\"checkbox\" class=\"checkstyle\" value="+data.fid+" onclick=\"allcheck(),display()\"/>";
		if(data.isdir){
			str+="<i class=\"fileIcon\"></i>";
		}else if(data.suffix == "jpg"){
			str+="<i class=\"imgIcon\"></i>";
		}else if(data.suffix == "txt"){
			str+="<i class=\"txtIcon\"></i>";
		}else if(data.suffix == "mp4"){
			str+="<i class=\"videoIcon\"></i>";
		}else if(data.suffix == "seed"){
			str+="<i class=\"seedIcon\"></i>";
		}else if(data.suffix == "mp3"){
			str+="<i class=\"musicIcon\"></i>";
		}else{
			str+="<i class=\"otherIcon\"></i>";
		}
		str+="<a onclick=\"fundFileByParentId(\'"+data.fid+"\',"+data.isdir+")\" href=\"javascript:void(0);\"><span class=\"fileTitle\">"+data.fname+"</span></a>";
		str+="<div class=\"filesFns right\">";
		str+="<a class=\"icon icon-share\" href=\"javascript:;\">分享</a>";
		str+="<a onclick=\"downFile(\'"+data.furl+"\',\'"+data.fname+"\',\'"+data.suffix+"\')\" class=\"icon icon-download\" href=\"javascript:;\">下载</a>";
		str+="<a class=\"icon icon-more\" href=\"javascript:;\">更多</a>";
		str+="</div></td><td><span>"
		if(data.fsize){
			str+=data.fsize+"</span></td>";
		}else{
			str+="——</span></td>";
		}
		str+="<td><span class=\"fileChangeDate\">"+dateFmt("yyyy-MM-dd",new Date(data.updatetime))+"</span></td></tr>";
		$("#filesTab").append(str);
    },
    uploadProgress : function(event, position, total, percentComplete)
    {
      // 实时进度
      console.log('uploadProgress: ', percentComplete + '%', position, 'max:', total);
    },
    error : function(data)
    {
      alert("上传失败");
      // 返回错误信息
      console.log('error: ' + data);
    }
  });