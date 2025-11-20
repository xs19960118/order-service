package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ShippingAddressPO;
import com.xs.order.service.infrastructure.persistence.service.ShippingAddressService;
import com.xs.order.service.infrastructure.persistence.mapper.ShippingAddressMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【shipping_address】的数据库操作Service实现
* @createDate 2025-11-19 18:34:33
*/
@Service
public class ShippingAddressServiceImpl extends ServiceImpl<ShippingAddressMapper, ShippingAddressPO>
    implements ShippingAddressService{

}




