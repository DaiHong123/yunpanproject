package cn.qst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.qst.service.FileService;
import net.coobird.thumbnailator.Thumbnails;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.qst.pojo.FileResult;
import cn.qst.pojo.TbFile;
import cn.qst.pojo.TbUser;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	// 右侧功能栏搜索,根据类型查询文件
	@RequestMapping("/fundFile")
	@ResponseBody
	public List<TbFile> fundFileByType(String type, HttpSession session) {
		// 获取用户id
		session.setAttribute("fparentId", "-1");
		TbUser user = (TbUser) session.getAttribute("user");
		List<TbFile> fileList = fileService.fundFileByType(type, user.getUid());
		return fileList;
	}

	// 根据父类id查询子文件
	@RequestMapping("/fundFileByParentId")
	@ResponseBody
	public FileResult fundFileByParentId(String parentId, HttpSession session) {
		session.setAttribute("fparentId", parentId);
		TbUser user = (TbUser) session.getAttribute("user");
		// 获取该文件夹的子文件
		List<TbFile> fileList = fileService.funFileByParentId(parentId, user.getUid());
		// 获取该文件的父文件
		List<TbFile> parent = fileService.fundFileParentsById(parentId);
		// 创建返回结果集
		FileResult result = new FileResult();
		// 添加子文件
		result.setFiles(fileList);
		// 添加符文件
		result.setParent(parent);
		return result;
	}

	/**
	 * 接受图片url地址，生成图片缩略图，并返回缩略图url
	 * 
	 * @param session
	 * @param request
	 * @param url
	 * @return
	 */
	@RequestMapping("/thumbnail")
	public String thumbnail(HttpSession session, HttpServletRequest request,
			@RequestParam(defaultValue="../static/img/blankBg.png") String url) {
		final Integer WIDTH = 100;
		final Integer HEIGHT = 100;

		String uploadPath = "/static/img";
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);

		File file = new File(url);

		try {
			String des = realUploadPath + "/thum_" + file.getName();
			Thumbnails.of(new BufferedInputStream(new FileInputStream(file))).size(WIDTH, HEIGHT).toFile(des);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String thumbImageUrl = uploadPath + "/thum_" + file.getName();
		request.setAttribute("thumbUrl", thumbImageUrl);
		return "register";
	}
}
