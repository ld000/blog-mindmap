package com.github.ld000.controller;

import com.github.ld000.common.CommonResultResponse;
import com.github.ld000.common.ResponseHelper;
import com.github.ld000.domain.MindMapDTO;
import com.github.ld000.service.MindMapService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Business Understanding MindMap Controller
 */
@RestController
@RequestMapping(value = "/mindmaps")
public class MindMapController {

    private MindMapService mindMapService;

    @Autowired
    public void setMindMapService(MindMapService mindMapService) {
        this.mindMapService = mindMapService;
    }

    @ApiOperation(value = "根据id查找脑图")
    @ApiImplicitParam(name = "id", value = "脑图id", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResultResponse> getMindMap(@PathVariable("id") String mindMapId) throws Exception {

        return ResponseHelper.success(mindMapService.getMindMapByMindMapId(mindMapId));
    }

    @ApiOperation(value = "创建脑图")
    @ApiImplicitParam(name = "mindMapDTO", value = "脑图内容",  dataType = "MindMapDTO", paramType = "body")
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResultResponse> createMindMapNew(@Valid @RequestBody MindMapDTO mindMapDTO) throws Exception {
        return ResponseHelper.success(mindMapService.saveMindMap(mindMapDTO));
    }


    @ApiOperation(value = "更新指定id的脑图内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "脑图id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "mindMapDTO", value = "脑图内容",  dataType = "MindMapDTO", paramType = "body")
    })
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResultResponse> updateMindMapNew(@PathVariable("id") String mindMapId,
                                                                 @Valid @RequestBody MindMapDTO mindMapDTO) throws Exception {
        return ResponseHelper.success(mindMapService.changeMindMap(mindMapId, mindMapDTO));

    }
}