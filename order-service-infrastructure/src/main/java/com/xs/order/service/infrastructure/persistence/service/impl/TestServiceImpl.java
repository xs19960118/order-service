package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.TestPO;
import com.xs.order.service.infrastructure.persistence.service.TestService;
import com.xs.order.service.infrastructure.persistence.mapper.TestMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【test】的数据库操作Service实现
* @createDate 2025-11-19 18:34:34
*/
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestPO>
    implements TestService{

}




