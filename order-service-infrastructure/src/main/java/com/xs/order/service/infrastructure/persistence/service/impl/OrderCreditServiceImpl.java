package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderCreditPO;
import com.xs.order.service.infrastructure.persistence.service.OrderCreditService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderCreditMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_credit(信用额度表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderCreditServiceImpl extends ServiceImpl<OrderCreditMapper, OrderCreditPO>
    implements OrderCreditService{

}




