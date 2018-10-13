package cn.qst.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qst.comman.utils.JsonUtils;
import cn.qst.pojo.TbShare;
import cn.qst.pojo.TbUser;
import cn.qst.service.FileService;
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
	@Autowired
	private FileService fileService;
	
	// 跳转到我的分享
	@RequestMapping("/myshare")
	public String sharePage(Model map, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		List<TbShare> list = shareService.selectByUid(user.getUid());
		if( list.size()==0 ) list = null;
		map.addAttribute("shares", list);
		return "myshare";
	}
	
	// 根据分享链接查看分享文件
	
	// 分享文件生成
	public String save(HttpSession session, String fids) {
		TbUser user = (TbUser) session.getAttribute("user");
		String firstId = fids.split(",")[0];
		String sname = "新建分享";
		if( firstId != null ) sname = fileService.selectNameByFid(firstId);
		TbShare share = new TbShare();
		share.setUid(user.getUid());
		share.setFids(fids);
		share.setSharetime(new Date());
		share.setSname(sname);
		return "";
	}
	
	// 取消分享
	@RequestMapping("/cancelShare")
	@ResponseBody
	public String cancelShare(String sid, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		boolean flag = shareService.cancelShare(user.getUid(), sid);
		if( flag ) return JsonUtils.objectToJson("取消成功");
		return JsonUtils.objectToJson("取消失败");
	}
	
}
