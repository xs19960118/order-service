package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.CaseProductionsPO;
import com.xs.order.service.infrastructure.persistence.service.CaseProductionsService;
import com.xs.order.service.infrastructure.persistence.mapper.CaseProductionsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【case_productions】的数据库操作Service实现
* @createDate 2025-11-19 18:34:28
*/
@Service
public class CaseProductionsServiceImpl extends ServiceImpl<CaseProductionsMapper, CaseProductionsPO>
    implements CaseProductionsService{

}




