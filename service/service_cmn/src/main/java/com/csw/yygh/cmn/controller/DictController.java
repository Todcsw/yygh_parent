package com.csw.yygh.cmn.controller;

import com.csw.yygh.cmn.service.DictService;
import com.csw.yygh.common.result.Result;
import com.csw.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 16:41 星期日
 * @Description: com.csw.yygh.cmn.controller
 * @version: 1.0
 */
@Api(tags = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;


    // 导入数据字典
    @ApiOperation(value = "导入")
    @PostMapping("/importData")
    public Result importDict(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }

    // 导出数据字典的接口
    @ApiOperation(value="导出")
    @GetMapping("/exportData")
    public void exportDict(HttpServletResponse response){
        dictService.exportDictData(response);
    }

    //根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChlidData(id);
        return Result.ok(list);
    }

}
