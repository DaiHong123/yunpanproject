package cn.qst.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qst.comman.utils.JsonUtils;
import cn.qst.comman.utils.UniCodeUtil;
import cn.qst.pojo.TbFile;
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
	@RequestMapping("/openfile")
	public String viewShare(Model map, String code) {
		if( code == null ) return "500";
		TbShare share = shareService.selectBySid(code);
		map.addAttribute("shareInfo", share);
		if( share != null ) {
			String[] ids = share.getFids().split(",");
			List<TbFile> list = new ArrayList<>();
			for(String id: ids) list.add(fileService.selectById(id));
			map.addAttribute("files", list);
		}
		return "sharefile";
	}
	
	// 分享文件生成
	@RequestMapping("/share")
	@ResponseBody
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
		share.setSid(UniCodeUtil.rand());
		boolean flag = shareService.save(share);
		Map<String, Object> map = new HashMap<>();
		if( flag ) {
			map.put("code", "1");
			map.put("url", "http://localhost:8080/openfile?code="+share.getSid());
		} else map.put("code", "0");
		return JsonUtils.objectToJson(map);
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
