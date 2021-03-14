package com.csw.yygh.cmn.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.csw.yygh.cmn.mapper.DictMapper;
import com.csw.yygh.model.cmn.Dict;
import com.csw.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 19:55 星期日
 * @Description: com.csw.yygh.cmn.listener
 * @version: 1.0
 */
public class DictListener extends AnalysisEventListener<DictEeVo> {

    private DictMapper dictMapper;

    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //一行一行读取
    @Override
    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
        //调用方法添加数据库
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictEeVo,dict);
        dictMapper.insert(dict);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
