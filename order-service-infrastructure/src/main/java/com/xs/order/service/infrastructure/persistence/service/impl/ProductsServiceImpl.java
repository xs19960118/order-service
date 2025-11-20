package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ProductsPO;
import com.xs.order.service.infrastructure.persistence.service.ProductsService;
import com.xs.order.service.infrastructure.persistence.mapper.ProductsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【products(主数据-产品表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, ProductsPO>
    implements ProductsService{

}




