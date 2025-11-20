package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderCreditBindPO;
import com.xs.order.service.infrastructure.persistence.service.OrderCreditBindService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderCreditBindMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_credit_bind(信用额度绑定表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderCreditBindServiceImpl extends ServiceImpl<OrderCreditBindMapper, OrderCreditBindPO>
    implements OrderCreditBindService{

}




