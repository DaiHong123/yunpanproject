package cn.qst.service;
import java.util.List;
import cn.qst.pojo.TbFile;

public interface FileService {

	List<TbFile> fundFileByType(String type , String uid);

	List<TbFile> funFileByParentId(String parentId , String uid);

	List<TbFile> fundFileParentsById(String parentId);
	
	TbFile createFile(String fname,String uid,String parentid);

}
