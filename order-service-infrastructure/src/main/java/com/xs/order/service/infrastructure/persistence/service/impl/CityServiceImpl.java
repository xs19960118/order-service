package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.CityPO;
import com.xs.order.service.infrastructure.persistence.service.CityService;
import com.xs.order.service.infrastructure.persistence.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【city】的数据库操作Service实现
* @createDate 2025-11-19 18:34:28
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, CityPO>
    implements CityService{

}




