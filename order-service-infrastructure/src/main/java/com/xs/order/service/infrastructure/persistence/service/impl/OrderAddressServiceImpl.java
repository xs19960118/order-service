package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.OrderAddressPO;
import com.xs.order.service.infrastructure.persistence.service.OrderAddressService;
import com.xs.order.service.infrastructure.persistence.mapper.OrderAddressMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【order_address】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class OrderAddressServiceImpl extends ServiceImpl<OrderAddressMapper, OrderAddressPO>
    implements OrderAddressService{

}




