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

 Date: 27/07/2020 20:14:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for opreate
-- ----------------------------
DROP TABLE IF EXISTS `opreate`;
CREATE TABLE `opreate`  (
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of opreate
-- ----------------------------
INSERT INTO `opreate` VALUES ('add');
INSERT INTO `opreate` VALUES ('delete');
INSERT INTO `opreate` VALUES ('get');
INSERT INTO `opreate` VALUES ('update');

SET FOREIGN_KEY_CHECKS = 1;
