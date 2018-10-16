<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频播放</title>
<link rel="stylesheet" href="../../static/css/yunDisk.css" />
<link rel="stylesheet" href="../../static/css/openfile.css" />
<script src="../../static/js/jquery-1.8.3.min.js"></script>
<link href="../../static/jplyer/jplayer.blue.monday.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../static/jplyer/jquery.min.js"></script>
<script type="text/javascript" src="../../static/jplyer/jquery.jplayer.min.js"></script>

</head>
<body>
	<header id="header" class="clear">
	<h1 class="headerLogo left">
		<a href="/yunDisk">百度网盘</a>
	</h1>
	<nav class="headNav left"> <a href="/yunDisk" class="active">网盘<i></i></a>
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

	<section id="bd"> <section id="bd-main" style="background-color:#eff4f8">
	<div>
		<div id="jp_container_1" class="jp-video jp-video-360p videoPlay"
			role="application" aria-label="media player">
			<div class="jp-type-single">
				<div id="jquery_jplayer_1" class="jp-jplayer"></div>
				<div class="jp-gui">
					<div class="jp-video-play">
						<button class="jp-video-play-icon" role="button" tabindex="0">play</button>
					</div>
					<div class="jp-interface">
						<div class="jp-progress">
							<div class="jp-seek-bar">
								<div class="jp-play-bar"></div>
							</div>
						</div>
						<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
						<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
						<div class="jp-controls-holder">
							<div class="jp-controls">
								<button class="jp-play" role="button" tabindex="0">play</button>
								<button class="jp-stop" role="button" tabindex="0">stop</button>
							</div>
							<div class="jp-volume-controls">
								<button class="jp-mute" role="button" tabindex="0">mute</button>
								<button class="jp-volume-max" role="button" tabindex="0">max
									volume</button>
								<div class="jp-volume-bar">
									<div class="jp-volume-bar-value"></div>
								</div>
							</div>
							<div class="jp-toggles">
								<button class="jp-repeat" role="button" tabindex="0">repeat</button>
								<button class="jp-full-screen" role="button" tabindex="0">full
									screen</button>
							</div>
						</div>
						<div class="jp-details">
							<div class="jp-title" aria-label="title">&nbsp;</div>
						</div>
					</div>
				</div>
				<div class="jp-no-solution">
					<span>Update Required</span> To play the media you will need to
					either update your browser to a recent version or update your <a
						href="http://get.adobe.com/flashplayer/" target="_blank">Flash
						plugin</a>.
				</div>
			</div>
		</div>
	</div>
	</section> </section>
	<div id="frameSelect"></div>
</body>


<script type="text/javascript">
//<![CDATA[
	var furl = '${furl}';
	var fname = '${fname}';
$(document).ready(function(){
	$("#jquery_jplayer_1").jPlayer({
		ready: function () {
			$(this).jPlayer("setMedia", {
				title: fname,
				mp4: furl,
				ogv: furl
			});
		},
		swfPath: "../../dist/jplayer",
		supplied: "webmv, ogv, m4v",
		size: {
			width: "640px",
			height: "360px",
			cssClass: "jp-video-360p"
		},
		useStateClassSkin: true,
		autoBlur: false,
		smoothPlayBar: true,
		keyEnabled: true,
		remainingDuration: true,
		toggleDuration: true
	});

});
//]]>
</script>

<script src="../../static/js/mYtools.js"></script>
<script src="../../static/js/myIndex.js"></script>
<script src="../../static/js/search.js"></script>
<script src="../../static/js/sharefile.js"></script>
<script src="../../static/js/file.js"></script>
<script src="../../static/js/openfile.js"></script>
</html>