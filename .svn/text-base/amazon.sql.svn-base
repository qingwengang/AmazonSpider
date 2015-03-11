/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : amazon

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-10-08 21:09:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for camelcategory
-- ----------------------------
DROP TABLE IF EXISTS `camelcategory`;
CREATE TABLE `camelcategory` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(100) DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for camellisturl
-- ----------------------------
DROP TABLE IF EXISTS `camellisturl`;
CREATE TABLE `camellisturl` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) NOT NULL,
  `Url` varchar(200) DEFAULT NULL,
  `AmazonID` varchar(50) DEFAULT NULL,
  `ParentID` int(11) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  `LastUpdateTime` datetime DEFAULT NULL,
  `ImgSrc` varchar(100) DEFAULT NULL,
  `Category` varchar(200) DEFAULT NULL,
  `Property` varchar(200) DEFAULT NULL,
  `AmazonComment` longtext,
  `AmazonFlag` int(11) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21458 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ebaycategory
-- ----------------------------
DROP TABLE IF EXISTS `ebaycategory`;
CREATE TABLE `ebaycategory` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Url` varchar(500) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ebaydetail
-- ----------------------------
DROP TABLE IF EXISTS `ebaydetail`;
CREATE TABLE `ebaydetail` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `Url` varchar(500) DEFAULT NULL,
  `CommentUrl` varchar(500) DEFAULT NULL,
  `Comments` longtext,
  `Flag` int(11) DEFAULT NULL,
  `EbayID` varchar(50) DEFAULT NULL,
  `CommentUrlFlag` int(11) DEFAULT NULL,
  `CommentFlag` int(11) DEFAULT NULL,
  `CommentCount` int(11) DEFAULT NULL,
  `UserID` varchar(100) DEFAULT NULL,
  `IID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2451 DEFAULT CHARSET=utf8;

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
