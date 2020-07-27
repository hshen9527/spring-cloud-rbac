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

 Date: 27/07/2020 20:14:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 'employee', '客户管理');
INSERT INTO `role_menu` VALUES (2, 'employee', '订单管理');
INSERT INTO `role_menu` VALUES (3, 'manager', '客户管理');
INSERT INTO `role_menu` VALUES (4, 'manager', '角色管理');
INSERT INTO `role_menu` VALUES (5, 'manager', '订单管理');
INSERT INTO `role_menu` VALUES (6, 'manager', '销售管理');
INSERT INTO `role_menu` VALUES (7, 'boss', '销售管理');
INSERT INTO `role_menu` VALUES (8, 'boss', '部门管理');
INSERT INTO `role_menu` VALUES (9, 'boss', '订单管理');
INSERT INTO `role_menu` VALUES (10, 'boss', '角色管理');
INSERT INTO `role_menu` VALUES (11, 'boss', '系统设置');
INSERT INTO `role_menu` VALUES (12, 'boss', '客户管理');

SET FOREIGN_KEY_CHECKS = 1;
