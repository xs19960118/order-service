package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ConsumerErrorLogPO;
import com.xs.order.service.infrastructure.persistence.service.ConsumerErrorLogService;
import com.xs.order.service.infrastructure.persistence.mapper.ConsumerErrorLogMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【consumer_error_log(消费失败记录)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:29
*/
@Service
public class ConsumerErrorLogServiceImpl extends ServiceImpl<ConsumerErrorLogMapper, ConsumerErrorLogPO>
    implements ConsumerErrorLogService{

}




