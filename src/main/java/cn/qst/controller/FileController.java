package cn.qst.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.qst.service.FileService;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.qst.pojo.FileResult;
import cn.qst.pojo.TbFile;
import cn.qst.pojo.TbUser;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	//右侧功能栏搜索,根据类型查询文件
	@RequestMapping("/fundFile")
	@ResponseBody
	public List<TbFile> fundFileByType(String type , HttpSession session){
		//获取用户id
		session.setAttribute("fparentId", "-1");
		TbUser user = (TbUser)session.getAttribute("user");
		List<TbFile> fileList = fileService.fundFileByType(type , user.getUid());
		return fileList;
	}
	//根据父类id查询子文件
	@RequestMapping("/fundFileByParentId")
	@ResponseBody
	public FileResult fundFileByParentId(String parentId , HttpSession session){
		session.setAttribute("fparentId", parentId);
		TbUser user = (TbUser)session.getAttribute("user");
		//获取该文件夹的子文件
		List<TbFile> fileList = fileService.funFileByParentId(parentId , user.getUid());
		//获取该文件的父文件
		List<TbFile> parent = fileService.fundFileParentsById(parentId);
		//创建返回结果集
		FileResult result = new FileResult();
		//添加子文件
		result.setFiles(fileList);
		//添加符文件
		result.setParent(parent);
		return result;
	}
	
}
