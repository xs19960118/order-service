package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderRemakePO;
import com.xs.order.service.infrastructure.persistence.service.OrderRemakeService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderRemakeMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_remake(病例重出设计记录表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class OrderRemakeServiceImpl extends ServiceImpl<OrderRemakeMapper, OrderRemakePO>
    implements OrderRemakeService{

}




