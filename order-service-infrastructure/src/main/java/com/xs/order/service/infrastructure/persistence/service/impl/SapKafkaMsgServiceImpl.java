package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SapKafkaMsgPO;
import com.xs.order.service.infrastructure.persistence.service.SapKafkaMsgService;
import com.xs.order.service.infrastructure.persistence.mapper.SapKafkaMsgMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sap_kafka_msg(SAP消息通知)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:33
*/
@Service
public class SapKafkaMsgServiceImpl extends ServiceImpl<SapKafkaMsgMapper, SapKafkaMsgPO>
    implements SapKafkaMsgService{

}




