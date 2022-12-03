业务背景：电商业务中，需要给电商app设计一个用户钱包，用户可以往钱包中充值，购买商品时用户可以使用钱包中的钱消费，商品申请退款成功后钱会退回钱包中，用户也可以申请提现把钱提到银行卡中

用程序实现如下api接口
```bash
1. 查询用户钱包余额
2. 用户消费100元的接口
3. 用户退款20元接口
4. 查询用户钱包金额变动明细的接口
```

### api接口

1、查询用户钱包余额

```
GET请求
http://127.0.0.1:8080/wallet/balance?userId=1
```

![image-20221203143153350](https://img-blog.csdnimg.cn/3f6638764c0b41e1ab0c7441b2b63382.png)

2、用户消费100元的接口

```
POST请求
http://127.0.0.1:8080/wallet/consume
userId=1&consume=100
```

![image-20221203143409864](https://img-blog.csdnimg.cn/dfd1b5b21ae24caf85afa08f18a97f9f.png)

3、用户退款20元接口

```
POST请求
http://127.0.0.1:8080/wallet/refund
userId=1&refund=20
```

![image-20221203143728883](https://img-blog.csdnimg.cn/61449496a78c445397e4ca8f4aaae30d.png)

4、查询用户钱包金额变动明细的接口

```
GET请求
http://127.0.0.1:8080/wallet/detail?userId=1
```

![image-20221203144020704](https://img-blog.csdnimg.cn/98a8c287e5734c8abdadb30a4dc80ef5.png)

### 二、建语句

user_wallet 用户钱包表

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : allforone

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 03/12/2022 11:48:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `user_wallet`;
CREATE TABLE `user_wallet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户id',
  `user_card` varchar(32) DEFAULT NULL COMMENT '用户银行卡号\n',
  `user_balance` double DEFAULT NULL COMMENT '用户余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建用户时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_wallet
-- ----------------------------
BEGIN;
INSERT INTO `user_wallet` (`id`, `user_id`, `user_card`, `user_balance`, `create_time`) VALUES (1, 1, '1', 100, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

```

detail_wallet 用户钱包明细表

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : allforone

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 03/12/2022 14:42:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for detail_wallet
-- ----------------------------
DROP TABLE IF EXISTS `detail_wallet`;
CREATE TABLE `detail_wallet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户id',
  `before_balance` double DEFAULT NULL COMMENT '变更后余额',
  `after_balance` double DEFAULT NULL COMMENT '变更前余额',
  `change_time` datetime DEFAULT NULL COMMENT '变更时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of detail_wallet
-- ----------------------------
BEGIN;
INSERT INTO `detail_wallet` (`id`, `user_id`, `before_balance`, `after_balance`, `change_time`) VALUES (75, 1, 100, 0, '2022-12-03 06:39:04');
INSERT INTO `detail_wallet` (`id`, `user_id`, `before_balance`, `after_balance`, `change_time`) VALUES (76, 1, 0, 20, '2022-12-03 06:39:15');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

```

