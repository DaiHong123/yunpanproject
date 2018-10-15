<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../../static/css/yunDisk.css" />
<link rel="stylesheet" href="../../static/css/openfile.css" />
<script src="../../static/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<header id="header" class="clear">
		<h1 class="headerLogo left"><a href="/yunDisk">百度网盘</a></h1>
		<nav class="headNav left">
			<a href="/yunDisk" class="active">网盘<i></i></a>
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

	<section id="bd">
		<section id="bd-main">
			<c:if test="${shareInfo==null}">
				<div id="share_nofound_des">
					<div class="error-img">
						<img src="/static/img/errorImg.png">
					</div>
					啊哦，你来晚了，分享的文件已经被取消了，下次要早点哟。
				</div>
			</c:if>
			<c:if test="${shareInfo!=null}">
				<div class="module-share-header">
					<div class="slide-show-header">
						<div class="slide-show-left">
							<h2 class="file-name" title="${shareInfo.sname}">${shareInfo.sname}</h2>
						</div>
						<div class="slide-show-right">
							<c:if test="${shareInfo.uid==user.uid}">
								<a class="btn g-button">
									<span class="text" onclick="cancel('${shareInfo.sid}')">取消分享</span>
								</a>
							</c:if>
							<a class="btn g-button">下载</a>
						</div>
						<div class="cb"></div>
						<div class="slide-show-other-infos">
							<div class="share-file-info">
								<span><f:formatDate value="${shareInfo.sharetime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
							</div>
							<div class="cb"></div>
						</div>
					</div>
				</div>
				
				<div class="share-list" id="shareqr">
					
				</div>
			</c:if>
		</section>
	</section>
	<div id="frameSelect"></div>
</body>
<script src="../../static/js/mYtools.js"></script>
<script src="../../static/js/myIndex.js"></script>
<script src="../../static/js/search.js"></script>
<script src="../../static/js/yunDisk.js"></script>
<script src="../../static/js/file.js"></script>
<script src="../../static/js/openfile.js"></script>
</html>