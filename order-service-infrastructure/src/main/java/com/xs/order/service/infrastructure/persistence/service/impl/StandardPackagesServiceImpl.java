package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.StandardPackagesPO;
import com.xs.order.service.infrastructure.persistence.service.StandardPackagesService;
import com.xs.order.service.infrastructure.persistence.mapper.StandardPackagesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【standard_packages(包裹表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class StandardPackagesServiceImpl extends ServiceImpl<StandardPackagesMapper, StandardPackagesPO>
    implements StandardPackagesService{

}




