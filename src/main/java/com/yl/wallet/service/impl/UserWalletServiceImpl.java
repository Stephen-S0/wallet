package com.yl.wallet.service.impl;

import com.yl.wallet.entity.DetailWalletEntity;
import com.yl.wallet.entity.UserWalletEntity;
import com.yl.wallet.mapper.UserWalletMapper;
import com.yl.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    private UserWalletMapper userWalletMapper;
    @Autowired
    private BankService bankService;

    /**
     * 查询用户余额
     *
     * @param userId
     * @return
     */
    @Override
    public Double getBalance(Integer userId) {
        //直接查询返回
        return userWalletMapper.getUserWallet(userId).getUserBalance();
    }

    /**
     * 用户消费
     *
     * @param userId
     * @param consumes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String userConsume(Integer userId, Double consumes) {
        UserWalletEntity getWallet = userWalletMapper.getUserWallet(userId);
        // 校验判断
        if (getWallet == null) {
            return "用户不存在。";
        }
        Double userBalance = getWallet.getUserBalance();
        Double count = userBalance - consumes;
        if (consumes <= 0) {
            return "请输入正确金额。";
        }
        if (count < 0) {
            return "用户余额不足。";
        }
        // 用户消费
        Integer res = userWalletMapper.userConsumes(userId, consumes);
        if (res == 1) {
            // 模拟调用三方银行service消费
            String result = bankService.consume(getWallet.getUserCard(), consumes);
            userWalletMapper.addcChangeRecord(userId, userBalance, count);
            // 模拟获取三方服务接口调用情况状态码决定是否回滚事务
            if (!result.equals("消费成功")) {
                // 消费事务回滚
                throw new RuntimeException("消费失败");
            }
        } else {
            throw new RuntimeException("消费失败");
        }
        return "消费成功";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String userRefund(Integer userId, Double refund) {
        // 校验判断
        UserWalletEntity getWallet = userWalletMapper.getUserWallet(userId);
        if (getWallet == null) {
            return "用户不存在。";
        }
        Double userBalance = getWallet.getUserBalance();
        Double count = userBalance + refund;
        if (refund <= 0) {
            return "请输入正确金额。";
        }

        // 用户退款
        Integer res = userWalletMapper.userRefund(userId, refund);
        if (res == 1) {
            // 模拟调用三方银行service消费
            String result = bankService.refund(getWallet.getUserCard(), refund);
            // 添加变更明细信息
            userWalletMapper.addcChangeRecord(userId, userBalance, count);
            // 获取三方服务接口调用情况状态码决定是否回滚事务
            if (!result.equals("退款成功")) {
                // 退款事务回滚
                throw new RuntimeException("退款失败");
            }
        } else {
            throw new RuntimeException("退款失败");
        }
        return "退款成功";
    }

    /**
     * 查询用户钱包金额变动明细
     *
     * @param userId
     * @return
     */
    @Override
    public List<DetailWalletEntity> getWalletDetailed(Integer userId) {
        return userWalletMapper.getWalletDetailed(userId);
    }
}
