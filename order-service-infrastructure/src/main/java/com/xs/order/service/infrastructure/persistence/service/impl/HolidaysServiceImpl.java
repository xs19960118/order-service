package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.HolidaysPO;
import com.xs.order.service.infrastructure.persistence.service.HolidaysService;
import com.xs.order.service.infrastructure.persistence.mapper.HolidaysMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【holidays(节假日表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class HolidaysServiceImpl extends ServiceImpl<HolidaysMapper, HolidaysPO>
    implements HolidaysService{

}




