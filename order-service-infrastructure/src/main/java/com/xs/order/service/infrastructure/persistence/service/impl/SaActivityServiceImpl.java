package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaActivityPO;
import com.xs.order.service.infrastructure.persistence.service.SaActivityService;
import com.xs.order.service.infrastructure.persistence.mapper.SaActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_activity(活动分类(sa: sales-activity))】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaActivityServiceImpl extends ServiceImpl<SaActivityMapper, SaActivityPO>
    implements SaActivityService{

}




