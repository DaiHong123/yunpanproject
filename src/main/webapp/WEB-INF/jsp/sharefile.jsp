<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看分享文件</title>
<link rel="stylesheet" href="../../static/css/yunDisk.css" />
<link rel="stylesheet" href="../../static/css/openfile.css" />
<script type="text/javascript" src="../../static/js/jquery-1.8.3.min.js"></script>

<script>
	var urlcode= '${shareInfo.sid}';
	console.log(urlcode);
</script>
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
							<c:choose>
								<c:when test="${shareInfo.uid==user.uid}">
									<a class="btn g-button">
										<span class="ico icon icon-share-cancel"></span>
										<span class="text" onclick="cancel('${shareInfo.sid}')">取消分享</span>
									</a>
								</c:when>
								<c:otherwise>
									<a class="btn g-button g-button-blue" onclick="login('${user.uid}'),breviary(),isCopyOrMove('复制到')">
										<em class="icon icon-save-disk" title="保存到网盘"></em>
										<span class="text" onclick="javascript:;">保存到网盘</span>
									</a>
								</c:otherwise>
							</c:choose>
							<a class="btn g-button" onclick="downFiles()">
								<em class="icon icon-download" title="下载"></em>
								下载
							</a>
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
					<section>
						<header class="filesListHeader">
							<div id="filesListHeadChangBtn" style="display:none;"></div>
							<div class="filesListHeadBtnsR left">
								<div class="filesListHeadChangChose" id="filesListHeadChangChose">
									<c:if test="${shareInfo.uid!=user.uid}">
										<span class="headDownLoad" onclick="login('${user.uid}'),breviary(),isCopyOrMove('复制到')">
											<i class="icon icon-save-disk"></i>保存到网盘
										</span>
									</c:if>
									<span class="headDownLoad">
										<i class="icon icon-download"></i>下载
									</span>
								</div>
							</div>
						</header>
						<div class="filesPath" id="filesHead">
							<div class="filesListRoute left">
								<span>全部文件</span>
							</div>
							<div class="filesListCount right">
								<c:choose>
									<c:when test="${files==null}">
										<span>已加载0个</span>
									</c:when>
									<c:otherwise>
										<span>已加载${files.size()}个</span>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="filesBody">
							<div class="blankBg"></div>
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
									<c:forEach var="file" items="${files}" varStatus="ind">
										<tr data-file-id="1" class="active">
											<td>
												<input type="checkbox" class="checkstyle" value="1cd1c192acd74b53862759e03fb9cccd" onclick="allcheck(),display()">
												<c:choose>
													<c:when test="${file.isdir}">
														<i class="fileIcon"></i>
													</c:when>
													<c:when test="${file.suffix==\"jpg\"}">
														<input id = "${file.fid}" value = "${file.furl}" style="display:none "/>
														<i id="btn" onMouseOver="showInform(event,'${file.fname}')" onMouseOut="hiddenInform(event)" class="imgIcon"></i>
													</c:when>
													<c:when test="${file.suffix == \"txt\"}">
														<i class="txtIcon"></i>
													</c:when>
													<c:when test="${file.suffix == \"mp4\"}">
														<i class="videoIcon"></i>
													</c:when>													
													<c:when test="${file.suffix == \"seed\"}">
														<i class="seedIcon"></i>
													</c:when>													
													<c:when test="${file.suffix == \"mp3\"}">
														<i class="musicIcon"></i>
													</c:when>
													<c:otherwise>
														<i class="otherIcon"></i>
													</c:otherwise>
												</c:choose>
												<a onclick="fundFileByParentId('${file.fid}', ${file.isdir})" href="javascript:void(0);">
													<span class="fileTitle" title="${file.fname}">${file.fname}</span>
												</a>
												<div class="filesFns right">
													<a onclick="downFile('${file.parentid}','${file.fname}','null')" class="icon icon-download" href="javascript:;">下载</a>
												</div>
											</td>
											<td>
												<c:choose>
													<c:when test="${file.fsize==null}">
														<span>——</span>
													</c:when>
													<c:otherwise>
														<span>${file.fsize}</span>
													</c:otherwise>
												</c:choose>
											</td>
											<td><span class="fileChangeDate"><f:formatDate value="${file.updatetime}" pattern="yyyy-MM-dd"/></span></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</section>
					<div class="module-canvas" id="module-canvas"
							style="position: fixed; left: 0px; top: 0px; z-index: 50; background: rgb(0, 0, 0) none repeat scroll 0% 0%; opacity: 0.5; width: 100%; height: 100%; display: none;"></div>
						<div class="dialog dialog-fileTreeDialog dialog-gray"
							id="fileTreeDialog"
							style="width: 520px; top: 195px; bottom: auto; left: 400px; right: auto; display: none; visibility: visible; z-index: 53;"
							onmousedown="moveLocation(this)">
						<div class="dialog-header dialog-drag">
							<h3 id="aa">
								<span class="dialog-header-title"><em class="select-text"></em></span>
							</h3>
							<div class="dialog-control">
								<span class="dialog-icon dialog-close ">
									<span class="sicon" onclick="cancel()">x</span>
								</span>
							</div>
						</div>
						<div id="treeView" style="max-height: 300px; overflow: auto;"></div>
						<div class="dialog-footer g-clearfix">
							<a class="g-button g-button-large" data-button-id="b77"
									data-button-index="" href="javascript:;" title="取消"
									style="float: right; padding-left: 50px;">
								<span class="g-button-right" style="padding-right: 50px;">
									<span class="text" style="width: auto;" onclick="cancel()">取消</span>
								</span>
							</a>
							<a class="g-button g-button-blue-large" data-button-id="b81"
									data-button-index="" href="javascript:;" title="确定"
									style="float: left; padding-left: 50px;" onclick="sure()">
								<span class="g-button-right" style="padding-right: 50px;">
									<span class="text" style="width: auto;">确定</span>
								</span>
							</a>
						</div>
					</div>
				</div>
			</c:if>
		</section>
	</section>
	<div id="frameSelect"></div>
</body>
<script src="../../static/js/mYtools.js"></script>
<script src="../../static/js/myIndex.js"></script>
<script src="../../static/js/search.js"></script>
<script src="../../static/js/sharefile.js"></script>
<script src="../../static/js/breviary.js"></script>
<script src="../../static/js/file.js"></script>
<script src="../../static/js/openfile.js"></script>
<script src="../../static/js/yunDisk.js"></script>
</html>