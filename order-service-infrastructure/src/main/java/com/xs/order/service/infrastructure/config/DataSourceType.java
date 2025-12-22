package com.xs.order.service.infrastructure.config;

/**
 * 数据源类型枚举
 * 用于标识和管理多个数据源
 *
 * @author xiangshang
 */
public enum DataSourceType {
    
    /**
     * Boss 数据库（主数据源）
     * 用于订单服务的主要业务数据
     */
    BOSS("boss", "Boss数据库"),
    
    /**
     * CRM 数据库
     * 用于客户关系管理相关数据
     */
    CRM("crm", "CRM数据库"),
    
    /**
     * Report 数据库
     * 用于报表统计相关数据
     */
    REPORT("report", "Report数据库");

    /**
     * 数据源标识
     */
    private final String code;

    /**
     * 数据源描述
     */
    private final String description;

    DataSourceType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 根据 code 获取数据源类型
     *
     * @param code 数据源标识
     * @return 数据源类型
     */
    public static DataSourceType fromCode(String code) {
        for (DataSourceType type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown data source type: " + code);
    }
}

