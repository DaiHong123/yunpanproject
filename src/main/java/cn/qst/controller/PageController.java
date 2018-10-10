package cn.qst.controller;
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

	// 主页跳转
	@RequestMapping("/")
	public String indexJsp() {
		return "index";
	}

	// 页面跳转
	@RequestMapping("/{page}")
	public String pageJsp(String page) {
		return page;
	}
}