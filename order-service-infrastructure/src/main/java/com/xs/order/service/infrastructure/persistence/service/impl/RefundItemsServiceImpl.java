package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.RefundItemsPO;
import com.xs.order.service.infrastructure.persistence.service.RefundItemsService;
import com.xs.order.service.infrastructure.persistence.mapper.RefundItemsMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【refund_items(退费单明细表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:31
*/
@Service
public class RefundItemsServiceImpl extends ServiceImpl<RefundItemsMapper, RefundItemsPO>
    implements RefundItemsService{

}




