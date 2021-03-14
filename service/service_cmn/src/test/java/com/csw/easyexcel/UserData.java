package com.csw.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 17:31 星期日
 * @Description: com.csw.easyexcel
 * @version: 1.0
 */

@Data
public class UserData {

    @ExcelProperty(value = "用户编号",index = 0)
    private int id;

    @ExcelProperty(value = "用户昵称",index = 1)
    private String username;
}
