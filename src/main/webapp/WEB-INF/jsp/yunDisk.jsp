<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../../static/css/yunDisk.css" />

<script type="text/javascript" src="../../static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../../static/js/jquery.form.js"></script>
<link rel="stylesheet" href="../../static/css/breviary.css" />
<link href="../../static/css/index_1.css" rel="stylesheet" />

<script src="../../static/js/jquery-1.8.3.min.js"></script>
<style>
a:visited {
	color: #424e67;
}
</style>

</head>
<body>
	<header id="header" class="clear">
	<h1 class="headerLogo left">
		<a href="javascript:;">百度网盘</a>
	</h1>
	<nav class="headNav left"> <a href="javascript:;" class="active">网盘<i></i></a>
	<a href="#">分享<i></i></a> <a href="#">更多<i></i></a> </nav>
	<div class="headRight right">
		<div id="headIn">
			<div class="headInfo">
				<span class="headImg"><img src="${imgstr}" /></span> <span
					class="headName">${user.uname}</span> <span class="headGradeIcon"><a
					href="javascript:;"></a></span> <i class="icon icon-dropdown-arrow"></i>
			</div>
			<div class="headInfoCaption">
				<mark></mark>
				<div class="top">
					<span class="headImg"><img src="${imgstr}" /></span><span
						class="headName">${user.uname}</span><span class="headGradeIcon"><a
						href="javascript:;"></a></span>
				</div>
				<div class="bottom">
					<div class="bottomHead">超级会员尊享特权：</div>
					<div class="bottomPrivilege">
						<a href="javascript:;">开通超级会员</a> <a href="javascript:;">开通超级会员</a>
						<a href="javascript:;">开通超级会员</a> <a href="javascript:;">开通超级会员</a>
						<a href="javascript:;">开通超级会员</a>
					</div>
					<ul class="bottomDesc">
						<li><a href="/personal">个人资料</a></li>
						<li><a href="javascript:;">帮助中心</a></li>
						<li><a href="/User/exit">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</header>
	<section class="wrap clear" id="tBody">
	<div class="contRight">
		<ul id="aside">
			<a onclick="asideAll()" href="javascript:void(0);">
				<li id="asideAll" class="asideAll active"><i
					class="icon icon-disk"></i><span>全部文件</span></li>
			</a>
			<a onclick="asideImg()" href="javascript:void(0);">
				<li id="asideImg" class="asideImg"><span>图片</span></li>
			</a>
			<a onclick="asideText()" href="javascript:void(0);">
				<li id="asideText" class="asideText"><span>文档</span></li>
			</a>
			<a onclick="asidevideo()" href="javascript:void(0);">
				<li id="asidevideo" class="asidevideo"><span>视频</span></li>
			</a>
			<a onclick="asideSeed()" href="javascript:void(0);">
				<li id="asideSeed" class="asideSeed"><span>种子</span></li>
			</a>
			<a onclick="asideMusic()" href="javascript:void(0);">
				<li id="asideMusic" class="asideMusic"><span>音乐</span></li>
			</a>
			<a onclick="asideOther()" href="javascript:void(0);">
				<li id="asideOther" class="asideOther"><span>其他</span></li>
			</a>
			<li class="asideMyShare"><a href="/myshare" target="_self">
					<i class="icon icon-my-share"></i> <span>我的分享</span>
			</a></li>
			<li class="asideRecycle"><i class="icon icon-delete"></i><span>回收站</span></li>
		</ul>
		<footer class="contRightFoot">
		<div class="contRightCapacity">
			<div class="CapacityBar">
				<span></span>
			</div>
			<div class="contRightCapacityInfo">
				<p class="left">
					<span class="UsedAmount">75.78</span>G/<span class="allAmount">2055</span>G
				</p>
				<a class="right" href="javascript:;">扩容</a>
			</div>
		</div>
		<div class="contRightDownload">
			<a class="icon icon-yunguanjia" href="javascript:;" title="下载百度网盘PC版"></a>
			<a class="icon icon-android" href="javascript:;"
				title="下载百度网盘Android版"></a> <a class="icon icon-apple"
				href="javascript:;" title="下载百度网盘iPhone版"></a> <a
				class="icon icon-more" href="javascript:;"></a>
		</div>
		</footer>
	</div>
	<section id="filesList"> <header class="filesListHeader">
	<div class="filesListHeadBtnsR left">
		<div class="filesListHeadChangBtn" id="filesListHeadChangBtn">
			<span class="filesUpLoad"><i class="icon icon-upload"></i>上传</span> <span
				class="filesCreate" onclick="createFile()"><i
				class="icon icon-newfolder"></i>新建文件夹</span>
		</div>
		<div class="filesListHeadChangChose" id="filesListHeadChangChose">
			<span class="headShare"><i class="icon icon-share"></i>分享</span> <span
				class="headDownLoad"><i class="icon icon-download"></i>下载</span> <span
				class="headDelete" onclick="deletefile()"><i
				class="icon icon-delete"></i>删除</span> <span class="headResetName"
				id="headResetName" onclick="check()">重命名</span> <span
				class="headCopy" onclick="breviary(),isCopyOrMove('复制到')">复制到</span>
			<span class="headCopy" onclick="breviary(),isCopyOrMove('移动到')">移动到</span>

		</div>
	</div>
	<div class="filesListHeadBtnsL right">
		<form id="fileSearch">
			<input class="txt" type="text" /> <a class="submit icon icon-search"
				href="javascript:;"></a>
		</form>
		<span class="filesSort icon icon-order" id="filesSortId"> <span
			class="filesSortList"> <span> <i
					class="show icon icon-sort-select"></i> 文件名
			</span> <span> <i class="icon icon-sort-select"></i> 大小
			</span> <span> <i class="icon icon-sort-select"></i> 修改日期
			</span>
		</span>
		</span>
		<!--<span class="filesShowStyle icon icon-grid"></span>-->
		<span id="showList" class="filesShowStyle icon icon-grid"></span>
	</div>
	</header>
	<div class="filesPath" id="filesHead">
		<div class="filesListRoute left">
			<span>全部文件</span>
		</div>
		<div class="filesListCount right"></div>
	</div>
	<div class="filesBody">
		<div class="blankBg"></div>
		<div id="fileScrollBar">
			<span></span>
		</div>
		<ul id="tHead">
			<li><input type="checkbox" id="allChecks"
				onclick="ckAll(),display()" /> 全选/全不选</span> <i
				class="icon downtitle-icon icon-downtitle"></i></li>
			<li><span>大小</span></li>
			<li><span>修改日期</span></li>
			<li id="checkAll"></li>
		</ul>
		<table class="files">
			<tbody id="filesTab">

			</tbody>
		</table>
		<div id="moduleFlieName">
			<div>
				<input type="text" /> <span> <i class="icon icon-border"></i>
					<i class="icon icon-checksmall"></i>
				</span> <span> <i class="icon icon-border"></i> <i
					class="icon icon-cancel"></i>
				</span>
			</div>
		</div>
	</div>
	</section> </section>
	<div id="frameSelect"></div>
	<div id="inform">
		<img id="thum_Img" src="../../static/thum_img/blankBg.png"/>
	</div>
	<div class="module-canvas" id="big_thum" align="center" onclick="noShowImg()"
		style="position: fixed; left: 0px; top: 0px; z-index: 50; background: rgb(0, 0, 0) none repeat scroll 0% 0%; opacity: 0.5; width: 100%; height: 100%; display: none;">
	</div>
	<div id = "div_img" onclick="noShowImg()"
	 style="display: none;position:absolute; width: 520px; top: 150px; bottom: auto; left: 350px; right: auto; visibility: visible; z-index: 53;">
		<img class="big_img" alt="点击返回"
			id="big_thum_img" src="../../static/img/blankBg.png"/>
	</div>
	
	<div class="module-canvas" id="module-canvas"
		style="position: fixed; left: 0px; top: 0px; z-index: 50; background: rgb(0, 0, 0) none repeat scroll 0% 0%; opacity: 0.5; width: 100%; height: 100%; display: none;"></div>
	<div class="dialog dialog-fileTreeDialog dialog-gray"
		id="fileTreeDialog"
		style="width: 520px; top: 195px; bottom: auto; left: 400px; right: auto; display: none; visibility: visible; z-index: 53;">
		<div class="dialog-header dialog-drag">
			<h3 id="aa">
				<span class="dialog-header-title"><em class="select-text"></em></span>
			</h3>
			<div class="dialog-control">
				<span class="dialog-icon dialog-close "><span class="sicon"
					onclick="cancel()">x</span></span>
			</div>
		</div>
		<div id="treeView"></div>
		<div class="dialog-footer g-clearfix">
			<a class="g-button g-button-large" data-button-id="b77"
				data-button-index="" href="javascript:;" title="取消"
				style="float: right; padding-left: 50px;"><span
				class="g-button-right" style="padding-right: 50px;"><span
					class="text" style="width: auto;" onclick="cancel()">取消</span></span> </a> <a
				class="g-button g-button-blue-large" data-button-id="b81"
				data-button-index="" href="javascript:;" title="确定"
				style="float: left; padding-left: 50px;" onclick="sure()"><span
				class="g-button-right" style="padding-right: 50px;"><span
					class="text" style="width: auto;">确定</span></span> </a>
		</div>
	</div>


</body>
<script src="../../static/js/mYtools.js"></script>
<script src="../../static/js/myIndex.js"></script>
<script src="../../static/js/search.js"></script>
<script src="../../static/js/yunDisk.js"></script>
<script src="../../static/js/file.js"></script>

<script src="../../static/js/fileUpload.js"></script>
<script src="../../static/js/breviary.js"></script>
<script src="../../static/js/data.js"></script>
<script src="../../static/js/tools.js"></script>
<script src="../../static/js/handledata.js"></script>
</html>
