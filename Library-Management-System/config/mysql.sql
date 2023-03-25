/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : sqlserver

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2019-05-08 21:32:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(16) NOT NULL,
  `pwd` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', 'root');
INSERT INTO `admin` VALUES ('2', 'ck', 'chengkai');
INSERT INTO `admin` VALUES ('3', 'txf', 'txf');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `author` varchar(16) NOT NULL,
  `publishing` varchar(16) NOT NULL,
  `isbn` char(13) NOT NULL,
  `count` int(10) unsigned NOT NULL,
  `remain` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '计算机网络', '谢希仁', '电子工业出版社', '9787121302954', '10', '10');
INSERT INTO `book` VALUES ('2', 'SqlServer2008数据库应用技术', '刘卫国、刘泽星', '人民邮电出版社', '9787115377302', '25', '24');
INSERT INTO `book` VALUES ('3', 'JavaEE企业级应用开发教程', '黑马程序员', '人民邮电出版社', '9787115461025', '17', '16');
INSERT INTO `book` VALUES ('4', 'Android应用开发教程', '钟元生、高成珍', '江西高校出版社', '9787549317066', '13', '12');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `reader_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  `borrow_time` datetime NOT NULL,
  `return_borrow` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `reader_id` (`reader_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`),
  CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('1', '1', '1', '2019-05-08 11:03:35', '1');
INSERT INTO `borrow` VALUES ('2', '2', '2', '2019-05-08 11:04:36', '0');
INSERT INTO `borrow` VALUES ('3', '1', '3', '2019-05-08 11:11:24', '0');
INSERT INTO `borrow` VALUES ('4', '1', '4', '2019-05-08 11:12:10', '0');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `gender` tinyint(3) unsigned NOT NULL,
  `year` int(10) unsigned NOT NULL,
  `id_card` char(18) NOT NULL,
  `tel` char(11) NOT NULL,
  `addr` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('1', 'ck', '1', '1998', '370811199805250000', '18807700000', '山东济宁');
INSERT INTO `reader` VALUES ('2', 'txf', '0', '1996', '451000000000000000', '18888888888', '广西玉林');
INSERT INTO `reader` VALUES ('3', 'zk', '1', '1995', '510000000000000000', '17700000000', '四川绵阳');
INSERT INTO `reader` VALUES ('4', 'hhd', '0', '1996', '310000000000000000', '11100000000', '福建漳州');
DROP TRIGGER IF EXISTS `book_borrow`;
DELIMITER ;;
CREATE TRIGGER `book_borrow` AFTER INSERT ON `borrow` FOR EACH ROW BEGIN
	UPDATE book
SET remain = remain - 1
WHERE
	id = new.book_id;


END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `book_return`;
DELIMITER ;;
CREATE TRIGGER `book_return` AFTER UPDATE ON `borrow` FOR EACH ROW BEGIN

IF (
	new.return_borrow != old.return_borrow
) THEN

IF (new.return_borrow = 1) THEN
	UPDATE book
SET remain = remain + 1
WHERE
	id = new.book_id;


END
IF;


IF (new.return_borrow = 0) THEN
	UPDATE book
SET remain = remain - 1
WHERE
	id = new.book_id;


END
IF;


END
IF;


END
;;
DELIMITER ;
