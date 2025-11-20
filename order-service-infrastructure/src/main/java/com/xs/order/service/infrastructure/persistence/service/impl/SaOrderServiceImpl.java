package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaOrderPO;
import com.xs.order.service.infrastructure.persistence.service.SaOrderService;
import com.xs.order.service.infrastructure.persistence.mapper.SaOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_order(优惠的订单)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaOrderServiceImpl extends ServiceImpl<SaOrderMapper, SaOrderPO>
    implements SaOrderService{

}




