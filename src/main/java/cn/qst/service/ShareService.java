package cn.qst.service;

import java.util.List;

import cn.qst.pojo.TbShare;

public interface ShareService {
	
	// 根据id查找所有的分享
	List<TbShare> selectByUid(String uid);

	// 取消分享
	boolean cancelShare(String uid, String sid);
	
	// 根据分享id查找分享
	TbShare selectBySid(String sid);
	
	// 创建分享
	boolean save(TbShare tbShare);
	
}
