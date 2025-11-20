package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.TaskErrorLogPO;
import com.xs.order.service.infrastructure.persistence.service.TaskErrorLogService;
import com.xs.order.service.infrastructure.persistence.mapper.TaskErrorLogMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【task_error_log(kafka task处理失败记录)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class TaskErrorLogServiceImpl extends ServiceImpl<TaskErrorLogMapper, TaskErrorLogPO>
    implements TaskErrorLogService{

}




