package com.yl.wallet.controller;

import com.google.gson.Gson;
import com.yl.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;


    /**
     * 查询用户钱包余额
     *
     * @param userId
     * @return
     */
    @GetMapping("/balance")
    public Double getBalance(@RequestParam Integer userId) {
        return userWalletService.getBalance(userId);
    }

    /**
     * 用户消费接口
     *
     * @param userId
     * @param consume
     * @return
     */
    @PostMapping("/consume")
    public String userConsume(@RequestParam Integer userId, @RequestParam Double consume) {
        return userWalletService.userConsume(userId, consume);
    }

    /**
     * 用户退款接口
     *
     * @param userId
     * @param refund
     * @return
     */
    @PostMapping("/refund")
    public String userRefund(@RequestParam Integer userId, @RequestParam Double refund) {
        return userWalletService.userRefund(userId, refund);
    }

    /**
     * 查询用户余额变动接口
     *
     * @param userId
     * @return
     */
    @GetMapping("/detail")
    public String getWalletCounsumeDetail(@RequestParam Integer userId) {
        return new Gson().toJson(userWalletService.getWalletDetailed(userId));
    }

}
