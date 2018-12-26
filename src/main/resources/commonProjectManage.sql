/*
 数据库文件
 Navicat Premium Data Transfer

 Source Server         : Ali_Mysql_5.5
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 47.93.31.98
 Source Database       : commonProject

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : utf-8

 Date: 12/26/2018 20:46:38 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
	`id` varchar(32) NOT NULL COMMENT '用户ID',
	`login_id` varchar(32) NOT NULL COMMENT '登录账户',
	`pass_word` varchar(32) NOT NULL COMMENT '登录密码',
	`user_name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
	`user_sex` varchar(4) DEFAULT NULL COMMENT '用户性别',
	`user_address` varchar(32) DEFAULT NULL COMMENT '用户联系地址',
	`user_cellphone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT COMMENT='' CHECKSUM=0 DELAY_KEY_WRITE=0;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('11111', 'supervons', 'supervons', '测试', '男', '北京', '176xxxxxxxx');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;