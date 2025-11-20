package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaActivityAuthPO;
import com.xs.order.service.infrastructure.persistence.service.SaActivityAuthService;
import com.xs.order.service.infrastructure.persistence.mapper.SaActivityAuthMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_activity_auth(可以看到活动的销售或机构等的白名单)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaActivityAuthServiceImpl extends ServiceImpl<SaActivityAuthMapper, SaActivityAuthPO>
    implements SaActivityAuthService{

}




