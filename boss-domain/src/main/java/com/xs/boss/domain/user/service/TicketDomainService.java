package com.xs.boss.domain.user.service;

import com.xs.boss.domain.user.model.TicketInfo;

/**
 * @author xiangshang
 */
public interface TicketDomainService {

    TicketInfo validateAndGetTicketInfo(TicketInfo ticketInfo);
}
