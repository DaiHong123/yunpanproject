package cn.qst.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理jsp页面请求
 * 
 * @author Administrator
 *
 */
@Controller
public class PageController {
	// 页面跳转
	@RequestMapping("/{page}")
	public String pageJsp(String page, Integer menuid, Map<String, Object> map) {
		map.put("menuid", menuid);
		return page;
	}
	/**
	 * 跳转到登陆界面，主页
	 * @return
	 */
	@RequestMapping("/")
	public String pageLogin() {
		return "login";
	}
}