package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ProductPricesPO;
import com.xs.order.service.infrastructure.persistence.service.ProductPricesService;
import com.xs.order.service.infrastructure.persistence.mapper.ProductPricesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【product_prices(商品价格表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class ProductPricesServiceImpl extends ServiceImpl<ProductPricesMapper, ProductPricesPO>
    implements ProductPricesService{

}




