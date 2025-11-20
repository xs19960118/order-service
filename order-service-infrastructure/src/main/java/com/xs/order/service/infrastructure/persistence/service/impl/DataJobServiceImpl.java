package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.DataJobPO;
import com.xs.order.service.infrastructure.persistence.service.DataJobService;
import com.xs.order.service.infrastructure.persistence.mapper.DataJobMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【data_job】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class DataJobServiceImpl extends ServiceImpl<DataJobMapper, DataJobPO>
    implements DataJobService{

}




