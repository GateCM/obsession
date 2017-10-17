/*
Navicat MySQL Data Transfer

Source Server         : 阿里数据库
Source Server Version : 50715
Source Host           : rm-uf64f9ej2d3ib59b6o.mysql.rds.aliyuncs.com:3306
Source Database       : my_test

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-10-17 17:43:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_identity
-- ----------------------------
DROP TABLE IF EXISTS `sys_identity`;
CREATE TABLE `sys_identity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `name` varchar(32) DEFAULT NULL COMMENT '角色身份名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色身份类型',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商户身份角色表';

-- ----------------------------
-- Records of sys_identity
-- ----------------------------

-- ----------------------------
-- Table structure for sys_identity_model
-- ----------------------------
DROP TABLE IF EXISTS `sys_identity_model`;
CREATE TABLE `sys_identity_model` (
  `identity_id` bigint(20) unsigned NOT NULL COMMENT '商户身份ID',
  `model_id` bigint(20) unsigned NOT NULL COMMENT '模型ID',
  PRIMARY KEY (`identity_id`,`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户身份模型映射表';

-- ----------------------------
-- Records of sys_identity_model
-- ----------------------------

-- ----------------------------
-- Table structure for sys_identity_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_identity_permission`;
CREATE TABLE `sys_identity_permission` (
  `identity_id` bigint(20) unsigned NOT NULL COMMENT '商户身份ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户身份权限映射表';

-- ----------------------------
-- Records of sys_identity_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_model
-- ----------------------------
DROP TABLE IF EXISTS `sys_model`;
CREATE TABLE `sys_model` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `name` varchar(255) NOT NULL COMMENT '模型名称',
  `type` varchar(255) NOT NULL COMMENT '模型类型',
  `style` varchar(255) DEFAULT NULL COMMENT '模型样式',
  `order` tinyint(255) unsigned NOT NULL DEFAULT '1' COMMENT '排序，升序排列',
  `show_name` varchar(255) NOT NULL COMMENT '模型显示名称',
  `is_has_son` tinyint(4) unsigned NOT NULL COMMENT '是否有子节点',
  `parent_model_id` bigint(20) unsigned DEFAULT NULL COMMENT '父节点id',
  `link_url` varchar(255) DEFAULT NULL COMMENT '模型对应跳转url',
  `is_new_blank` tinyint(4) unsigned DEFAULT NULL COMMENT '是否开启新页面',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模型表';

-- ----------------------------
-- Records of sys_model
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for uc_member
-- ----------------------------
DROP TABLE IF EXISTS `uc_member`;
CREATE TABLE `uc_member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  `salt` varchar(255) DEFAULT NULL,
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商户信息表';

-- ----------------------------
-- Records of uc_member
-- ----------------------------

-- ----------------------------
-- Table structure for uc_member_identity
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_identity`;
CREATE TABLE `uc_member_identity` (
  `member_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `identity_id` bigint(20) DEFAULT NULL COMMENT '商户身份ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户身份映射表';

-- ----------------------------
-- Records of uc_member_identity
-- ----------------------------
