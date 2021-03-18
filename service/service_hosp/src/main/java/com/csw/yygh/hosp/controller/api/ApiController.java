package com.csw.yygh.hosp.controller.api;

import com.csw.yygh.common.exception.YyghException;
import com.csw.yygh.common.helper.HttpRequestHelper;
import com.csw.yygh.common.result.Result;
import com.csw.yygh.common.result.ResultCodeEnum;
import com.csw.yygh.common.utils.MD5;
import com.csw.yygh.hosp.service.HospitalService;
import com.csw.yygh.hosp.service.HospitalSetService;
import com.csw.yygh.model.hosp.Hospital;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/18 15:34 星期四
 * @Description: com.csw.yygh.hosp.controller.api
 * @version: 1.0
 */

@Api(tags = "医院管理API接口")
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;


    @Autowired
    private HospitalSetService hospitalSetService;


    //查询医院
//    @PostMapping("hospital/show")
//    public Result getHospital(HttpServletRequest request) {
//        //获取传递过来医院信息
//        Map<String, String[]> requestMap = request.getParameterMap();
//        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
//        //获取医院编号
//        String hoscode = (String)paramMap.get("hoscode");
//        //1 获取医院系统传递过来的签名,签名进行MD5加密
//        String hospSign = (String)paramMap.get("sign");
//
//        //2 根据传递过来医院编码，查询数据库，查询签名
//        String signKey = hospitalSetService.getSignKey(hoscode);
//
//        //3 把数据库查询签名进行MD5加密
//        String signKeyMd5 = MD5.encrypt(signKey);
//
//        //4 判断签名是否一致
//        if(!hospSign.equals(signKeyMd5)) {
//            throw new HospitalException(ResultCodeEnum.SIGN_ERROR);
//        }
//
//        //调用service方法实现根据医院编号查询
//        Hospital hospital = hospitalService.getByHoscode(hoscode);
//        return Result.ok(hospital);
//    }


    // 上传医院接口
    @PostMapping("/saveHospital")
    public Result saveHosp(HttpServletRequest request){

        // 获取传递过来的医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        // 1.获取医院系统传递过来的签名 ,签名是进行了MD5的加密
        String hospSign =(String) paramMap.get("sign");

        // 2.根据传递过来的编号查询数据库签名
        String hoscode=(String)paramMap.get("hoscode");
        String signKey = hospitalSetService.getSignKey(hoscode);

        // 3.把数据库查询签名进行md5加密
        String signKeyMD5 = MD5.encrypt(signKey);

        // 判断签名是否一致
        if(!hospSign.equals(signKeyMD5)){
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        //传输过程中“+”转换为了“ ”，因此我们要转换回来
        String logoData = (String)paramMap.get("logoData");
        logoData = logoData.replaceAll(" ","+");
        paramMap.put("logoData",logoData);

        // 调用service的方法
        hospitalService.save(paramMap);
        return Result.ok();
    }


}
