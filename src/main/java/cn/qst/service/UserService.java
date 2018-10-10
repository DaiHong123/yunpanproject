package cn.qst.service;

import cn.qst.pojo.TbCity;
import cn.qst.pojo.TbProvince;
import cn.qst.pojo.TbUser;

import java.util.List;

/**
 * @author lk 2018/9/7 11:22
 * @description:
 */

public interface UserService {

	/**
	 * 更新用户信息
	 *
	 * @param user 封装了用户的性别，vip，邮箱地址，电话，用户名,地址
	 * @return 更新成功即返回true 失败即返回 false
	 */
	Boolean changeUserInfo(TbUser user);

	/**
	 * 根据传入的用户姓名信息进行效验，是否含有重复数据
	 *
	 * @param name 用户注册信息
	 * @return 查找到值即返回name，没有即返回null
	 */
	Boolean selectByName(String name);

	/**
	 * 根据传入的用户电话信息进行效验，是否含有重复数据
	 *
	 * @param Phone 用户注册信息
	 * @return 查找到值即返回name，没有即返回null
	 */
	Boolean selectByPhone(String Phone);

	/**
	 * 效验用户邮件是否重复
	 *
	 * @param email 邮箱地址
	 * @return 成功即返回true 失败即返回 false
	 */
	Boolean selectByEmail(String email);

	/**
	 * 根据用户名查询出用户的信息，在和邮箱比较，是否正确
	 *
	 * @param uname 用户名
	 * @param email 邮箱地址
	 * @return 成功即返回true 失败即返回 false
	 */
	Boolean selectByUnameAndEmail(String uname, String email);

	/**
	 * 注册用户，添加到用户表中
	 * @param tbUser 注册信息，封装了用户的用户名，密码，vip，状态，性别，电话
	 *               邮件地址，默认头像
	 * @return 成功即返回true 失败即返回 false
	 */
	Boolean regist(TbUser tbUser);

	/**
	 * 登陆用户
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return 成功即返回true 失败即返回 false
	 */
	TbUser login(String userName, String passWord);

	/**
	 * 修改密码
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return 成功即返回true 失败即返回 false
	 */
	Boolean changePassword(String userName, String passWord);

	/**
	 * 根据用户名查询个人信息
	 * @param uname 用户名
	 * @return 成功即返回true 失败即返回 false
	 */
	TbUser selectPersonalInfo(String uname);

	/**
	 * 根据用户的地址id 查询用户所在地区
	 * @param addressId 地址id
	 * @return 成功即返回true 失败即返回 false
	 */
	TbCity selectUserCity(String addressId);

	/**
	 * 查询所有的省信息
	 * @return 成功即返回true 失败即返回 false
	 */
	List<TbProvince> selectProvince();

	/**
	 * 查询所有市的信息根据市id
	 * @param pid 市id
	 * @return list集合
	 */
	List<TbCity> selectCityByPid(Integer pid);
	
	/**
	 * 修改用户头像
	 * @param user 用户名，以及图片的url地址
	 * @return 修改成功即返回true 失败即false
	 */
	int upHeadImage(TbUser user);
	
	/**
	 * 根据传入的id 查询用户信息
	 * @param uid 用户id
	 * @return
	 */
	TbUser selectUserInfo(String uid);
	
	/**
	 * 效验用户状态
	 * @param uname
	 * @return
	 */
	Boolean verfiyUserStatus(String uname);
}
