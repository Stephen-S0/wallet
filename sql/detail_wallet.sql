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
