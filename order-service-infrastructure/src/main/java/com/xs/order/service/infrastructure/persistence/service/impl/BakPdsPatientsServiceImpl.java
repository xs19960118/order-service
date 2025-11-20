package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.BakPdsPatientsPO;
import com.xs.order.service.infrastructure.persistence.service.BakPdsPatientsService;
import com.xs.order.service.infrastructure.persistence.mapper.BakPdsPatientsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【bak_pds_patients(主数据 - 患者)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:28
*/
@Service
public class BakPdsPatientsServiceImpl extends ServiceImpl<BakPdsPatientsMapper, BakPdsPatientsPO>
    implements BakPdsPatientsService{

}




