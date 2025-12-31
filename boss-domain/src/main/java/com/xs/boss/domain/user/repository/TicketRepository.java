package com.xs.boss.domain.user.repository;

import com.xs.boss.domain.user.model.TicketInfo;

import java.util.Optional;

/**
 * Ticket 仓储接口
 * <p>
 * 领域层 - 定义 Ticket 相关的数据访问接口
 *
 * @author xiangshang
 */
public interface TicketRepository {

    /**
     * 根据 ticket 获取 Ticket 信息
     *
     * @param ticket ticket 值
     * @return Ticket 信息，如果不存在返回 Optional.empty()
     */
    Optional<TicketInfo> findByTicket(String ticket);

    /**
     * 验证 ticket 是否有效
     *
     * @param ticket ticket 值
     * @param serverUrl 服务端地址
     * @return 是否有效
     */
    boolean validateTicket(String ticket, String serverUrl);
}

