package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderItemsPO;
import com.xs.order.service.infrastructure.persistence.service.OrderItemsService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderItemsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_items(订单明细表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItemsPO>
    implements OrderItemsService{

}




