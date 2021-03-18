package com.csw.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csw.yygh.hosp.mapper.HospitalSetMapper;
import com.csw.yygh.hosp.service.HospitalSetService;
import com.csw.yygh.model.hosp.HospitalSet;
import org.springframework.stereotype.Service;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/12 16:42 星期五
 * @Description: com.csw.yygh.hosp.service.impl
 * @version: 1.0
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {


    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> wrapper=new QueryWrapper<>();
        wrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);

        return hospitalSet.getSignKey();
    }
}
