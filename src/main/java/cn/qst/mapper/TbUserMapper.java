package cn.qst.mapper;

import cn.qst.pojo.TbCity;
import cn.qst.pojo.TbProvince;
import cn.qst.pojo.TbUser;
import cn.qst.pojo.TbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(String uid);

    int insert(TbUser record);

    /**
     * 注册调用的方法
     * @param record
     * @return
     */
    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
    /**
     * 效验用户名是否重复
     * 根据用户名直接查找是否有该用户名
     * @param uname 用户名
     * @return 数据库中的用户名
     */
    String selectByUname(String uname);
    
    /**
     * 效验用户邮箱是否重复
     * 根据邮箱直接查找
     * @param email 邮箱
     * @return 邮箱
     */
    String selectByEmail(String email);
    
    /**
     * 效验用户注册手机号是否重复
     * 根据电话号码直接查找
     * @param phone 电话号码
     * @return 电话号码
     */
    String selectByPhone(String phone);
    
    /**
     * 登陆，通过用户名进行登陆
     * @param uname
     * @return
     */
    TbUser selectByUnameOrUname(String uname);

    /**
     * 根据 地址id 查询用户所在的地区
     * @return
     */
    TbCity selectUserCity(String addressId);

    /**
     * 查询所有得城市信息
     * @return
     */
    List<TbProvince> selectAllProvince();

    /**
     * 根据省id 查询所有市信息
     * @param pid
     * @return
     */
    List<TbCity> selectCityByPid(Integer pid);

    /**
     * 修改用户密码
     * @return
     */
    int changePassword(TbUser user);

    /**
     * 修改用户信息，邮箱，电话号码，
     * @param user
     * @return
     */
    int changeUserInfo(TbUser user);
    
    /**
     * 修改用户的头像url地址
     * 
     * @param user 传入了用户名，以及图片url地址
     * @return
     */
    int upHeadImage(TbUser user);
    
    /**
     * 根据传入的用户id 查询用户个人信息
     *
     * @param uid 传入的id
     * @return 用户信息
     */
    TbUser selectUserInfo(String uid);

    /**
     * 效验用户状态
     * @param uname
     * @return
     */
    int verfiyUserStatus(String uname);
}