package com.csw.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 19:10 星期日
 * @Description: com.csw.easyexcel
 * @version: 1.0
 */
public class ExcelListener extends AnalysisEventListener<UserData> {


    // 一行一行读取excel内容,从第二行读取
    @Override
    public void invoke(UserData userData, AnalysisContext analysisContext) {
        System.out.println(userData);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息:"+headMap);
    }

    // 读取之后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("已经读完");
    }
}
