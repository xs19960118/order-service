package com.xs.order.service.infrastructure.persistence.mapper.report;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xs.order.service.infrastructure.persistence.po.report.OrderReportExamplePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 订单报表 Mapper 示例（Report 数据源）
 * 
 * 这是一个示例 Mapper，展示如何在 Report 数据源中使用 MyBatis Plus
 *
 * @author xiangshang
 */
@Mapper
public interface OrderReportExampleMapper extends BaseMapper<OrderReportExamplePO> {

    /**
     * 查询指定日期的订单统计
     * 
     * @param reportDate 报表日期
     * @return 订单统计信息
     */
    @Select("SELECT * FROM order_daily_report WHERE report_date = #{reportDate}")
    OrderReportExamplePO findByDate(LocalDate reportDate);

    /**
     * 查询指定日期范围的订单统计
     * 
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 订单统计列表
     */
    @Select("SELECT * FROM order_daily_report WHERE report_date BETWEEN #{startDate} AND #{endDate} ORDER BY report_date DESC")
    List<OrderReportExamplePO> findByDateRange(LocalDate startDate, LocalDate endDate);
}

