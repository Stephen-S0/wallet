package com.yl.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * UserWalletEntity
 *
 * @author stephen
 * @version 0.1
 * 2022/12/3 01:38
 **/
@Data
public class UserWalletEntity implements Serializable {
    private Integer userId;
    private String userCard;
    private Double userBalance;
    private Date createTime;

}
