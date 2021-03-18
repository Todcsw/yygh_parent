package com.csw.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.csw.yygh.hosp.repository.HospitalRepository;
import com.csw.yygh.hosp.service.HospitalService;
import com.csw.yygh.model.hosp.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/18 15:33 星期四
 * @Description: com.csw.yygh.hosp.service.impl
 * @version: 1.0
 */

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;


    @Override
    public void save(Map<String, Object> paramMap) {

        // 先把参数map集合转换成 对象Hospital
        String s = JSONObject.toJSONString(paramMap);
        Hospital hospital = JSONObject.parseObject(s, Hospital.class);


        // 判断是否存在数据
        String hoscode = hospital.getHoscode();

        Hospital hospitalExist=hospitalRepository.getHospitalByHoscode(hoscode);

        // 如果存在,进行修改
        if(hospitalExist!=null){
            hospital.setStatus(hospitalExist.getStatus());
            hospital.setCreateTime(hospitalExist.getCreateTime());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        }else{  // 如果不存在，进行添加

            //0：未上线 1：已上线
            hospital.setStatus(0);
            hospital.setCreateTime(new Date());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        }

    }
}
