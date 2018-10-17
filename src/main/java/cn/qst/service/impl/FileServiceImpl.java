package cn.qst.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.qst.comman.fastdfs.FileUploadUtils;
import cn.qst.mapper.TbFileMapper;
import cn.qst.pojo.TbFile;
import cn.qst.pojo.TbFileExample;
import cn.qst.pojo.TbFileExample.Criteria;
import cn.qst.pojo.TbUser;
import cn.qst.service.FileService;

/**
 * 文件管理业务层
 * @author Administrator
 *
 */
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private TbFileMapper fileMapper;
	
	@Value("${TOP_PARENT_ID}")
	private String TOP_PARERNT_ID;
	
	//上传文件的url地址前半段
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	//根据文件类型查询文件
	@Override
	public List<TbFile> fundFileByType(String type , String uid,String groupBy) {
		if("All".equals(type)) {
			TbFileExample example = new TbFileExample();
			example.setOrderByClause(groupBy);
			Criteria criteria = example.createCriteria();
			criteria.andParentidEqualTo(TOP_PARERNT_ID);
			criteria.andUidEqualTo(uid);
			return fileMapper.selectByExample(example);
		}else {
			TbFileExample example = new TbFileExample();
			Criteria criteria = example.createCriteria();
			criteria.andSuffixEqualTo(type);
			criteria.andUidEqualTo(uid);
			return fileMapper.selectByExample(example);
		}
	}

	//根据文件Id获取子文件
	@Override
	public List<TbFile> funFileByParentId(String parentId , String uid,String groupBy) {
		TbFileExample example = new TbFileExample();
		example.setOrderByClause(groupBy);
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentId);
		criteria.andUidEqualTo(uid);
		return fileMapper.selectByExample(example);
	}
	
	@Override
	public List<TbFile> fundFileParentsById(String parentId) {
		// TODO Auto-generated method stub
		List<TbFile> parents = new ArrayList<>();
		while(true) {
			if(TOP_PARERNT_ID.equals(parentId.trim())) {
				break;
			}
			TbFile file = fileMapper.selectByPrimaryKey(parentId);
			parents.add(file);
			parentId = file.getParentid();
		}
		//添加首个导航 全部文件
		TbFile f = new TbFile();
		f.setFid(TOP_PARERNT_ID);
		f.setFname("全部文件");
		f.setIsdir(true);
		parents.add(f);
		//反转
		Collections.reverse(parents);
		return parents;
	}

	/**
	 * 查询文件具体信息
	 * @param fid
	 * @return
	 */
	public TbFile findFileByFid(String fid) {
		return fileMapper.selectByPrimaryKey(fid);
	}
	
	//添加文件夹
	@Override
	public TbFile createFile(String fname, String uid, String parentid) {
		// TODO Auto-generated method stub
		TbFile tbFile = new TbFile();
		tbFile.setFid(String.valueOf(UUID.randomUUID()).replace("-", ""));
		tbFile.setFname(fname);
		tbFile.setFsize(null);
		tbFile.setFurl("-");
		tbFile.setSuffix(null);
		tbFile.setIsdir(true);
		tbFile.setUploadtime(new Date());
		tbFile.setUpdatetime(new Date());
		tbFile.setParentid(parentid);
		tbFile.setUid(uid);
		int insert = fileMapper.insert(tbFile);
		return insert==1?tbFile:null;
	}

	@Override
	public TbFile saveFile(TbFile file) {
		fileMapper.insertSelective(file);
		return file;
	}
	
	//文件重命名
	@Override
	public boolean rename(String fname,String fid,String uid) {
		// TODO Auto-generated method stub
		TbFile tbFile = new TbFile();
		tbFile.setFname(fname);
		tbFile.setFid(fid);
		tbFile.setUid(uid);
		tbFile.setUploadtime(new Date());
		int primaryKeySelective = fileMapper.updateByPrimaryKeySelective(tbFile);
		return primaryKeySelective==1?true:false;
	}

	
	//文件删除
	@Override
	public void deleteFile(String fid) {
		// TODO Auto-generated method stub		
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(fid);
		List<TbFile> files = fileMapper.selectByExample(example);
		//如果存在子菜单
				if(files!=null&&files.size()>0) {
					//递归删除
					for (TbFile file : files) {
						this.deleteFile(file.getFid());
					}
				}
				//删除改菜单
				fileMapper.deleteByPrimaryKey(fid);		
	}

	@Override
	public String selectNameByFid(String fid) {
		TbFile file = fileMapper.selectByPrimaryKey(fid);
		if( file == null ) return null;
		else return file.getFname();
	}
	
	//查找文件夹树
	@Override
	public List<TbFile> treeFiles(String uid) {
		// TODO Auto-generated method stub
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andIsdirEqualTo(true);

		List<TbFile> files = fileMapper.selectByExample(example );
		return files;
		
	}

	
	//复制文件
	@Override
	public void copyFile(String fid, String pid) {
		// TODO Auto-generated method stub	
		//首先将查找到的fid的文件复制一份到数据库中指向pid
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(fid);
		List<TbFile> example2 = fileMapper.selectByExample(example );
		TbFile tbFile = example2.get(0);
		tbFile.setFid(UUID.randomUUID().toString().replaceAll("-", ""));
		tbFile.setParentid(pid);
		tbFile.setUploadtime(new Date());
		tbFile.setUpdatetime(new Date());
		 fileMapper.insertSelective(tbFile);
		 
		 //查找其fid下的所有子文件
		TbFileExample example3 = new TbFileExample();
		Criteria criteria3 = example3.createCriteria();
		criteria3.andParentidEqualTo(fid);
		List<TbFile> selectByExample = fileMapper.selectByExample(example3);
		//递归查找其子文件再复制
		for(TbFile file:selectByExample) {
			copyFile(file.getFid(), tbFile.getFid());
		}		
	}

	
	//移动文件
	@Override
	public boolean moveFile(String fid, String pid) {
		// TODO Auto-generated method stub
		TbFile tbFile = new TbFile();
		tbFile.setFid(fid);
		tbFile.setParentid(pid);
		int selective = fileMapper.updateByPrimaryKeySelective(tbFile);
		return selective==1?true:false;
	}
	
	//文件下载
	@Override
	public int downFile(String fileurl, String fileName, String savePath) throws Exception {
		URL httpUrl = new URL(IMAGE_SERVER_URL+fileurl);  
		HttpURLConnection conn = (HttpURLConnection)httpUrl.openConnection();  
                //设置超时间为3秒
		conn.setConnectTimeout(3*1000);
		//防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
 
		//得到输入流
		InputStream inputStream = conn.getInputStream();  
		//获取字节数组
		byte[] getData = readInputStream(inputStream);
		//文件保存位置
		File saveDir = new File(savePath);
		if(!saveDir.exists()){
			saveDir.mkdir();
		}
		File file = new File(saveDir+File.separator+fileName);    
		FileOutputStream fos = new FileOutputStream(file);     
		fos.write(getData); 
		if(fos!=null){
			fos.close();  
		}
		if(inputStream!=null){
			inputStream.close();
		}
		if(file!=null) {
			return 200;
		}
		return 500;
	}
	
	//文件夹下载
	@Override
	public Integer downDir(String fid , String savePath) {
		//获取文件信息
		TbFile file = fileMapper.selectByPrimaryKey(fid);
		//文件保存位置
		File saveDir = new File(savePath+"\\"+file.getFname());
		if(!saveDir.exists()){
			saveDir.mkdirs();
		}
		//查询所有的子类
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(fid);
		List<TbFile> list = fileMapper.selectByExample(example);
		//遍历集合
		for (TbFile tbFile : list) {
			if(tbFile.getIsdir()) {
				downDir(tbFile.getFid(), savePath+"\\"+file.getFname());
			}else {
				try {
					
					downFile(tbFile.getFurl(),tbFile.getFname()+"."+tbFile.getSuffix(), savePath+"\\"+file.getFname());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 500;
				}
			}
		}
		return 200;
	}
	
	//多文件下载
	@Override
	public Integer downFiles(String[] fids, String savePath) {
		//文件保存位置
		File saveDir = new File(savePath);
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		for (String fid : fids) {
			TbFile file = fileMapper.selectByPrimaryKey(fid);
			if(file.getIsdir()) {
				downDir(fid, savePath);
			}else {
				try {
					downFile(file.getFurl(),file.getFname()+"."+file.getSuffix(), savePath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 500;
				}
			}
		}
		return 200;
	}

	//读取文件
	private  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

	@Override
	public TbFile selectById(String id) {
		return fileMapper.selectByPrimaryKey(id);
	}

	
	//通过父id查找其子类名字
	@Override
	public List<String> fundChildren(String pid) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<>();
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(pid);
		List<TbFile> selectByExample = fileMapper.selectByExample(example);
		
		for(TbFile file:selectByExample) {
			strings.add(file.getFname());
		}
		return strings;
	}


	
	//搜索
	@Override
	public List<TbFile> searchByName(String searchName,String uid,String groupBy) {
		// TODO Auto-generated method stub
		
		TbFileExample example = new TbFileExample();
		example.setOrderByClause(groupBy);
		Criteria criteria = example.createCriteria();
		criteria.andFnameLike("%"+searchName+"%");
		criteria.andUidEqualTo(uid);
		
		List<TbFile> selectByExample = fileMapper.selectByExample(example );
		return selectByExample;
	}

	
	//计算容量
	@Override
	public String capacity(String uid) {
		// TODO Auto-generated method stub
		
		String capacity = fileMapper.capacity(uid);
		return capacity;
	}
	
	
	

	//文件夹上传
	@Override
	public TbFile saveDir(List<MultipartFile> files, TbUser user, String parentId) throws Exception {
		if(files==null) {
			return null;
		}else {
			String upDirName = "";
			for (MultipartFile f : files) {
				if (f instanceof CommonsMultipartFile) {
					CommonsMultipartFile f2 = (CommonsMultipartFile) f;
					//切割路径
					String[] strings = f2.getFileItem().getName().split("/");
					upDirName = strings[0];
					//父id
					String pid = parentId;
					//创建文件结构
					for (int i=0;i<strings.length-1;i++) {
						//判断路径是否存在
						TbFileExample example = new TbFileExample();
						Criteria criteria = example.createCriteria();
						criteria.andParentidEqualTo(pid);
						criteria.andFnameEqualTo(strings[i]);
						List<TbFile> list = fileMapper.selectByExample(example);
						if(list.isEmpty()) {
							//创建目录结构
							TbFile file = new TbFile();
							//获取id
							String fid = UUID.randomUUID().toString().replace("-", "");
							file.setFid(fid);
							file.setFname(strings[i]);
							file.setFurl("-");
							file.setIsdir(true);
							file.setParentid(pid);
							file.setUid(user.getUid());
							Date date = new Date();
							file.setUpdatetime(date);
							file.setUploadtime(date);
							//插入数据
							fileMapper.insertSelective(file);
							//更新父id
							pid = fid;
						}else {
							pid = list.get(0).getFid();
						}
					}
					//上传文件 返回服务器URL
					String furl = FileUploadUtils.fileUpload(f);
					//保存文件数据
					TbFile file = new TbFile();
					file.setFid(UUID.randomUUID().toString().replace("-", ""));
					//截取文件名和后缀
					String originalFilename = f.getOriginalFilename();
					String fileName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
					String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
					file.setFname(fileName);
					file.setFurl(furl);
					file.setSuffix(suffix);
					file.setIsdir(false);
					// 获取文件大小
					Double size = f.getSize() * 1.0;
					file.setFsize(size);
					file.setParentid(pid);
					Date date = new Date();
					file.setUpdatetime(date);
					file.setUploadtime(date);
					file.setUid(user.getUid());
					//插入数据
					fileMapper.insert(file);
				}
			}
			//获取顶层文件夹
			TbFileExample example = new TbFileExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentidEqualTo(parentId);
			criteria.andFnameEqualTo(upDirName);
			List<TbFile> list = fileMapper.selectByExample(example);
			if(list.isEmpty()) {
				return null;
			}
			return list.get(0);
		}
	}

	@Override
	public List<TbFile> getTbFiles(String uid) {
		// TODO Auto-generated method stub
		
		
		TbFileExample example = new TbFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		fileMapper.selectByExample(example );
		return null;
	}
}