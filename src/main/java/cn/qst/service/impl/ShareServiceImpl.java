package cn.qst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qst.mapper.TbShareMapper;
import cn.qst.pojo.TbShare;
import cn.qst.pojo.TbShareExample;
import cn.qst.pojo.TbShareExample.Criteria;
import cn.qst.service.ShareService;

/**
 * 分享业务层
 * @author Asimple
 * @date 2018年10月13日
 */
@Service
public class ShareServiceImpl implements ShareService {

	@Autowired
	private TbShareMapper tbShareMapper;
	
	@Override
	public List<TbShare> selectByUid(String uid) {
		TbShareExample example = new TbShareExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		return tbShareMapper.selectByExample(example);
	}

	@Override
	public boolean cancelShare(String uid, String sid) {
		TbShareExample example = new TbShareExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andSidEqualTo(sid);
		return tbShareMapper.deleteByExample(example)==1;
	}

	@Override
	public TbShare selectBySid(String sid) {
		return tbShareMapper.selectByPrimaryKey(sid);
	}

	@Override
	public boolean save(TbShare tbShare) {
		return tbShareMapper.insert(tbShare)==1;
	}

}
