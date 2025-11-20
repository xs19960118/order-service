package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.FailedJobsPO;
import com.xs.order.service.infrastructure.persistence.service.FailedJobsService;
import com.xs.order.service.infrastructure.persistence.mapper.FailedJobsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【failed_jobs】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class FailedJobsServiceImpl extends ServiceImpl<FailedJobsMapper, FailedJobsPO>
    implements FailedJobsService{

}




