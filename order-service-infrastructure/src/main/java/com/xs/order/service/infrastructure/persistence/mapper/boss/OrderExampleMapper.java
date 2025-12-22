package com.xs.order.service.infrastructure.persistence.mapper.boss;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xs.order.service.infrastructure.persistence.po.boss.OrderExamplePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 订单 Mapper 示例（Boss 数据源）
 * 
 * 这是一个示例 Mapper，展示如何在 Boss 数据源中使用 MyBatis Plus
 *
 * @author xiangshang
 */
@Mapper
public interface OrderExampleMapper extends BaseMapper<OrderExamplePO> {

    /**
     * 根据订单号查询订单
     * 
     * @param orderNo 订单号
     * @return 订单信息
     */
    @Select("SELECT * FROM orders WHERE order_no = #{orderNo} AND deleted = 0")
    OrderExamplePO findByOrderNo(String orderNo);

    /**
     * 查询用户的所有订单
     * 
     * @param userId 用户ID
     * @return 订单列表
     */
    @Select("SELECT * FROM orders WHERE user_id = #{userId} AND deleted = 0 ORDER BY created_at DESC")
    List<OrderExamplePO> findByUserId(Long userId);
}

