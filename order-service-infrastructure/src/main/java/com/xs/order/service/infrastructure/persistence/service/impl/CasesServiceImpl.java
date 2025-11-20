package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.CasesPO;
import com.xs.order.service.infrastructure.persistence.service.CasesService;
import com.xs.order.service.infrastructure.persistence.mapper.CasesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【cases(主数据-病例)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:28
*/
@Service
public class CasesServiceImpl extends ServiceImpl<CasesMapper, CasesPO>
    implements CasesService{

}




