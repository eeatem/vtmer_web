package com.vtmer.mapper;

import com.vtmer.domain.ProfileLog;
import com.vtmer.domain.ProfileLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileLogMapper {
    long countByExample(ProfileLogExample example);

    int deleteByExample(ProfileLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProfileLog record);

    int insertSelective(ProfileLog record);

    List<ProfileLog> selectByExampleWithBLOBs(ProfileLogExample example);

    List<ProfileLog> selectByExample(ProfileLogExample example);

    ProfileLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProfileLog record, @Param("example") ProfileLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ProfileLog record, @Param("example") ProfileLogExample example);

    int updateByExample(@Param("record") ProfileLog record, @Param("example") ProfileLogExample example);

    int updateByPrimaryKeySelective(ProfileLog record);

    int updateByPrimaryKeyWithBLOBs(ProfileLog record);

    int updateByPrimaryKey(ProfileLog record);
}