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
  `create_time` datetime DEFAULT NULL COMMENT '最后变更时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_wallet
-- ----------------------------
BEGIN;
INSERT INTO `user_wallet` (`id`, `user_id`, `user_card`, `user_balance`, `create_time`) VALUES (1, 1, '1', 2800, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
