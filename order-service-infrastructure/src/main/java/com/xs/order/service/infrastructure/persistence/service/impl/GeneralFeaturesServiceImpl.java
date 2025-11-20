package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.GeneralFeaturesPO;
import com.xs.order.service.infrastructure.persistence.service.GeneralFeaturesService;
import com.xs.order.service.infrastructure.persistence.mapper.GeneralFeaturesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【general_features(多功能功能扩展表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class GeneralFeaturesServiceImpl extends ServiceImpl<GeneralFeaturesMapper, GeneralFeaturesPO>
    implements GeneralFeaturesService{

}




