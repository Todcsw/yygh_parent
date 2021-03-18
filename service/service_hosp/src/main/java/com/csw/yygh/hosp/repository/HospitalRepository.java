package com.csw.yygh.hosp.repository;

import com.csw.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/18 15:33 星期四
 * @Description: com.csw.yygh.hosp.repository
 * @version: 1.0
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    /**
     * 判断是否存在数据
     * @param hoscode
     * @return
     */
    Hospital getHospitalByHoscode(String hoscode);
}
