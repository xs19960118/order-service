package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaActivityGradientPO;
import com.xs.order.service.infrastructure.persistence.service.SaActivityGradientService;
import com.xs.order.service.infrastructure.persistence.mapper.SaActivityGradientMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_activity_gradient(梯度规则表,某段时间内,上一步绑定的病例数量, 当前第x个病例,价格是多少)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaActivityGradientServiceImpl extends ServiceImpl<SaActivityGradientMapper, SaActivityGradientPO>
    implements SaActivityGradientService{

}




