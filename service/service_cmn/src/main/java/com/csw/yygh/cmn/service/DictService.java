package com.csw.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csw.yygh.model.cmn.Dict;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 16:36 星期日
 * @Description: com.csw.yygh.cmn.service
 * @version: 1.0
 */
public interface DictService extends IService<Dict> {

    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

    /**
     * 导出
     * @param response
     */
    void exportDictData(HttpServletResponse response);

    /**
     * 导入
     * @param file
     */
    void importDictData(MultipartFile file);
}
