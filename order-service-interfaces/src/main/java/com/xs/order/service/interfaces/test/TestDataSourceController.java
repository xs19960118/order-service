package com.xs.order.service.interfaces.test;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.order.service.interfaces.dto.vo.MySQLDataSourceCheckVO;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 多数据源测试 Controller
 * 用于测试三个数据源的连接状态
 * <p>
 * 使用 @Resource 注解进行依赖注入（JSR-250 标准，Java 原生注解）
 *
 * @author xiangshang
 */
@Slf4j
@Tag(name = "数据源测试", description = "多数据源连接测试接口")
@RestController
@RequestMapping("/test/datasource")
public class TestDataSourceController {

    /**
     * Boss 数据源（主）
     */
    @Resource(name = "bossDataSource")
    private DataSource bossDataSource;

    /**
     * CRM 数据源
     */
    @Resource(name = "crmDataSource")
    private DataSource crmDataSource;

    /**
     * Report 数据源
     */
    @Resource(name = "reportDataSource")
    private DataSource reportDataSource;

    /**
     * 检查所有数据源连接状态
     *
     * @return 数据源连接状态
     */
    @ApiOperationSupport(author = "xs", order = 1)
    @Operation(summary = "检查MySQL数据源连接", description = "检查 Boss、CRM、Report 三个Mysql数据源的连接状态")
    @GetMapping("/check")
    public HttpResponseEntity<Set<MySQLDataSourceCheckVO>> checkDataSources() {
        Map<String, Object> result = new HashMap<>();

        Set<MySQLDataSourceCheckVO> mysqlConnInfoSet = new HashSet<>();

        // 检查 Boss 数据源
        mysqlConnInfoSet.add(checkConnection(bossDataSource, "Boss"));

        // 检查 CRM 数据源
        mysqlConnInfoSet.add(checkConnection(crmDataSource, "CRM"));

        // 检查 Report 数据源
        mysqlConnInfoSet.add(checkConnection(reportDataSource, "Report"));

        return HttpResponseEntity.ok(mysqlConnInfoSet);
    }


    /**
     * 获取 Boss 数据源信息
     *
     * @return Boss 数据源信息
     */
    @ApiOperationSupport(author = "xs", order = 2)
    @Operation(summary = "Boss 数据源信息", description = "获取 Boss 数据源的详细信息")
    @GetMapping("/boss")
    public HttpResponseEntity<MySQLDataSourceCheckVO> getBossDataSourceInfo() {
        return HttpResponseEntity.ok(checkConnection(bossDataSource, "Boss"));
    }

    /**
     * 获取 CRM 数据源信息
     *
     * @return CRM 数据源信息
     */
    @ApiOperationSupport(author = "xs", order = 3)
    @Operation(summary = "CRM 数据源信息", description = "获取 CRM 数据源的详细信息")
    @GetMapping("/crm")
    public HttpResponseEntity<MySQLDataSourceCheckVO> getCrmDataSourceInfo() {
        return HttpResponseEntity.ok(checkConnection(crmDataSource, "CRM"));
    }

    /**
     * 获取 Report 数据源信息
     *
     * @return Report 数据源信息
     */
    @ApiOperationSupport(author = "xs", order = 4)
    @Operation(summary = "Report 数据源信息", description = "获取 Report 数据源的详细信息")
    @GetMapping("/report")
    public HttpResponseEntity<MySQLDataSourceCheckVO> getReportDataSourceInfo() {
        return HttpResponseEntity.ok(checkConnection(reportDataSource, "Report"));
    }

    /**
     * 检查单个数据源连接
     *
     * @param dataSource 数据源
     * @param name       数据源名称
     * @return 连接状态信息
     */
    private MySQLDataSourceCheckVO checkConnection(DataSource dataSource, String name) {
        MySQLDataSourceCheckVO vo = new MySQLDataSourceCheckVO();
        vo.setSourceName(name);

        try (Connection conn = dataSource.getConnection()) {
            vo.setStatus("Connected");
            vo.setUrl(conn.getMetaData().getURL());
            vo.setUsername(conn.getMetaData().getUserName());
            vo.setDatabase(conn.getCatalog());
            vo.setDriver(conn.getMetaData().getDriverName());
            vo.setDriverVersion(conn.getMetaData().getDriverVersion());

            log.info("{} 数据源连接成功: {}", name, conn.getMetaData().getURL());
        } catch (Exception e) {
            vo.setStatus("Failed");
            vo.setErrMsg(e.getMessage());
            log.error("{} 数据源连接失败", name, e);
        }

        return vo;
    }
}

