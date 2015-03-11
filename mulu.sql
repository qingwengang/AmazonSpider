/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : amazon

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-09-19 18:13:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mulu
-- ----------------------------
DROP TABLE IF EXISTS `mulu`;
CREATE TABLE `mulu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Url` varchar(100) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  `LastUpdateTime` datetime DEFAULT NULL,
  `TypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;
