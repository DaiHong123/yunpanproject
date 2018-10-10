//获取手机号码，并动态写入页面
function getPhone() {
	var phone = document.getElementById("phone").value;
	if (phone != null && phone != '') {
		var str = "";
		str += "<em>手机号：</em><i>" + phone + "</i>";
		str += "<a href=\"#fst2\" style=\"text-decoration: none;\">立即修改</a>";
		str += "<input type=\"text\" name=\"phone\" value=\" " + phone
				+ "\" style=\"display:none\">";
		$("#userPhone").html(str);
	}
}

// 获取邮箱地址，并动态写入页面
function getEmail() {
	var email = document.getElementById("email").value;
	if (email != null && email != '') {
		var str = "";
		str += "<em>邮箱：</em><i> " + email + " </i>";
		str += "<a href=\"#fst1\" style=\"text-decoration: none;\">立即修改</a>";
		str += "<input type=\"text\" name=\"email\" value=\" " + email
				+ "\" style=\"display:none\">";
		$("#userEmail").html(str);
	}
}

function sumb() {
	$("#form1").submit();
}
function PasswordRewrite() {
	var pass1 = document.getElementById("password2").value;
	var pass2 = document.getElementById("password3").value;
	if (pass1.length < 6) {
		alert("密码长度应不小于6位");
	} else if (pass1 != pass2) {
		alert("新密码和确认密码不一致");
	} else {
		$.ajax({
			url : "PasswordServlet2.do", // (默认: 当前页地址) 发送请求的地址
			type : "post", // (默认: "get") 请求方式 ("post" 或 "get")， 默认为
			// "get"。注意：其它 http请求方法，如 put和
			// delete也可以使用，但仅部分浏览器支持。
			async : true,// (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为
			// false。注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
			contentType : "application/x-www-form-urlencoded",// (默认:
			// "application/x-www-form-urlencoded")
			// 发送信息至服务器时内容编码类型。默认值适合大多数应用场合。
			data : {
				password : $("#password").val(),
				password2 : $("#password2").val(),
			},
			dataType : 'json',
			success : function(json, textStatus) {// 如果调用servlet成功，响应200。请求成功后回调函数。这个方法有两个参数：服务器返回数据，返回状态(可以缺省)。
				console.log(textStatus);
				var flag = json.flag;
				if (flag == 'true') {
					location.href = "login.jsp";
				} else if (flag == 'false') {
					alert("修改失败，请检查后重试！");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {// 如果调用servlet出现问题，响应非200（这里响应405）。通常情况下textStatus和errorThown只有其中一个有值
				// 。(默认:
				// 自动判断
				// (xml
				// 或
				// html))
				// 请求失败时将调用此方法。这个方法有三个参数：XMLHttpRequest
				// 对象，错误信息，（可能）捕获的错误对象。
				console.log(textStatus);
				alert("连接失败");
			}
		});
	}
}
$(function() {
	/* top */

	$(".zcdl a").mouseenter(function() {
		$(this).css({
			color : "#ff7800"
		})
	}).mouseleave(function() {
		$(this).css({
			color : "#fefefe"
		})
	})

	$("#wxgzh").mouseenter(function() {
		$(".wxgzh").css({
			display : "block"
		})
	}).mouseleave(function() {
		$(".wxgzh").css({
			display : "none"
		})
	})
	$("#sjapp").mouseenter(function() {
		$(".sjapp").css({
			display : "block"
		})
	}).mouseleave(function() {
		$(".sjapp").css({
			display : "none"
		})
	})

	/* 导航加搜索框 */

	$(".sjhcp").mouseenter(function() {
		$(".little_list").css({
			display : "block"
		})
	}).mouseleave(function() {
		$(".little_list").css({
			display : "none"
		})
	})
	$(".little_list em").mouseenter(function() {
		$(this).css({
			color : "#fff",
			background : "#ff7800"
		}).siblings().css({
			color : "#2f2f2f",
			background : "none"
		})
	}).mouseleave(function() {
		$(this).css({
			color : "#2f2f2f",
			background : "none"
		})
	})
	$(".little_list em").click(function() {
		$(".little_list").css({
			display : "none"
		})
	})

	$(".ssl").mouseenter(function() {
		$(this).css({
			background : "#cd0010"
		})
	}).mouseleave().css({
		background : "#e50012"
	})

	$(".hot_ss a").mouseenter(function() {
		$(this).css({
			color : "#e50012"
		}).siblings().css({
			color : "#9d9d9d"
		})
	}).mouseleave(function() {
		$(this).css({
			color : "#9d9d9d"
		})
	})
	$(".dao_list a").click(function() {
		$(this).addClass("color").siblings().removeClass("color")
	});
	/* 控制显示或消失1 */
	$(".cates").mouseenter(function() {
		var cat = $(this).attr("mt-ct");
		$(".b-" + cat + "").show().siblings().hide();
	})
	$(".important").mouseleave(function() {
		$(".import_list").hide()
	})
	/* 侧边栏每块划上的时候添加颜色块 */
	$("aside ul li").mouseenter(function() {
		$(this).addClass("yanses").siblings().removeClass("yanses")
	})

	/* 模拟下拉菜单js时 */
	$(".time_list").mouseleave(function() {
		$(this).css({
			display : "none"
		})
	})
	$(".qjwxlk").on("mouseenter", function(e) {
		if ($(".time_list").is(":hidden")) {
			$(".time_list").show();
		} else {
			$(".time_list").hide();
		}
		$(".time_list em").click(function() {
			var txt = $(this).text();
			$(".qjwxlk").text(txt);
			$(".time_list").hide();
		})
		$(document).one("click", function() {
			$(".time_list").hide();
		});
		e.stopPropagation();
	});
	$(".time_list").on("click", function(e) {
		e.stopPropagation();
	});
	/* 模拟下拉菜单js时 */
	$(".time_lists").mouseleave(function() {
		$(this).css({
			display : "none"
		})
	})
	$(".qjwxlks").on("mouseenter", function(e) {
		if ($(".time_lists").is(":hidden")) {
			$(".time_lists").show();
		} else {
			$(".time_lists").hide();
		}
		$(".time_lists em").click(function() {
			var txt = $(this).text();
			$(".qjwxlks").text(txt);
			$(".time_lists").hide();
		})
		$(document).one("click", function() {
			$(".time_lists").hide();
		});
		e.stopPropagation();
	});
	$(".time_lists").on("click", function(e) {
		e.stopPropagation();
	});
	/* 餐位预订下面 */
	$(".two_nxs ul li").click(function() {
		$(this).addClass("senmai").siblings().removeClass("senmai")
	})
	$("#datingq").click(function() {
		$(".da_tingf").css({
			display : "block"
		}).siblings().css({
			display : "none"
		})
	})
	$("#baojianq").click(function() {
		$(".bao_jianf").css({
			display : "block"
		}).siblings().css({
			display : "none"
		})
	})
	/* 预定的时候对号的切换 */
	$(".da_tingf ul li").click(function() {
		$(".da_tingf ul li img").css({
			marginTop : "0"
		})
		$(this).find("b img").css({
			marginTop : "-28px"
		})
	})
	$(".bao_jianf ul li").click(function() {
		$(".bao_jianf ul li img").css({
			marginTop : "0"
		})
		$(this).find("b img").css({
			marginTop : "-28px"
		})
	})
	$(".two_nxs b").click(function() {
		$(".da_tingf ul li img,.bao_jianf ul li img").css({
			marginTop : "0"
		})
	})
	/* 菜品预定的导航块分别添加颜色 */
	$(".wanyf_lt ul li").click(function() {
		$(this).addClass("wsczz").siblings().removeClass("wsczz")
	})
	/* 菜品导航对应的各个块的显示或消失 */
	$(".wanyf_lt ul li").click(function() {
		var dogs = $(this).attr("dg-floor")
		var dog = $(this).attr("dg-ct");
		$(".f-" + dogs + "-" + dog + "").slideDown().siblings().slideUp();
	})
	/* 这个是每一个菜品的增加或者减少 */
	// 初始化数量为1,并失效减
	$('.min').attr('disabled', false);/* disabled为true的时候为按钮失效 */
	$(".min").css({
		display : "none"
	});
	$(".text_box").css({
		display : "none"
	})
	// 数量增加操作
	$(".add").click(
			function() {
				$(this).siblings(".min").css({
					display : "block"
				})
				$(this).siblings(".text_box").css({
					display : "block"
				})
				$(this).siblings(".text_box").val(
						parseInt($(this).siblings(".text_box").val()) + 1)
				if (parseInt($(this).siblings(".text_box").val()) != 1) {
					$(this).siblings(".min").attr('disabled', false);
				}
			})
	// 数量减少操作
	$(".min").click(
			function() {
				$(this).siblings(".text_box").val(
						parseInt($(this).siblings(".text_box").val()) - 1)
				if ($(this).siblings(".text_box").val() == 0) {
					$(this).attr('disabled', false)
					$(this).css({
						display : "none"
					})
					$(this).siblings(".text_box").css({
						display : "none"
					})
				}
			})
	/* 点击我的菜单里面的按钮时，这个对应的div消失 */
	$(".close_one").click(function() {
		$(this).parent().css({
			display : "none"
		})
	})
	// //////////////////////////////////////

	$(".mins").attr('disabled', false);/* disabled为true的时候为按钮失效 */
	// 数量增加操作
	$(".adds").click(
			function() {
				$(this).siblings(".text_boxs").val(
						parseInt($(this).siblings(".text_boxs").val()) + 1)
				if (parseInt($(this).siblings(".text_boxs").val()) != 1) {
					$(this).siblings(".mins").attr('disabled', false);
				}
			})
	// 数量减少操作
	$(".mins").click(
			function() {
				$(this).siblings(".text_boxs").val(
						parseInt($(this).siblings(".text_boxs").val()) - 1)
				if ($(this).siblings(".text_boxs").val() == 0) {
					$(this).siblings(".text_boxs").val(1);
				}
			})
	/* 选择各种支付方式 */
	$("#zfbzf").click(function() {
		$(this).css({
			backgroundPosition : "0 -50px"
		}).siblings().css({
			backgroundPosition : "0 0"
		})
		$(".zhyezfmm span").css({
			display : "none"
		})
	})
	$("#wxzf").click(function() {
		$(this).css({
			backgroundPosition : "0 -50px"
		}).siblings().css({
			backgroundPosition : "0 0"
		})
		$(".zhyezfmm span").css({
			display : "none"
		})
	})
	$("#yezf").click(function() {
		$(this).css({
			backgroundPosition : "0 -50px"
		}).siblings().css({
			backgroundPosition : "0 0"
		})
		$(".zhyezfmm span").css({
			display : "block"
		})
	})

})
