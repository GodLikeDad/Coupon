# ************************************************************
# Sequel Pro SQL dump
# Version 5224
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 8.0.16)
# Database: dshop
# Generation Time: 2019-12-17 09:14:39 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_coupon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_coupon`;

CREATE TABLE `t_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
  `code` varchar(128) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'code 优惠券码',
  `pic_url` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'pic_url 优惠券图',
  `achieve_amount` int(11) NOT NULL DEFAULT '0' COMMENT 'achieve_amount 达到满减资格金额',
  `reduce_amount` int(11) NOT NULL DEFAULT '0' COMMENT 'reduce_amount 所减金额',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT 'stock 库存，当库存为0不可取',
  `title` varchar(128) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'title 优惠券名称',
  `status` varchar(1) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT 'status 状态，为0可用，否则不可用',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time 日期',
  `start_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'start_time 生效开始时间',
  `end_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'end_time 生效结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='t_coupon 优惠券表';

LOCK TABLES `t_coupon` WRITE;
/*!40000 ALTER TABLE `t_coupon` DISABLE KEYS */;

INSERT INTO `t_coupon` (`id`, `code`, `pic_url`, `achieve_amount`, `reduce_amount`, `stock`, `title`, `status`, `create_time`, `start_time`, `end_time`)
VALUES
	(1,'123456','/1.png',100,20,1000,'满100减20','0','2019-12-17 12:00:00','2019-12-01 12:00:00','2020-12-17 12:00:00'),
	(2,'123465','/2.png',200,50,2000,'满200减50','0','2019-12-17 12:00:01','2019-12-16 12:00:00','2012-12-17 12:00:00'),
	(3,'21456','/3.png',300,80,3000,'满300减80','0','2019-12-17 12:00:00','2019-12-16 12:00:00','2020-12-17 12:00:00');

/*!40000 ALTER TABLE `t_coupon` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '账号',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '地址',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` char(11) DEFAULT NULL COMMENT '电话号码',
  `point` int(11) DEFAULT NULL COMMENT '积分值',
  `remark` varchar(50) NOT NULL DEFAULT '',
  `tel_phone` char(11) NOT NULL DEFAULT '' COMMENT '备份电话',
  `username` varchar(15) NOT NULL DEFAULT '' COMMENT '⽤户昵称',
  `zip_code` varchar(6) NOT NULL DEFAULT '' COMMENT '邮政编码',
  `balance` bigint(20) DEFAULT NULL COMMENT '账户⾦额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='⽤户基础信息表';

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`id`, `account`, `address`, `password`, `phone`, `point`, `remark`, `tel_phone`, `username`, `zip_code`, `balance`)
VALUES
	(1,'maifeng','四川省','123','176',100,'测试用户','176','DreamCat','61000',100000),
	(2,'xiaofeng','河南省','321','176',200,'测试用户','176','CatDream','64000',10000);

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user_coupon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_coupon`;

CREATE TABLE `t_user_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
  `user_coupon_code` varchar(128) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'user_coupon_code 用户优惠券码',
  `pic_url` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'pic_url 优惠券图',
  `coupon_id` int(11) NOT NULL DEFAULT '0' COMMENT 'coupon_id t_coupon表的虚拟外键',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT 'user_id 所领取用户id',
  `order_id` int(11) NOT NULL DEFAULT '0' COMMENT 'order_id 对应t_order表外键',
  `status` varchar(1) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT 'status 状态，为0可用，否则不可用',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time 日期',
  `start_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'start_time 生效开始时间',
  `end_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'end_time 生效结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='t_user_coupon 用户优惠券表';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
