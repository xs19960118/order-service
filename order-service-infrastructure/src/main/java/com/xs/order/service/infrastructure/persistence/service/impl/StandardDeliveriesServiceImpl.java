package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.StandardDeliveriesPO;
import com.xs.order.service.infrastructure.persistence.service.StandardDeliveriesService;
import com.xs.order.service.infrastructure.persistence.mapper.StandardDeliveriesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【standard_deliveries(订单发货记录表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class StandardDeliveriesServiceImpl extends ServiceImpl<StandardDeliveriesMapper, StandardDeliveriesPO>
    implements StandardDeliveriesService{

}




