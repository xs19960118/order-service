package com.xs.order.service.interfaces.web.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源测试 Controller
 * 用于测试三个数据源的连接状态
 *
 * @author xiangshang
 */
@Slf4j
@Tag(name = "数据源测试", description = "多数据源连接测试接口")
@RestController
@RequestMapping("/test/datasource")
@RequiredArgsConstructor
public class DataSourceTestController {

    @Qualifier("bossDataSource")
    private final DataSource bossDataSource;

    @Qualifier("crmDataSource")
    private final DataSource crmDataSource;

    @Qualifier("reportDataSource")
    private final DataSource reportDataSource;

    /**
     * 检查所有数据源连接状态
     *
     * @return 数据源连接状态
     */
    @Operation(summary = "检查数据源连接", description = "检查 Boss、CRM、Report 三个数据源的连接状态")
    @GetMapping("/check")
    public Map<String, Object> checkDataSources() {
        Map<String, Object> result = new HashMap<>();
        
        // 检查 Boss 数据源
        result.put("boss", checkConnection(bossDataSource, "Boss"));
        
        // 检查 CRM 数据源
        result.put("crm", checkConnection(crmDataSource, "CRM"));
        
        // 检查 Report 数据源
        result.put("report", checkConnection(reportDataSource, "Report"));
        
        return result;
    }

    /**
     * 检查单个数据源连接
     *
     * @param dataSource 数据源
     * @param name 数据源名称
     * @return 连接状态信息
     */
    private Map<String, Object> checkConnection(DataSource dataSource, String name) {
        Map<String, Object> info = new HashMap<>();
        try (Connection conn = dataSource.getConnection()) {
            info.put("status", "✅ Connected");
            info.put("url", conn.getMetaData().getURL());
            info.put("username", conn.getMetaData().getUserName());
            info.put("database", conn.getCatalog());
            info.put("driver", conn.getMetaData().getDriverName());
            info.put("driverVersion", conn.getMetaData().getDriverVersion());
            
            log.info("{} 数据源连接成功: {}", name, conn.getMetaData().getURL());
        } catch (Exception e) {
            info.put("status", "❌ Failed");
            info.put("error", e.getMessage());
            log.error("{} 数据源连接失败", name, e);
        }
        return info;
    }

    /**
     * 获取 Boss 数据源信息
     *
     * @return Boss 数据源信息
     */
    @Operation(summary = "Boss 数据源信息", description = "获取 Boss 数据源的详细信息")
    @GetMapping("/boss")
    public Map<String, Object> getBossDataSourceInfo() {
        return checkConnection(bossDataSource, "Boss");
    }

    /**
     * 获取 CRM 数据源信息
     *
     * @return CRM 数据源信息
     */
    @Operation(summary = "CRM 数据源信息", description = "获取 CRM 数据源的详细信息")
    @GetMapping("/crm")
    public Map<String, Object> getCrmDataSourceInfo() {
        return checkConnection(crmDataSource, "CRM");
    }

    /**
     * 获取 Report 数据源信息
     *
     * @return Report 数据源信息
     */
    @Operation(summary = "Report 数据源信息", description = "获取 Report 数据源的详细信息")
    @GetMapping("/report")
    public Map<String, Object> getReportDataSourceInfo() {
        return checkConnection(reportDataSource, "Report");
    }
}

