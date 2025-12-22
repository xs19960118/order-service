package com.xs.order.service.interfaces.dto.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangshang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "数据库监控响应")
public class MySQLDataSourceCheckVO {

    @Schema(description = "数据源名称", example = "boss", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sourceName;

    @Schema(description = "数据库名称", example = "order_db")
    private String database;

    @Schema(description = "数据库版本", example = "MySQL 8.0")
    private String version;

    @Schema(description = "数据库驱动", example = "com.mysql.cj.jdbc.Driver")
    private String driver;

    @Schema(description = "数据库驱动版本", example = "8.0.33")
    private String driverVersion;

    @Schema(description = "数据库连接地址", example = "jdbc:mysql://localhost:3306/order_db")
    private String url;

    @Schema(description = "数据库连接状态", example = "Connected", allowableValues = {"Connected", "Failed"})
    private String status;

    @Schema(description = "数据库用户名", example = "root")
    private String username;

    @Schema(description = "错误信息")
    private String errMsg;

}
