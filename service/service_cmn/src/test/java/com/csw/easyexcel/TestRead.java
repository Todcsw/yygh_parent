package com.csw.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 19:13 星期日
 * @Description: com.csw.easyexcel
 * @version: 1.0
 */
public class TestRead {

    public static void main(String[] args) {
        // 你要读取文件的路径

        String fileName="E:\\excel\\01.xlsx";

        // 调用方法实现读取操作
        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet()
                .doRead();
    }
}
