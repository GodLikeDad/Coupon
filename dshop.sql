# ************************************************************
# Sequel Pro SQL dump
# Version 5224
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 8.0.16)
# Database: dshop
# Generation Time: 2019-12-13 08:42:00 +0000
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='t_coupon 优惠券表';



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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='t_user_coupon 用户优惠券表';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
