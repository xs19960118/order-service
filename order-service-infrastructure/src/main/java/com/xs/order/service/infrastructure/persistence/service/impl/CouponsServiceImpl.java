package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.CouponsPO;
import com.xs.order.service.infrastructure.persistence.service.CouponsService;
import com.xs.order.service.infrastructure.persistence.mapper.CouponsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【coupons(优惠券)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class CouponsServiceImpl extends ServiceImpl<CouponsMapper, CouponsPO>
    implements CouponsService{

}




