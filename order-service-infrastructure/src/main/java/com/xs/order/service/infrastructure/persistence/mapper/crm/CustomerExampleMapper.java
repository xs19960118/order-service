package com.xs.order.service.infrastructure.persistence.mapper.crm;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xs.order.service.infrastructure.persistence.po.crm.CustomerExamplePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 客户 Mapper 示例（CRM 数据源）
 * 
 * 这是一个示例 Mapper，展示如何在 CRM 数据源中使用 MyBatis Plus
 *
 * @author xiangshang
 */
@Mapper
public interface CustomerExampleMapper extends BaseMapper<CustomerExamplePO> {

    /**
     * 根据手机号查询客户
     * 
     * @param mobile 手机号
     * @return 客户信息
     */
    @Select("SELECT * FROM patients WHERE mobile = #{mobile} AND deleted = 0")
    CustomerExamplePO findByMobile(String mobile);

    /**
     * 查询所有VIP客户
     * 
     * @return VIP客户列表
     */
    @Select("SELECT * FROM patients WHERE is_vip = 1 AND deleted = 0 ORDER BY created_at DESC")
    List<CustomerExamplePO> findVipCustomers();
}

