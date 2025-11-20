package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.HospitalsPO;
import com.xs.order.service.infrastructure.persistence.service.HospitalsService;
import com.xs.order.service.infrastructure.persistence.mapper.HospitalsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【hospitals(医院（机构）)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class HospitalsServiceImpl extends ServiceImpl<HospitalsMapper, HospitalsPO>
    implements HospitalsService{

}




