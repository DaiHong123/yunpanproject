package cn.qst.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qst.service.FileService;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import cn.qst.comman.fastdfs.FileUploadUtils;
import cn.qst.pojo.FileResult;
import cn.qst.pojo.TbFile;
import cn.qst.pojo.TbUser;

@Controller
@RequestMapping("/file")
public class FileController {
	
	//上传文件的url地址
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
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
	
	//添加文件夹
	@RequestMapping("/createFile")
	@ResponseBody
	public TbFile createFile(String fname,HttpSession session) {
		TbUser user = (TbUser)session.getAttribute("user");
		String parentid = (String)session.getAttribute("fparentId");
		TbFile createFile = fileService.createFile(fname, user.getUid(), parentid);
		return createFile;
		//return null;
	}

	@RequestMapping("/fileUpload")
	@ResponseBody
	public boolean fileUpload() {
		
		return true;
	}
	
		
	//文件上传
	@RequestMapping("/uploadFile")
	@ResponseBody
	public TbFile picUpload(MultipartFile uploadFile , HttpSession session) {
		TbUser user = (TbUser)session.getAttribute("user");
		try {
			//上传文件获取服务器相对路径
			String path = FileUploadUtils.fileUpload(uploadFile);
			//截取文件名
			String originalFilename = uploadFile.getOriginalFilename();
			String fileName = originalFilename.substring(0,originalFilename.lastIndexOf('.'));
			//获取文件大小
			Double size = uploadFile.getSize()*1.0;
			//新建文件对象
			TbFile file = new TbFile();
			file.setFid(UUID.randomUUID().toString().replace("-", ""));
			file.setFname(fileName);
			file.setFsize(size);
			file.setSuffix(originalFilename.substring(originalFilename.lastIndexOf(".")+1));
			file.setParentid((String)session.getAttribute("fparentId"));
			file.setIsdir(false);
			file.setUid(user.getUid());
			file.setFurl(path);
			Date date = new Date();
			file.setUpdatetime(date);
			file.setUploadtime(date);
			//保存到数据库中
			return fileService.saveFile(file);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//重命名文件
	@RequestMapping("/rename")
	@ResponseBody
	public boolean rename(String fname,String fid,HttpSession session) throws UnsupportedEncodingException {
		TbUser user = (TbUser)session.getAttribute("user");
		fname = new String(fname.getBytes("iso8859-1"),"UTF-8");
		fileService.rename(fname, fid, user.getUid());
		return true;
	}
	
	
	//删除文件
	@RequestMapping("/deleteFile")
	@ResponseBody
	public boolean deleteFile(@RequestParam(value = "fids[]") String[] fids) {
		for(String fid:fids) {
			fileService.deleteFile(fid);
		}
		return true;
	}
}
