package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.DmsProductPO;
import com.xs.order.service.infrastructure.persistence.service.DmsProductService;
import com.xs.order.service.infrastructure.persistence.mapper.DmsProductMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【dms_product】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class DmsProductServiceImpl extends ServiceImpl<DmsProductMapper, DmsProductPO>
    implements DmsProductService{

}




