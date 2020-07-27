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

 Date: 27/07/2020 20:15:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_operate
-- ----------------------------
DROP TABLE IF EXISTS `role_operate`;
CREATE TABLE `role_operate`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `operate` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_operate
-- ----------------------------
INSERT INTO `role_operate` VALUES (1, 'boss', 'add');
INSERT INTO `role_operate` VALUES (2, 'boss', 'update');
INSERT INTO `role_operate` VALUES (3, 'boss', 'get');
INSERT INTO `role_operate` VALUES (4, 'boss', 'delete');
INSERT INTO `role_operate` VALUES (5, 'manager', 'add');
INSERT INTO `role_operate` VALUES (6, 'manager', 'update');
INSERT INTO `role_operate` VALUES (7, 'manager', 'get');
INSERT INTO `role_operate` VALUES (8, 'employee', 'add');
INSERT INTO `role_operate` VALUES (9, 'employee', 'get');

SET FOREIGN_KEY_CHECKS = 1;
