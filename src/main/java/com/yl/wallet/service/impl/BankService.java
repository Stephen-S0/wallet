package com.yl.wallet.service.impl;

import org.springframework.stereotype.Component;

/**
 * bankService
 * 模拟银行Service
 * @author stephen
 * @version 0.1
 * 2022/12/3 02:10
 **/

@Component
public class BankService {
    public String consume(String card,Double consume){
        return "消费成功";
    }

    public String refund(String card,Double consume){
        return "退款成功";
    }
}
