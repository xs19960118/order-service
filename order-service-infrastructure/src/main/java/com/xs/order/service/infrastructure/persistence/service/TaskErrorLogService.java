package com.xs.order.service.infrastructure.persistence.service;

import com.xs.order.service.infrastructure.persistence.po.TaskErrorLogPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xiangshang
* @description 针对表【task_error_log(kafka task处理失败记录)】的数据库操作Service
* @createDate 2025-11-19 18:34:34
*/
public interface TaskErrorLogService extends IService<TaskErrorLogPO> {

}
