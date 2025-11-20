package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.CommonFlowLogPO;
import com.xs.order.service.infrastructure.persistence.service.CommonFlowLogService;
import com.xs.order.service.infrastructure.persistence.mapper.CommonFlowLogMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【common_flow_log(通用模型变更记录表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:28
*/
@Service
public class CommonFlowLogServiceImpl extends ServiceImpl<CommonFlowLogMapper, CommonFlowLogPO>
    implements CommonFlowLogService{

}




