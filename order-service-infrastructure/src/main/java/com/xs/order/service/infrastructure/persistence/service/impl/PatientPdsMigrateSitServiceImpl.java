package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.PatientPdsMigrateSitPO;
import com.xs.order.service.infrastructure.persistence.service.PatientPdsMigrateSitService;
import com.xs.order.service.infrastructure.persistence.mapper.PatientPdsMigrateSitMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【patient_pds_migrate_sit(患者迁移pds数据)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class PatientPdsMigrateSitServiceImpl extends ServiceImpl<PatientPdsMigrateSitMapper, PatientPdsMigrateSitPO>
    implements PatientPdsMigrateSitService{

}




