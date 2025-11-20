package com.xs.order.service.infrastructure.persistence.service;

import com.xs.order.service.infrastructure.persistence.po.SaActivityGradientPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xiangshang
* @description 针对表【sa_activity_gradient(梯度规则表,某段时间内,上一步绑定的病例数量, 当前第x个病例,价格是多少)】的数据库操作Service
* @createDate 2025-11-19 18:34:32
*/
public interface SaActivityGradientService extends IService<SaActivityGradientPO> {

}
