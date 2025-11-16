package com.xs.order.service.interfaces.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class OrderController {

    @GetMapping("/orders/ping")
    public String ping() {
        return "OK";
    }
}
