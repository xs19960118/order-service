package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.SaCodePO;
import com.xs.order.service.infrastructure.persistence.service.SaCodeService;
import com.xs.order.service.infrastructure.persistence.mapper.SaCodeMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【sa_code(生成编码用)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:32
*/
@Service
public class SaCodeServiceImpl extends ServiceImpl<SaCodeMapper, SaCodePO>
    implements SaCodeService{

}




