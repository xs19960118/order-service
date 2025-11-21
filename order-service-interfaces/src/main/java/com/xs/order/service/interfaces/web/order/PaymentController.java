package com.xs.order.service.interfaces.web.order;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangshang
 */
@Slf4j
@Tag(name = "订单-支付/退款", description = "订单支付、退款等相关接口")
@RestController
@RequestMapping("/orders/payments")
@RequiredArgsConstructor
public class PaymentController {


    @GetMapping("/pay")
    public String payOrder() {
        return "支付订单";
    }
}
