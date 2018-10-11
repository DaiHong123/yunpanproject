package cn.qst.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.qst.mapper.TbFileMapper;
import cn.qst.pojo.TbFile;
import cn.qst.pojo.TbFileExample;
import cn.qst.pojo.TbFileExample.Criteria;
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
	
	//根据文件类型查询文件
	@Override
	public List<TbFile> fundFileByType(String type , String uid) {
		if("All".equals(type)) {
			TbFileExample example = new TbFileExample();
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
	public List<TbFile> funFileByParentId(String parentId , String uid) {
		TbFileExample example = new TbFileExample();
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
}