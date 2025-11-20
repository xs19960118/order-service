package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.RefundsPO;
import com.xs.order.service.infrastructure.persistence.service.RefundsService;
import com.xs.order.service.infrastructure.persistence.mapper.RefundsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【refunds(退费单)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class RefundsServiceImpl extends ServiceImpl<RefundsMapper, RefundsPO>
    implements RefundsService{

}




