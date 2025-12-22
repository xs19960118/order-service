package com.xs.boss.interfaces.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangshang
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "boss is up !!!! ";
    }
}

