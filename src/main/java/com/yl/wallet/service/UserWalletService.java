package com.yl.wallet.service;

import com.yl.wallet.entity.DetailWalletEntity;
import com.yl.wallet.entity.UserWalletEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface UserWalletService {
    // 查询用户余额
    Double getBalance(Integer userId);

    // 用户消费
    String userConsume(Integer userId, Double consume);

    // 用户退款
    String userRefund(Integer userId, Double refund);

    // 查询用户钱包金额变动明细
    List<DetailWalletEntity> getWalletDetailed(Integer userId);
}
