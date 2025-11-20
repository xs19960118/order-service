package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.MigrationsPO;
import com.xs.order.service.infrastructure.persistence.service.MigrationsService;
import com.xs.order.service.infrastructure.persistence.mapper.MigrationsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【migrations】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class MigrationsServiceImpl extends ServiceImpl<MigrationsMapper, MigrationsPO>
    implements MigrationsService{

}




