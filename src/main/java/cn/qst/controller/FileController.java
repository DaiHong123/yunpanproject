package cn.qst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.qst.service.FileService;

import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import cn.qst.comman.fastdfs.FileUploadUtils;
import cn.qst.comman.utils.Tree;
import cn.qst.comman.utils.TreeFile;
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
		String groupBy = (String)session.getAttribute("groupBy");
		if(groupBy==null) {
			groupBy = "fname";
		}
		List<TbFile> fileList = fileService.fundFileByType(type, user.getUid(),groupBy);
		return fileList;
	}

	// 根据父类id查询子文件
	@RequestMapping("/fundFileByParentId")
	@ResponseBody
	public FileResult fundFileByParentId(String parentId, HttpSession session) {
		session.setAttribute("fparentId", parentId);
		TbUser user = (TbUser) session.getAttribute("user");
		
		
		String groupBy = (String)session.getAttribute("groupBy");
		if(groupBy==null) {
			groupBy = "fname";
		}
		
		// 获取该文件夹的子文件
		List<TbFile> fileList = fileService.funFileByParentId(parentId, user.getUid(),groupBy);
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
	 * 根据文件id查询文件信息
	 * 
	 * @param fid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findFileByFid")
	public TbFile findFileByFid(String fid) {
		return fileService.findFileByFid(fid);
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
	public String thumbnail(HttpSession session, HttpServletRequest request, String furl, String type)
			throws IOException {
		// 初始化缩略图的路径
		String uploadPath = "/static/thum_img";
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);
		File file = new File(furl);
		String des = null;
		String thumbImageUrl = null;
		if ("thum".equals(type)) {
			des = realUploadPath + "/thum_" + file.getName();
			thumbImageUrl = uploadPath + "/thum_" + file.getName();
		} else {
			des = realUploadPath + "/big_thum_" + file.getName();
			thumbImageUrl = uploadPath + "/big_thum_" + file.getName();
		}
		if (new File(des).exists()) {
			return thumbImageUrl;
		} else {
			BufferedImage sourceImg = null;
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(file);
				sourceImg = ImageIO.read(fileInputStream);
				Integer width = sourceImg.getWidth();
				Integer height = sourceImg.getHeight();
				if ("thum".equals(type)) {
					if (width > 100 || height > 100) {
						width = width / 2;
						height = height / 2;
					} else if (width > 450 || height > 450) {
						width = width / 3;
						height = height / 3;
					} else if (width > 800 || height > 800) {
						width = width / 4;
						height = height / 4;
					}
				} else {
					if (width < 100 || height < 100) {
						width = width * 4;
						height = height * 4;
					} else if (width < 350 || height < 350) {
						width = width * 2;
						height = height * 2;
					}
				}
				Thumbnails.of(furl).size(width, height).toFile(des);
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
	}

	// 重命名文件
	@RequestMapping("/rename")
	@ResponseBody
	public boolean rename(String fname, String fid, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		try {
			fname = new String(fname.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileService.rename(fname, fid, user.getUid());
		return true;
	}

	// 文件上传
	@RequestMapping("/uploadFile")
	@ResponseBody
	public TbFile picUpload(MultipartFile uploadFile, HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		try {
			// 上传文件获取服务器相对路径
			String path = FileUploadUtils.fileUpload(uploadFile);
			// 截取文件名
			String originalFilename = uploadFile.getOriginalFilename();
			String fileName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
			// 获取文件大小
			Double size = uploadFile.getSize() * 1.0;
			// 新建文件对象
			TbFile file = new TbFile();
			file.setFid(UUID.randomUUID().toString().replace("-", ""));
			file.setFname(fileName);
			file.setFsize(size);
			file.setSuffix(originalFilename.substring(originalFilename.lastIndexOf(".") + 1));
			file.setParentid((String) session.getAttribute("fparentId"));
			file.setIsdir(false);
			file.setUid(user.getUid());
			file.setFurl(path);
			Date date = new Date();
			file.setUpdatetime(date);
			file.setUploadtime(date);
			// 保存到数据库中
			return fileService.saveFile(file);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 文件夹上传
	@RequestMapping("/uploadFileDir")
	@ResponseBody
	public TbFile picUploadDir(HttpServletRequest request , HttpSession session) throws Exception {
		//获取上传用户
		TbUser user = (TbUser) session.getAttribute("user");
		//获取文件父ID
		String parentId = (String) session.getAttribute("fparentId");
		//获取文件列表
		MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = params.getFiles("uploadFileDir");
		return fileService.saveDir(files,user,parentId);
	}
	
	// 文件下载
	@RequestMapping("/downlowd")
	@ResponseBody
    public Integer downlowd(String fileurl,@RequestParam(defaultValue="default")String fileName,@RequestParam(defaultValue="txt")String suffix,@RequestParam(defaultValue="C:\\Users\\Administrator\\Desktop")String savePath) throws Exception {
		fileName = fileName+UUID.randomUUID().toString().substring(0, 8)+"."+suffix;
		return fileService.downFile(fileurl,fileName,savePath);
    }
	
	//文件夹下载
	@RequestMapping("/dirdownload" )
	@ResponseBody
	public Integer dirDownload(String fid , @RequestParam(defaultValue="C:\\Users\\Administrator\\Desktop")String savePath) {
		return fileService.downDir(fid, savePath);
	}
	//多文件下载
	@RequestMapping("/downFiles" )
	@ResponseBody
	public Integer downFiles(@RequestParam(value = "fids[]") String[] fids , @RequestParam(defaultValue="C:\\Users\\Administrator\\Desktop\\云下载")String savePath) {
		savePath = savePath+UUID.randomUUID().toString().substring(0, 8);
		return fileService.downFiles(fids, savePath);
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

	// 查询文件夹树
	@RequestMapping("/copyFile")
	@ResponseBody
	public Tree copyFile(HttpSession session) {
		Tree tree = new Tree();
		List<TreeFile> files = new ArrayList<>();
		TbUser user = (TbUser) session.getAttribute("user");
		List<TbFile> TbFiles = fileService.treeFiles(user.getUid());
		TreeFile treeFile1 = new TreeFile();
		treeFile1.setId("-1");
		treeFile1.setPid("-2");
		treeFile1.setTitle("全部文件");
		files.add(treeFile1);
		for (TbFile file : TbFiles) {
			TreeFile treeFile = new TreeFile();
			treeFile.setId(file.getFid());
			treeFile.setPid(file.getParentid());
			treeFile.setTitle(file.getFname());
			files.add(treeFile);
		}
		tree.setFiles(files);
		return tree;
	}

	// 复制文件
	@RequestMapping("/copyFiles")
	@ResponseBody
	public boolean copyFiles(@RequestParam(value = "fids[]") String[] fids, String pid) {
		boolean b = true;
		for (String fid : fids) {
			String fname = fileService.selectNameByFid(fid);
			System.out.println(fname);
			List<String> fundChildren = fileService.fundChildren(pid);
			for (String name : fundChildren) {
				if (fname.equals(name)) {
					return false;
				}
			}
		}
		for (String fid : fids) {
			fileService.copyFile(fid, pid);
		}
		return b;
	}

	// 移动文件
	@RequestMapping("/moveFiles")
	@ResponseBody
	public boolean moveFiles(@RequestParam(value = "fids[]") String[] fids, String pid) {
		boolean b = true;
		for (String fid : fids) {
			String fname = fileService.selectNameByFid(fid);
			System.out.println(fname);
			List<String> fundChildren = fileService.fundChildren(pid);
			for (String name : fundChildren) {
				if (fname.equals(name)) {
					return false;
				}
			}
		}
		for (String fid : fids) {
			b = fileService.moveFile(fid, pid);
			if (b == false) {
				return b;
			}
		}
		return b;
	}
	

	//搜索文件
	@RequestMapping("/searchName")
	@ResponseBody
	public List<TbFile> searchName(String searchName,HttpSession session){
		TbUser user = (TbUser) session.getAttribute("user");
		String groupBy = (String)session.getAttribute("groupBy");
		if(groupBy==null) {
			groupBy = "fname";
		}
		List<TbFile> searchByName = fileService.searchByName(searchName, user.getUid(),groupBy);
		return searchByName;
	}
	
	//分类
	@RequestMapping(value="/group")
	@ResponseBody
	public List<TbFile> group(HttpSession session,String group,String searchName){
		System.out.println(searchName);
		if(group.equals("fileName")) {
			session.setAttribute("groupBy", "fname");
		}else if(group.equals("fileSize")) {
			session.setAttribute("groupBy", "fsize");
		}else if(group.equals("fileDate")) {
			session.setAttribute("groupBy", "updatetime");
		}
		TbUser user = (TbUser) session.getAttribute("user");
		String groupBy = (String)session.getAttribute("groupBy");
		if(searchName.equals("")) {
			String pid = (String)session.getAttribute("fparentId");
			List<TbFile> listFiles = fileService.funFileByParentId(pid, user.getUid(), groupBy);
			return listFiles;
		}else {
			List<TbFile> searchByName = fileService.searchByName(searchName, user.getUid(), groupBy);
			return searchByName;
		}
	}
	
	//容量计算
	@RequestMapping("/capacity")
	@ResponseBody
	public double capacity(HttpSession session) {
		TbUser user = (TbUser) session.getAttribute("user");
		String capacity = fileService.capacity(user.getUid());
		if(capacity==null) {
			return 0;
		}else {
			return Double.parseDouble(capacity);
		}
	}
	
	@RequestMapping("/getTbFiles")
	@ResponseBody
	public List<TbFile> getTbFiles(HttpSession session){
		TbUser user = (TbUser) session.getAttribute("user");
		List<TbFile> getTbFiles = fileService.getTbFiles(user.getUid());
		return getTbFiles;
	}
}
