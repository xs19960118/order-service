package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaCasePO;
import com.xs.order.service.infrastructure.persistence.service.SaCaseService;
import com.xs.order.service.infrastructure.persistence.mapper.SaCaseMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_case(参与活动的病例)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaCaseServiceImpl extends ServiceImpl<SaCaseMapper, SaCasePO>
    implements SaCaseService{

}




