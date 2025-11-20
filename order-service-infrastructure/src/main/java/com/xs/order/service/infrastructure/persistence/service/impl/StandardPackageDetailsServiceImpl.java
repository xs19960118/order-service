package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.StandardPackageDetailsPO;
import com.xs.order.service.infrastructure.persistence.service.StandardPackageDetailsService;
import com.xs.order.service.infrastructure.persistence.mapper.StandardPackageDetailsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【standard_package_details(包裹明细加工表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class StandardPackageDetailsServiceImpl extends ServiceImpl<StandardPackageDetailsMapper, StandardPackageDetailsPO>
    implements StandardPackageDetailsService{

}




