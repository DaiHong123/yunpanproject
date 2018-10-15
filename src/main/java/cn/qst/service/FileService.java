package cn.qst.service;
import java.util.List;


import cn.qst.pojo.TbFile;

public interface FileService {

	List<TbFile> fundFileByType(String type , String uid);

	List<TbFile> funFileByParentId(String parentId , String uid);

	List<TbFile> fundFileParentsById(String parentId);
	
    TbFile findFileByFid(String fid);

	TbFile createFile(String fname,String uid,String parentid);
	
	String selectNameByFid(String fid);
	
	TbFile selectById(String id);
	
	TbFile saveFile(TbFile file);
	
	boolean rename(String fname,String fid,String uid);

	void deleteFile(String fid);
	

	List<TbFile> treeFiles(String uid);
	
	List<String> fundChildren(String pid);
	
	
	void copyFile(String fid,String pid);
	
	boolean moveFile(String fid,String pid);



	int downFile(String fileurl, String fileName, String suffix, String savePath) throws Exception;

	Integer downDir(String fid , String savePath);

}
