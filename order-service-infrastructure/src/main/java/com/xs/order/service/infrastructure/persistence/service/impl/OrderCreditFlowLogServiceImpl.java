package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderCreditFlowLogPO;
import com.xs.order.service.infrastructure.persistence.service.OrderCreditFlowLogService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderCreditFlowLogMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_credit_flow_log(信用修改流水记录表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderCreditFlowLogServiceImpl extends ServiceImpl<OrderCreditFlowLogMapper, OrderCreditFlowLogPO>
    implements OrderCreditFlowLogService{

}




