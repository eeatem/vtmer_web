package com.vtmer.mapper;

import com.vtmer.domain.StatusLog;
import com.vtmer.domain.StatusLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusLogMapper {
    long countByExample(StatusLogExample example);

    int deleteByExample(StatusLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatusLog record);

    int insertSelective(StatusLog record);

    List<StatusLog> selectByExample(StatusLogExample example);

    StatusLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatusLog record, @Param("example") StatusLogExample example);

    int updateByExample(@Param("record") StatusLog record, @Param("example") StatusLogExample example);

    int updateByPrimaryKeySelective(StatusLog record);

    int updateByPrimaryKey(StatusLog record);
}