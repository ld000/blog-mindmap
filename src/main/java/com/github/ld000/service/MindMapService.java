package com.github.ld000.service;

import com.github.ld000.domain.MindMapDTO;
import com.github.ld000.domain.MindMapPO;
import com.github.ld000.mapper.MindMapMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * MindMap Service
 */
@Log4j2
@Service
public class MindMapService {


    private MindMapMapper mindMapMapper;

    @Autowired
    public void setMindMapMapper(MindMapMapper mindMapMapper) {
        this.mindMapMapper = mindMapMapper;
    }

    /**
     * Get current version mindMap
     *
     * @param mindMapId mindMap id
     */
    public MindMapPO getMindMapByMindMapId(String mindMapId) throws Exception {

        log.info("getMindMapByMindMapId: mindMapId= {}", mindMapId);

        return mindMapMapper.getMindMapByMindMapId(mindMapId);
    }

    /**
     * Create/Update mindMap
     * 1.Update current version to non-current version
     * 2.Save mindMap
     */
    @Transactional
    public String saveMindMap(MindMapDTO mindMapDTO) throws Exception {
        String content = mindMapDTO.getContent();
        String selections = mindMapDTO.getSelections();

        String mindMapId = UUID.randomUUID().toString().replaceAll("-", "");

        log.info("saveMindMap: mindMapId= {},\ncontent= {},\nselections= {}", mindMapId, content, selections);

        mindMapMapper.saveMindMap(mindMapId, content, selections);

        return mindMapId;
    }

    /**
     * Create/Update mindMap
     * 1.Update current version to non-current version
     * 2.Save mindMap
     *
     * @param mindMapId mindMap id
     * @param mindMapDTO   mindMap content
     */
    @Transactional
    public String changeMindMap(String mindMapId, MindMapDTO mindMapDTO) throws Exception {

        String content = mindMapDTO.getContent();
        String selections = mindMapDTO.getSelections();

        // validate(content, selections);

        log.info("changeMindMap: mindMapId= {},\ncontent= {},\nselections= {}", mindMapId, content, selections);

        mindMapMapper.updateMindMapHeadFlag(mindMapId);
        mindMapMapper.saveMindMap(mindMapId, content, selections);

        return mindMapId;
    }

}
