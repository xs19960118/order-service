package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaMessagePO;
import com.xs.order.service.infrastructure.persistence.service.SaMessageService;
import com.xs.order.service.infrastructure.persistence.mapper.SaMessageMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_message(活动消息表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaMessageServiceImpl extends ServiceImpl<SaMessageMapper, SaMessagePO>
    implements SaMessageService{

}




