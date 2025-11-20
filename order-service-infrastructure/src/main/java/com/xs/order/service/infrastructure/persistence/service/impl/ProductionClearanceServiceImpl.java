package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ProductionClearancePO;
import com.xs.order.service.infrastructure.persistence.service.ProductionClearanceService;
import com.xs.order.service.infrastructure.persistence.mapper.ProductionClearanceMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【production_clearance(加工单清关价格表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class ProductionClearanceServiceImpl extends ServiceImpl<ProductionClearanceMapper, ProductionClearancePO>
    implements ProductionClearanceService{

}




