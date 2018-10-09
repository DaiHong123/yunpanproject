<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
<link rel="stylesheet" href="../../static/css/yunDisk.css" />
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
					<span class="headImg"><img /></span>
					<span class="headName">天使120</span>
					<span class="headGradeIcon"><a href="javascript:;"></a></span>
					<i class="icon icon-dropdown-arrow"></i>
				</div>
				<div class="headInfoCaption">
					<mark></mark>
					<div class="top">
						<span class="headImg"><img /></span><span class="headName">天使120</span><span class="headGradeIcon"><a href="javascript:;"></a></span>
					</div>
					<div class="bottom">
						<div class="bottomHead">
							超级会员尊享特权：
							<a href="javascript:;">开通超级会员</a>
						</div>
						<div class="bottomPrivilege">
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
							<a href="javascript:;">开通超级会员</a>
						</div>
						<ul class="bottomDesc">
							<li><a href="javascript:;">个人资料</a></li>
							<li><a href="javascript:;">帮助中心</a></li>
							<li><a href="javascript:;">退出</a></li>
						</ul>
					</div>
				</div>
			</div>
			<i class="headRightLine"></i>
			<div class="headFn">
				<a href="javascript:;" class="headDownLoad">客户端下载</a>
				<p class="headFns">
					<a class="icon icon-notice" href="javascript:;"></a>
					<a class="icon icon-feedback" href="javascript:;"></a>
					<a class="icon icon-theme" href="javascript:;"></a>
				</p>
				<a href="javascript:;" class="headMember">会员中心</a>
			</div>
		</div>
		<a class="headBar right" href="javascript:;">超级会员 限时优惠</a>
	</header>
	<section class="wrap clear" id="tBody">
		<div class="contRight">
			<ul id="aside">
				<li class="asideAll active"><i class="icon icon-disk"></i><span>全部文件</span></li>
				<li class="asideImg"><span>图片</span></li>
				<li class="asideText"><span>文档</span></li>
				<li class="asidevideo"><span>视频</span></li>
				<li class="asideSeed"><span>种子</span></li>
				<li class="asideMusic"><span>音乐</span></li>
				<li class="asideOther"><span>其他</span></li>
				<li class="asideMyShare"><i class="icon icon-my-share"></i><span>我的分享</span></li>
				<li class="asideRecycle"><i class="icon icon-delete"></i><span>回收站</span></li>
			</ul>
			<footer class="contRightFoot">
				<div class="contRightCapacity">
					<div class="CapacityBar">
						<span></span>
					</div>
					<div class="contRightCapacityInfo">
						<p class="left"><span class="UsedAmount">75.78</span>G/<span class="allAmount">2055</span>G</p>
						<a class="right" href="javascript:;">扩容</a>
					</div>
				</div>
				<div class="contRightDownload">
					<a class="icon icon-yunguanjia" href="javascript:;" title="下载百度网盘PC版"></a>
					<a class="icon icon-android" href="javascript:;" title="下载百度网盘Android版"></a>
					<a class="icon icon-apple" href="javascript:;" title="下载百度网盘iPhone版"></a>
					<a class="icon icon-more" href="javascript:;"></a>
				</div>
			</footer>
		</div>
		<section id="filesList">
			<header class="filesListHeader">
				<div class="filesListHeadBtnsR left">
					<span class="filesUpLoad"><i class="icon icon-upload"></i>上传</span>
					<span class="filesCreate"><i class="icon icon-newfolder"></i>新建文件夹</span>
					<div class="filesListHeadChangBtn">
						<span class="headDownLoad"><i class="icon icon-download"></i>离线下载</span>
						<span class="headMyDevice"><i class="icon icon-device"></i>我的设备</span>
					</div>
					<div class="filesListHeadChangChose">
						<span class="headShare"><i class="icon icon-share"></i>分享</span>
						<span class="headDownLoad"><i class="icon icon-download"></i>下载</span>
						<span class="headDelete"><i class="icon icon-delete"></i>删除</span>
						<span class="headResetName">重命名</span>
						<span class="headCopy">复制到</span>
						<span class="headMyDevice"><i class="icon icon-more"></i>更多</span>
						
					</div>
				</div>
				<div class="filesListHeadBtnsL right">
					<form id="fileSearch">
						<input class="txt" type="text" />
						<a class="submit icon icon-search" href="javascript:;"></a>
					</form>
					<span class="filesSort icon icon-order" id="filesSortId">
						<span class="filesSortList">
							<span>
								<i class="show icon icon-sort-select"></i>
								文件名
							</span>
							<span>
								<i class="icon icon-sort-select"></i>
								大小
							</span>
							<span>
								<i class="icon icon-sort-select"></i>
								修改日期
							</span>
						</span>
					</span>
					<!--<span class="filesShowStyle icon icon-grid"></span>-->
					<span id="showList" class="filesShowStyle icon icon-grid"></span>
					
				</div>
			</header>
			<div class="filesPath" id="filesHead">
				<div class="filesListRoute left">
					<!--<a class="filesListReturn" href="javascript:;">返回上一级</a>
					<i>|</i>
					<a href="javascript:;">全部文件</a>
					<i>></i>
					<a href="javascript:;">妙味</a>
					<i>></i>
					<span>全部文件</span>-->
				</div>
				<div class="filesListCount right"><span>已加载100个</span></div>
			</div>
			<div class="filesBody">
				<div class="blankBg"></div>
				<div id="fileScrollBar">
					<span></span>
				</div>
				<ul id="tHead">
					<li>
						<em class="filesBtn"></em>
						<span>文件名</span>
						<i class="icon downtitle-icon icon-downtitle"></i>
					</li>
					<li>
						<span>大小</span>
					</li>
					<li>
						<span>修改日期</span>
					</li>
					<li id="checkAll"></li>
				</ul>
				
				<!--<dl>
					<dd>
						<em class="filesBtn filesChecked"></em>
						<i class="icon downtitle-icon icon-downtitle"></i>
						<span>文件名</span>
					</dd>
				</dl>-->
				<table class="files" >
					<!--<thead>
						<tr>
							<td width="60%">
								<em class="filesBtn filesChecked"></em>
								<span>文件名</span>
								<i class="icon downtitle-icon icon-downtitle"></i>
							</td>
							<td width="16%">
								<span>大小</span>
							</td>
							<td>
								<span>修改日期</span>
							</td>
						</tr>
					</thead>-->
					<tbody id="filesTab">
						<!--<tr class="active">
							<td width="60%">
								<em class="filesBtn"></em>
								<i class="fileIcon"></i>
								<span>照片</span>
								<div class="filesFns right">
									<a class="icon icon-share" href="javascript:;">分享</a>
									<a class="icon icon-download" href="javascript:;">下载</a>
									<a class="icon icon-more" href="javascript:;">更多</a>
								</div>
							</td>
							<td width="16%">
								<span>-</span>
							</td>
							<td>
								<span>2016-12-04 15:26</span>
							</td>
						</tr>
						<tr>
							<td>
								<em class="filesBtn"></em>
								<i class="fileIcon"></i>
								<span>我的文件夹</span>
								<div class="filesFns right">
									<a href="javascript:;">分享</a>
									<a href="javascript:;">下载</a>
									<a href="javascript:;">更多</a>
								</div>
							</td>
							<td>
								<span>2.1M</span>
							</td>
							<td>
								<span>2016-12-04 15:26</span>
							</td>
						</tr>-->
					</tbody>
					
				</table>
				<div id="moduleFlieName">
					<div>
						<input type="text" />
						<span>
							<i class="icon icon-border"></i>
							<i class="icon icon-checksmall"></i>
						</span>
						<span>
							<i class="icon icon-border"></i>
							<i class="icon icon-cancel"></i>
						</span>
					</div>
				</div>
			</div>
		</section>
	</section>
	<div id="frameSelect"></div>
</body>
<script src="../../static/js/data.js"></script>
<script src="../../static/js/mYtools.js"></script>
<script src="../../static/js/myHandData.js"></script>
<script src="../../static/js/myRander.js"></script>
<script src="../../static/js/myIndex.js"></script>
</html>
