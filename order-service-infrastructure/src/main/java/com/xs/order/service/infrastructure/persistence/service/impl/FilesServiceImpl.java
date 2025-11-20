package com.xs.order.service.infrastructure.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xs.order.service.infrastructure.persistence.po.FilesPO;
import com.xs.order.service.infrastructure.persistence.service.FilesService;
import com.xs.order.service.infrastructure.persistence.mapper.FilesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiangshang
* @description 针对表【files】的数据库操作Service实现
* @createDate 2025-11-19 18:34:30
*/
@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, FilesPO>
    implements FilesService{

}




