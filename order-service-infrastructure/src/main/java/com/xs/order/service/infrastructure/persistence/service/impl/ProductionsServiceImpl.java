package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ProductionsPO;
import com.xs.order.service.infrastructure.persistence.service.ProductionsService;
import com.xs.order.service.infrastructure.persistence.mapper.ProductionsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【productions(加工单订单关联表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class ProductionsServiceImpl extends ServiceImpl<ProductionsMapper, ProductionsPO>
    implements ProductionsService{

}




