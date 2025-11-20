package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.CountryPO;
import com.xs.order.service.infrastructure.persistence.service.CountryService;
import com.xs.order.service.infrastructure.persistence.mapper.CountryMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【country】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, CountryPO>
    implements CountryService{

}




