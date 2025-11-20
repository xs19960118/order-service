package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.DoctorsPO;
import com.xs.order.service.infrastructure.persistence.service.DoctorsService;
import com.xs.order.service.infrastructure.persistence.mapper.DoctorsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【doctors(主数据-医生)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class DoctorsServiceImpl extends ServiceImpl<DoctorsMapper, DoctorsPO>
    implements DoctorsService{

}




