package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderAttributePO;
import com.xs.order.service.infrastructure.persistence.service.OrderAttributeService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderAttributeMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_attribute(订单属性表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderAttributeServiceImpl extends ServiceImpl<OrderAttributeMapper, OrderAttributePO>
    implements OrderAttributeService{

}




