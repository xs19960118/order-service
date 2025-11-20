package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.TaxDetailPO;
import com.xs.order.service.infrastructure.persistence.service.TaxDetailService;
import com.xs.order.service.infrastructure.persistence.mapper.TaxDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【tax_detail】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class TaxDetailServiceImpl extends ServiceImpl<TaxDetailMapper, TaxDetailPO>
    implements TaxDetailService{

}




