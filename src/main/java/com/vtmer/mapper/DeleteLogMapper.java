package com.vtmer.mapper;

import com.vtmer.domain.DeleteLog;
import com.vtmer.domain.DeleteLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeleteLogMapper {
    long countByExample(DeleteLogExample example);

    int deleteByExample(DeleteLogExample example);

    int insert(DeleteLog record);

    int insertSelective(DeleteLog record);

    List<DeleteLog> selectByExample(DeleteLogExample example);

    int updateByExampleSelective(@Param("record") DeleteLog record, @Param("example") DeleteLogExample example);

    int updateByExample(@Param("record") DeleteLog record, @Param("example") DeleteLogExample example);
}