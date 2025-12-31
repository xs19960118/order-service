package com.xs.boss.domain.user.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author xiangshang
 */
@Builder
@Getter
public class TicketInfo {

    private final String username;

    private String ticket;

    private String serverUrl;
}
