package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderFlowLogPO;
import com.xs.order.service.infrastructure.persistence.service.OrderFlowLogService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderFlowLogMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_flow_log(订单操作流水记录表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderFlowLogServiceImpl extends ServiceImpl<OrderFlowLogMapper, OrderFlowLogPO>
    implements OrderFlowLogService{

}




