package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.ConfigFieldDescPO;
import com.xs.order.service.infrastructure.persistence.service.ConfigFieldDescService;
import com.xs.order.service.infrastructure.persistence.mapper.ConfigFieldDescMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【config_field_desc(字段描述,多语言)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:28
*/
@Service
public class ConfigFieldDescServiceImpl extends ServiceImpl<ConfigFieldDescMapper, ConfigFieldDescPO>
    implements ConfigFieldDescService{

}




