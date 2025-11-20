package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.UsersPO;
import com.xs.order.service.infrastructure.persistence.service.UsersService;
import com.xs.order.service.infrastructure.persistence.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【users(用户表)】的数据库操作Service实现
* @createDate 2025-11-19 18:34:35
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersPO>
    implements UsersService{

}




