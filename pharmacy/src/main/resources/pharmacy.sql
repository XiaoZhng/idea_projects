/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : pharmacy

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 30/12/2022 13:11:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drugs
-- ----------------------------
DROP TABLE IF EXISTS `drugs`;
CREATE TABLE `drugs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `drugsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `factory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂家',
  `specifications` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品单位',
  `price` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '药品单价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugs
-- ----------------------------
INSERT INTO `drugs` VALUES (2, '念慈庵', '222', '222', '222', '222.20');
INSERT INTO `drugs` VALUES (3, '999感冒灵', '南宁市', '50g/包', '南宁市', '29.9');
INSERT INTO `drugs` VALUES (4, '胶囊', '北京市', '5g/片', '克', '10');
INSERT INTO `drugs` VALUES (5, '西瓜霜', '桂林市', '15g/瓶', '克', '12.9');
INSERT INTO `drugs` VALUES (8, '板蓝根', '广州市', '10克/包', '克', '28');
INSERT INTO `drugs` VALUES (9, '布洛芬缓释胶囊', '广州市', '5g/片', '克', '49.9');

-- ----------------------------
-- Table structure for drugstock
-- ----------------------------
DROP TABLE IF EXISTS `drugstock`;
CREATE TABLE `drugstock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `drugs_id` int(11) NULL DEFAULT NULL COMMENT '药品id',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugstock
-- ----------------------------
INSERT INTO `drugstock` VALUES (1, 1, 10);
INSERT INTO `drugstock` VALUES (2, 2, 20);
INSERT INTO `drugstock` VALUES (3, 3, 10);
INSERT INTO `drugstock` VALUES (4, 4, 6);
INSERT INTO `drugstock` VALUES (5, 5, 27);
INSERT INTO `drugstock` VALUES (8, 8, 45);
INSERT INTO `drugstock` VALUES (9, 9, 33);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `enable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin', '管理层', '0');
INSERT INTO `user` VALUES (2, 'jack', 'jack', 'jacck', '销售部', '0');
INSERT INTO `user` VALUES (3, 'lucy', '321', '露西', '管理层', '1');
INSERT INTO `user` VALUES (4, 'tom', '123456', '汤姆', '销售部', '1');

SET FOREIGN_KEY_CHECKS = 1;
