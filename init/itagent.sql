/*
Navicat MySQL Data Transfer

Source Server         : itagent
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : itagent

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2012-11-12 21:17:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `problem_tb`
-- ----------------------------
DROP TABLE IF EXISTS `problem_tb`;
CREATE TABLE `problem_tb` (
  `PROBLEM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(20000) DEFAULT NULL,
  `T1` int(11) DEFAULT '-1',
  `T2` int(11) DEFAULT '-1',
  `T3` int(11) DEFAULT '-1',
  `T4` int(11) DEFAULT '-1',
  `T5` int(11) DEFAULT '-1',
  `T6` int(11) DEFAULT '-1',
  `T7` int(11) DEFAULT '-1',
  `T8` int(11) DEFAULT '-1',
  `T9` int(11) DEFAULT '-1',
  PRIMARY KEY (`PROBLEM_ID`),
  UNIQUE KEY `ID_UNIQUE` (`PROBLEM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of problem_tb
-- ----------------------------
INSERT INTO `problem_tb` VALUES ('1', '这是第一个问题内容？', '999999', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1');
INSERT INTO `problem_tb` VALUES ('2', '这是第二个问题内容？', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1');

-- ----------------------------
-- Table structure for `score_tb`
-- ----------------------------
DROP TABLE IF EXISTS `score_tb`;
CREATE TABLE `score_tb` (
  `TEAM_ID` varchar(45) NOT NULL,
  `TEAM_SCORE` int(11) NOT NULL DEFAULT '0',
  `TEAM_NAME` varchar(100) DEFAULT NULL,
  `TEAM_MEMBERS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TEAM_ID`),
  UNIQUE KEY `TEAM_ID_UNIQUE` (`TEAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score_tb
-- ----------------------------
INSERT INTO `score_tb` VALUES ('T1', '80', 'TEAM-ONE', 'JACK');
INSERT INTO `score_tb` VALUES ('T2', '0', 'TEAM-TWO', 'MIKE');
INSERT INTO `score_tb` VALUES ('T3', '0', 'TEAM-THREE', 'ROSE');
