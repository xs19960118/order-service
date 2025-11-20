package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.PatientsPO;
import com.xs.order.service.infrastructure.persistence.service.PatientsService;
import com.xs.order.service.infrastructure.persistence.mapper.PatientsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【patients(主数据 - 患者)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class PatientsServiceImpl extends ServiceImpl<PatientsMapper, PatientsPO>
    implements PatientsService{

}




