package per.ymm.weixiubao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.pojo.EngineerExample;

public interface EngineerMapper {
    int countByExample(EngineerExample example);

    int deleteByExample(EngineerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Engineer record);

    int insertSelective(Engineer record);

    List<Engineer> selectByExample(EngineerExample example);

    Engineer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Engineer record, @Param("example") EngineerExample example);

    int updateByExample(@Param("record") Engineer record, @Param("example") EngineerExample example);

    int updateByPrimaryKeySelective(Engineer record);

    int updateByPrimaryKey(Engineer record);
}