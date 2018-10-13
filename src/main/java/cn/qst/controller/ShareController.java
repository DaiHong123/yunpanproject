package cn.qst.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qst.pojo.TbShare;
import cn.qst.pojo.TbUser;
import cn.qst.service.ShareService;

/**
 * 分享请求处理
 * @author Asimple
 * @date 2018年10月11日
 */

@Controller
public class ShareController {
	@Autowired
	private ShareService shareService;
	
	// 跳转到我的分享
	@RequestMapping("/myshare")
	public String sharePage(Model map, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		List<TbShare> list = shareService.selectByUid(user.getUid());
		map.addAttribute("shares", list);
		return "myshare";
	}
	
	// 根据分享链接查看分享文件
	
	// 分享文件生成
	
	// 取消分享
	public String cancelShare(String sid) {
		return "";
	}
	
}
