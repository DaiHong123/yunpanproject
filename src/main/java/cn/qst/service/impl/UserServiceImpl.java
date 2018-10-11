package cn.qst.service.impl;

import cn.qst.comman.utils.MD5Utils;
import cn.qst.mapper.TbUserMapper;
import cn.qst.pojo.TbCity;
import cn.qst.pojo.TbProvince;
import cn.qst.pojo.TbUser;
import cn.qst.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk 2018/9/7 11:22
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper tbUserMapper;

	/**
	 * 更新用户的信息
	 * @param user 封装了用户的性别，vip，邮箱地址，电话，用户名
	 * @return 成功即返回true 失败即返回 false
	 */
	@Override
	public Boolean changeUserInfo(TbUser user) {
		return tbUserMapper.changeUserInfo(user) == 1 ? true : false;
	}

	/**
	 * 根据传入的用户姓名信息进行效验，是否含有重复数据
	 * 
	 * @param name 用户注册信息
	 * @return 查找到值即返回name，没有即返回null
	 */
	@Override
	public Boolean selectByName(String name) {
		// TODO Auto-generated method stub
		String returnName = tbUserMapper.selectByUname(name);
		return returnName != null ? false : true;
	}

	@Override
	public Boolean selectByPhone(String Phone) {
		// TODO Auto-generated method stub
		String returnPhone = tbUserMapper.selectByPhone(Phone);
		return returnPhone != null ? false : true;
	}
	
	@Override
	public Boolean selectByEmail(String email) {
		// TODO Auto-generated method stub
		String returnEmail = tbUserMapper.selectByEmail(email);
		return returnEmail != null ? false : true;
	}

	/**
	 * 根据用户名查询出用户的信息，在和邮箱比较，是否正确
	 *
	 * @param uname 用户名
	 * @param email 邮箱地址
	 * @return 成功即返回true 失败即返回 false
	 */
	@Override
	public Boolean selectByUnameAndEmail(String uname, String email) {
		TbUser user = tbUserMapper.selectByUnameOrUname(uname);
		if (user == null) {
			return false;
		} else {
			return user.getEmail().equals(email) ? true : false;
		}
	}
	/**
	 * 注册写入数据库 uid, uname, password, email, phone, sex, image,status(0:删除 ，1存在), VIP
	 * （0 非，1是）
	 * 
	 * @param tbUser
	 *            封装了插入用户的信息
	 * @return 插入是否成功
	 */
	@Override
	public Boolean regist(TbUser tbUser) {
		// TODO Auto-generated method stub
		int flag = tbUserMapper.insertSelective(tbUser);
		if (flag != 1) {
			return false;
		}
		return true;
	}

	/**
	 * 登陆，通过用户名查询信息
	 *
	 * @return  成功即返回true 失败即返回 false
	 */
	@Override
	public TbUser login(String userName, String passWord) {
		// TODO Auto-generated method stub
	 	TbUser user = tbUserMapper.selectByUnameOrUname(userName);
	 	if (user == null) {
	 		return null;
	 	} else {
	 		if (user.getPassword().equals(MD5Utils.md5(passWord))) {
	 			return user;
	 		} else {
	 			return null;
	 		}
	 	}
	}

	/**
	 * 修改密码
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return 成功即返回true 失败即返回 false
	 */
 	public Boolean changePassword(String userName, String passWord) {
 		TbUser user = new TbUser();
 		user.setPassword(passWord);
 		user.setUname(userName);
 		int i = tbUserMapper.changePassword(user);
 		if (i == 0) {
 			return false;
		} else {
 			return true;
		}
	}

	/**
	 * 根据用户名查找个人信息
	 * @param uname 用户名
	 * @return 封装了用户信息的TbUser对象
	 */
	@Override
	public TbUser selectPersonalInfo(String uname) {
		// TODO Auto-generated method stub
		return tbUserMapper.selectByUnameOrUname(uname);
	}

	/**
	 * 根据用户地址id，查询用户的具体信息
	 */
	@Override
	public TbCity selectUserCity(String addressId) {
		// TODO Auto-generated method stub
		return tbUserMapper.selectUserCity(addressId);
	}

	/**
	 * 查询所有城市的信息
	 * @return 城市的list集合信息
	 */
	@Override
	public List<TbProvince> selectProvince() {
		// TODO Auto-generated method stub
		return tbUserMapper.selectAllProvince();
	}

	/**
	 * 根据地址id查询用户所在地址
	 * @param pid 地址id
	 * @return 地址的信息
	 */
	@Override
	public List<TbCity> selectCityByPid(Integer pid) {
		return tbUserMapper.selectCityByPid(pid);
	}

	/**
	 * 修改用户头像
	 * @param user 用户名，以及图片的url地址
	 * @return 修改成功即返回true 失败即false
	 */
	@Override
	public int upHeadImage(TbUser user) {
		// TODO Auto-generated method stub
		return tbUserMapper.upHeadImage(user); 
	}

	@Override
	public TbUser selectUserInfo(String uid) {
		// TODO Auto-generated method stub
		return tbUserMapper.selectUserInfo(uid);
	}
	
}
