package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ProductComboPO;
import com.xs.order.service.infrastructure.persistence.service.ProductComboService;
import com.xs.order.service.infrastructure.persistence.mapper.ProductComboMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【product_combo(商品套餐表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class ProductComboServiceImpl extends ServiceImpl<ProductComboMapper, ProductComboPO>
    implements ProductComboService{

}




