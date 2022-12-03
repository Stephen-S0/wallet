package com.yl.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * detailWalletEntity
 *
 * @author stephen
 * @version 0.1
 * 2022/12/3 01:39
 **/
@Data
public class DetailWalletEntity implements Serializable {
    private Integer userId;
    private Double beforeBalance;
    private Double afterBalance;
    private Date changeTime;
}
