package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrdersPO;
import com.xs.order.service.infrastructure.persistence.service.OrdersService;
import com.xs.order.service.infrastructure.persistence.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, OrdersPO>
    implements OrdersService{

}




