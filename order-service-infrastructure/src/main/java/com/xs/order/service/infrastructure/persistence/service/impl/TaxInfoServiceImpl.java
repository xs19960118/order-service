package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.TaxInfoPO;
import com.xs.order.service.infrastructure.persistence.service.TaxInfoService;
import com.xs.order.service.infrastructure.persistence.mapper.TaxInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【tax_info(税率相关配置表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class TaxInfoServiceImpl extends ServiceImpl<TaxInfoMapper, TaxInfoPO>
    implements TaxInfoService{

}




