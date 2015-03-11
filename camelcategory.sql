/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : amazon

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-09-19 18:13:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for camelcategory
-- ----------------------------
DROP TABLE IF EXISTS `camelcategory`;
CREATE TABLE `camelcategory` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(200) DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3389 DEFAULT CHARSET=utf8;
