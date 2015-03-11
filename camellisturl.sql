/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : amazon

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-09-19 18:13:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for camellisturl
-- ----------------------------
DROP TABLE IF EXISTS `camellisturl`;
CREATE TABLE `camellisturl` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) DEFAULT NULL,
  `Url` varchar(200) DEFAULT NULL,
  `AmazonID` varchar(50) DEFAULT NULL,
  `ParentID` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `LastUpdateTime` datetime DEFAULT NULL,
  `ImgSrc` varchar(100) DEFAULT NULL,
  `Category` varchar(200) DEFAULT NULL,
  `Property` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `index_Category` (`Category`),
  KEY `index_camelUrlAmazonID` (`AmazonID`)
) ENGINE=InnoDB AUTO_INCREMENT=1872 DEFAULT CHARSET=utf8;
