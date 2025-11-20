package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderTransferLogPO;
import com.xs.order.service.infrastructure.persistence.service.OrderTransferLogService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderTransferLogMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_transfer_log】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class OrderTransferLogServiceImpl extends ServiceImpl<OrderTransferLogMapper, OrderTransferLogPO>
    implements OrderTransferLogService{

}




