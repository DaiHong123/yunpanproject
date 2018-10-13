package cn.qst.controller;

import org.apache.log4j.varia.StringMatchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.qst.service.FileService;
import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.qst.comman.utils.Base64;
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
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/thumbnail")
	public String thumbnail(HttpSession session, HttpServletRequest request, String furl) throws IOException {
		// 初始化缩略图的路径
		String uploadPath = "/static/thum_img";
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);
		File file = new File(furl);
		BufferedImage sourceImg = null;
		FileInputStream fileInputStream = null;
		String thumbImageUrl = null;
		try {
			fileInputStream = new FileInputStream(file);
			sourceImg = ImageIO.read(fileInputStream);
			Integer WIDTH = sourceImg.getWidth();
			Integer HEIGHT = sourceImg.getHeight();
			thumbImageUrl = uploadPath + "/thum_" + file.getName();
			String des = realUploadPath + "/thum_" + file.getName();
			// 判断缩略图是否存在
			if (new File(des).exists()) {
				return thumbImageUrl;
			} else {
				Thumbnails.of(furl).size(WIDTH, HEIGHT).toFile(des);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return thumbImageUrl;
	}

	// 添加文件夹
	@RequestMapping("/createFile")
	@ResponseBody
	public TbFile createFile(String fname, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		String parentid = (String) session.getAttribute("fparentId");
		TbFile createFile = fileService.createFile(fname, user.getUid(), parentid);
		return createFile;
		// return null;
	}

	// 重命名文件
	@RequestMapping("/rename")
	@ResponseBody
	public boolean rename(String fname, String fid, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		fileService.rename(fname, fid, user.getUid());
		return true;
	}

	// 删除文件
	@RequestMapping("/deleteFile")
	@ResponseBody
	public boolean deleteFile(@RequestParam(value = "fids[]") String[] fids) {
		for (String fid : fids) {
			fileService.deleteFile(fid);
		}
		return true;
	}
}
