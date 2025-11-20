package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderExtendsPO;
import com.xs.order.service.infrastructure.persistence.service.OrderExtendsService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderExtendsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_extends(订单扩展表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderExtendsServiceImpl extends ServiceImpl<OrderExtendsMapper, OrderExtendsPO>
    implements OrderExtendsService{

}




