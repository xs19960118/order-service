package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaActivityOrderPO;
import com.xs.order.service.infrastructure.persistence.service.SaActivityOrderService;
import com.xs.order.service.infrastructure.persistence.mapper.SaActivityOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_activity_order(活动管理, 订单匹配规则)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaActivityOrderServiceImpl extends ServiceImpl<SaActivityOrderMapper, SaActivityOrderPO>
    implements SaActivityOrderService{

}




