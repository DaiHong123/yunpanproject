package cn.qst.mapper;

import cn.qst.pojo.TbFile;
import cn.qst.pojo.TbFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFileMapper {
    int countByExample(TbFileExample example);

    int deleteByExample(TbFileExample example);

    int deleteByPrimaryKey(String fid);

    int insert(TbFile record);

    int insertSelective(TbFile record);

    List<TbFile> selectByExample(TbFileExample example);

    TbFile selectByPrimaryKey(String fid);

    int updateByExampleSelective(@Param("record") TbFile record, @Param("example") TbFileExample example);

    int updateByExample(@Param("record") TbFile record, @Param("example") TbFileExample example);

    int updateByPrimaryKeySelective(TbFile record);

    int updateByPrimaryKey(TbFile record);
    
    String capacity(String uid);
}