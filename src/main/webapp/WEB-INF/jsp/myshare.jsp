<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的分享</title>
<link rel="stylesheet" href="../../static/css/yunDisk.css" />
<script src="../../static/js/jquery-1.8.3.min.js"></script>
<style>
	a:visited {
		color:#424e67;
	}
</style>
</head>
<body>
		<header id="header" class="clear">
		<h1 class="headerLogo left"><a href="javascript:;">百度网盘</a></h1>
		<nav class="headNav left">
			<a href="javascript:;" class="active">网盘<i></i></a>
			<a href="#">分享<i></i></a>
			<a href="#">更多<i></i></a>
		</nav>
		<div class="headRight right">
			<div id="headIn">
				<div class="headInfo">
					<span class="headImg"><img src="${imgstr}"/></span>
					<span class="headName">${user.uname}</span>
					<span class="headGradeIcon"><a href="javascript:;"></a></span>
					<i class="icon icon-dropdown-arrow"></i>
				</div>
				<div class="headInfoCaption">
					<mark></mark>
					<div class="top">
						<span class="headImg"><img src="${imgstr}" /></span><span class="headName">${user.uname}</span><span class="headGradeIcon"><a href="javascript:;"></a></span>
					</div>
					<div class="bottom">
						<div class="bottomHead">
							超级会员尊享特权：
						</div>
						<div class="bottomPrivilege">
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
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
			<li class="asideMyShare">
				<a href="/myshare" target="_self">
					<i class="icon icon-my-share"></i>
					<span>我的分享</span>
				</a>
			</li>
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
	<section id="filesList">
		<div style="padding-top: 15px;"></div>
		<div class="filesPath" id="filesHead">
			<div class="filesListRoute left">
				<span>链接分享</span>
			</div>
		</div>
	<div class="filesBody">
		<div class="blankBg"></div>
		<div id="fileScrollBar">
			<span></span>
		</div>
		<ul id="tHead">
			<li style="width: 50%;margin-left: 17px;"><span>分享文件</span></li>
			<li><span>分享日期</span></li>
			<li><span>链接地址</span></li>
			<li><span>操作</span></li>
		</ul>
		<table class="files">
			<tbody id="filesTab">
				<c:if test="${shares==null}">
					暂无分享内容
				</c:if>
				<c:if test="${shares!=null}">
					<c:forEach items="shares" var="share" varStatus="ind">
						<tr>
							<td>${share.sname}</td>
							<td><f:formatDate value="${share.sharetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>地址</td>
							<td>操作</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	</section> </section>
</body>
<script src="../../static/js/mYtools.js"></script>
<script src="../../static/js/myIndex.js"></script>
<script src="../../static/js/search.js"></script>
<script src="../../static/js/yunDisk.js"></script>
<script src="../../static/js/file.js"></script>
<script src="../../static/js/share.js"></script>
</html>
