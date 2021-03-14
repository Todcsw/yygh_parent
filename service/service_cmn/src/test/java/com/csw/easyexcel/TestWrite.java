package com.csw.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 17:33 星期日
 * @Description: com.csw.easyexcel
 * @version: 1.0
 */
public class TestWrite {

    public static void main(String[] args) {

        ArrayList<UserData> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            UserData user=new UserData();
            user.setId(i);
            user.setUsername("张三"+i);
            list.add(user);
        }

        // 设置excel文件 路径和名称
        String fileName="E:\\excel\\01.xlsx";

        // 调用方法
        EasyExcel.write(fileName,UserData.class).sheet("用户的信息")
                .doWrite(list);

    }
}
