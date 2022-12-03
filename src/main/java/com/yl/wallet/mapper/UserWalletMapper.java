package com.yl.wallet.mapper;

import com.yl.wallet.entity.DetailWalletEntity;
import com.yl.wallet.entity.UserWalletEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * UserWalletMapper
 *
 * @author stephen
 * @version 0.1
 * 2022/12/3 01:09
 **/
@Mapper
public interface UserWalletMapper {
    /**
     * 查询用户钱包余额
     *
     * @param userId
     * @return
     */
    @Select("SELECT user_id, user_card, user_balance FROM user_wallet WHERE user_id = #{userId};")
    UserWalletEntity getUserWallet(@Param("userId") Integer userId);

    /**
     * 用户消费
     *
     * @param userId
     * @param consume
     * @return
     */
    @Update("UPDATE user_wallet SET user_balance = user_balance - #{consume} WHERE user_id = #{userId};")
    Integer userConsumes(@Param("userId") Integer userId, @Param("consume") Double consume);

    /**
     * 用户退款
     *
     * @param userId
     * @param refund
     * @return
     */
    @Update("UPDATE user_wallet SET user_balance = user_balance + #{refund} WHERE user_id = #{userId};")
    Integer userRefund(@Param("userId") Integer userId, @Param("refund") Double refund);

    /**
     * 查询用户钱包金额变动明细
     *
     * @param userId
     * @return
     */
    @Select("SELECT user_id, before_balance, after_balance, change_time FROM detail_wallet WHERE user_id = #{userId} ORDER BY change_time DESC;")
    List<DetailWalletEntity> getWalletDetailed(@Param("userId") Integer userId);

    /**
     * 添加变更明细
     *
     * @param userId
     * @param beforeBalance
     * @param afterBalance
     * @return
     */
    @Insert("INSERT INTO detail_wallet VALUES(null, #{userId}, #{beforeBalance}, #{afterBalance}, NOW())")
    Integer addcChangeRecord(@Param("userId") Integer userId, @Param("beforeBalance") Double beforeBalance, @Param("afterBalance") Double afterBalance);
}
