/*
 Navicat MySQL Data Transfer

 Source Server         : 阿里云数据库
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 39.107.104.169:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 27/07/2020 20:15:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_url
-- ----------------------------
DROP TABLE IF EXISTS `role_url`;
CREATE TABLE `role_url`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `url` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_url
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
