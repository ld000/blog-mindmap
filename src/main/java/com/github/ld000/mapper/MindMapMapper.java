package com.github.ld000.mapper;

import com.github.ld000.domain.MindMapPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wang Shengguo
 */
@Mapper
@Repository
public interface MindMapMapper {

    MindMapPO getMindMapByMindMapId(@Param("mindMapId") String mindMapId);

    void updateMindMapHeadFlag(@Param("mindMapId") String mindMapId);

    void saveMindMap(@Param("mindMapId") String mindMapId, @Param("content") String content, @Param("selections") String selections);

}
