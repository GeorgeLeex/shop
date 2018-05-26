/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.20 : Database - shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `receiver` varchar(20) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  `province` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `county` varchar(25) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (1,1,'11111','11111111111','河北省','邢台市','临城县','峨眉山旅游6666号店','1');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (2,2,'11111','11111111111','山西省','晋城市','沁水县','1','1');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (3,2,'11111','11111111111','吉林省','辽源市','龙山区','111','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (4,2,'11111','11111111111','福建省','南平市','邵武市','111','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (5,2,'11111','11111111111','湖南省','湘潭市','雨湖区','1','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (6,2,'11111','11111111111','湖南省','长沙市','岳麓区','222','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (7,2,'雷德黑手','13332435111','福建省','南平市','光泽县','``111','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (8,2,'11111','11111111111','江苏省','徐州市','云龙区','1111','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (9,2,'11111','11111111111','安徽省','阜阳市','阜南县','1','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (10,2,'11111','11111111111','河南省','鹤壁市','淇滨区','1','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (11,2,'11111','11111111111','湖北省','宜昌市','伍家岗区','1111','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (12,2,'金凯瑞','13144144114','浙江省','杭州市','上城区','芙蓉路1353号','1');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (13,2,'蓝蓝路','13829320734','安徽省','芜湖市','芜湖县','dasima','1');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (14,2,'zero','11111111111','内蒙古自治区','包头市','东河区','ddawda','0');
insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (15,1,'亚里士多德','13224432345','安徽省','黄山市','休宁县','23534543','1');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `description` text,
  `word_num` int(11) DEFAULT NULL,
  `page_num` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `press_id` int(11) DEFAULT NULL,
  `sale_status` char(1) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (1,'解忧杂货铺','宫崎英高','55.32','传火之旅',60000,429,'fa13e5a4-49d8-4ace-9944-785764355c0e.jpg','2018-05-01',26,NULL,998,23,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (2,'小王子','亚里士多德','89.23','必读经典',200000,100,'83e42f6f-5eef-4dac-bb55-9bfdfe1350be.jpg','1970-01-01',26,NULL,25,8,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (3,'世界简史',NULL,'39.67',NULL,NULL,NULL,'1526111611611.jpg',NULL,NULL,NULL,998,9,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (4,'追风筝的人',NULL,'34.12',NULL,NULL,NULL,'1526111672984.jpg',NULL,NULL,NULL,998,23,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (5,'哈利波特','【英】J·K·罗琳','120.34','<pre>《圣器》主要讲述了十七岁的哈利本应在霍格沃茨魔法学校继续最后一年的学业，但为了完成己故魔法学校前任校长邓布利多留给他消灭伏地魔的任务，哈利和好友面对伏地魔及其追随者食死徒的围追堵截，隐形循迹、历经艰险，最终销毁多个魂器并战胜伏地魔，取得魔法世界伟大胜利的故事。\r\n  \r\n还有四天，哈利就要迎来自己十七岁的生日，成为一名真正的魔法师。然而，他不得不提前离开女贞路 4号，永远离开这个他曾经生活了将近十七年的地方。\r\n凤凰社的成员精心谋划了秘密转移哈利的计划，以防哈利遭到伏地魔及其追随者食死徒的袭击。然而，可怕的意外还是发生了。\r\n与此同时，卷土重来的伏地魔已经染指霍格沃茨魔法学校，占领了魔法部，控制了半个魔法界，形势急转直下。\r\n哈利在罗恩、赫敏的陪伴下，不得不逃亡在外，隐形遁迹。为了完成校长邓布利多的遗命，一直在暗中寻机销毁伏地魔魂器的哈利，意外地获悉如果他们能够拥有传说中的三件死亡圣器，伏地魔将必死无疑。但是，伏地魔也早已开始了寻找长老魔杖的行动，并派出众多食死徒，布下天罗地网追捕哈利。\r\n哈利与伏地魔在魔法学校的禁林中相遇了，哈利倒在伏地魔抢先到手的一件致命的圣器之下。\r\n然而，伏地魔未能如愿以偿，魂器不可能战胜纯正的灵魂。哈利赢得了这场殊死较量的最终胜利。\r\n哈利·波特虽然差点身亡，最后神奇的死而复生，还和好朋友罗恩的妹妹金妮结婚生子，而之前传出最可能会死亡的罗恩和赫敏也逃过一劫，还幸福的走上红毯。 所有的秘密都已揭晓。19年后，哈利和金妮有三个孩子，赫敏和罗恩也结婚生子。两家人重聚九又四分之三站台，送孩子们去霍格沃茨。</pre>',516000,607,'1526111694760.jpg','2007-10-28',25,NULL,998,22,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (6,'围城',NULL,'56.34',NULL,NULL,NULL,'1526111726397.jpg',NULL,26,NULL,998,21,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (26,'解忧杂货铺','无名','55.32','解忧杂货铺',60000,429,'1526110988601.jpg','2018-05-02',25,NULL,998,7,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (27,'小王子',NULL,'89.23',NULL,NULL,NULL,'1526111611610.jpg',NULL,NULL,NULL,998,8,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (28,'世界简史',NULL,'39.67',NULL,NULL,NULL,'1526111611611.jpg',NULL,NULL,NULL,998,9,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (29,'追风筝的人',NULL,'34.12',NULL,NULL,NULL,'1526111672984.jpg',NULL,NULL,NULL,998,23,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (30,'哈利波特',NULL,'120.34',NULL,NULL,NULL,'1526111694760.jpg',NULL,NULL,NULL,998,22,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (31,'围城',NULL,'56.34',NULL,NULL,NULL,'1526111726397.jpg',NULL,NULL,NULL,998,21,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (33,'解忧杂货铺',NULL,'55.32',NULL,NULL,NULL,'1526110988601.jpg',NULL,NULL,NULL,998,7,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (34,'小王子',NULL,'89.23',NULL,NULL,NULL,'1526111611610.jpg',NULL,NULL,NULL,998,8,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (35,'世界简史',NULL,'39.67',NULL,NULL,NULL,'1526111611611.jpg',NULL,NULL,NULL,998,9,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (36,'追风筝的人',NULL,'34.12',NULL,NULL,NULL,'1526111672984.jpg',NULL,NULL,NULL,998,23,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (37,'哈利波特',NULL,'120.34',NULL,NULL,NULL,'1526111694760.jpg',NULL,NULL,NULL,998,22,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (38,'围城',NULL,'56.34',NULL,NULL,NULL,'1526111726397.jpg',NULL,NULL,NULL,998,21,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (39,'解忧杂货铺',NULL,'55.32',NULL,NULL,NULL,'1526110988601.jpg',NULL,NULL,NULL,998,7,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (40,'小王子',NULL,'89.23',NULL,NULL,NULL,'1526111611610.jpg',NULL,NULL,NULL,998,8,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (41,'世界简史',NULL,'39.67',NULL,NULL,NULL,'1526111611611.jpg',NULL,NULL,NULL,998,9,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (42,'追风筝的人',NULL,'34.12',NULL,NULL,NULL,'1526111672984.jpg',NULL,NULL,NULL,998,23,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (43,'哈利波特',NULL,'120.34',NULL,NULL,NULL,'1526111694760.jpg',NULL,NULL,NULL,998,22,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (44,'围城',NULL,'56.34',NULL,NULL,NULL,'1526111726397.jpg',NULL,NULL,NULL,998,21,'0');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (45,'我的免费隧道','盖聂','93.43','刺客王朝',300000,300,'52180dc82d5f44b9922063626b0a5420.jpg','2018-05-02',25,NULL,340,20,'1');
insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (46,'浮生若梦','不知名文人','54.32','人生不过一场梦',98733,2334,'fccf98bd-82b2-4c2d-9c28-9f9587752249.jpg','2018-05-24',26,NULL,33,14,'1');

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `cart_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`id`,`user_id`,`cart_id`,`book_id`,`quantity`,`status`) values (1,2,NULL,5,17,'0');
insert  into `cart`(`id`,`user_id`,`cart_id`,`book_id`,`quantity`,`status`) values (2,2,NULL,6,3,'0');
insert  into `cart`(`id`,`user_id`,`cart_id`,`book_id`,`quantity`,`status`) values (3,2,NULL,46,6,'0');
insert  into `cart`(`id`,`user_id`,`cart_id`,`book_id`,`quantity`,`status`) values (4,2,NULL,45,1,'0');
insert  into `cart`(`id`,`user_id`,`cart_id`,`book_id`,`quantity`,`status`) values (5,2,NULL,1,1,'1');
insert  into `cart`(`id`,`user_id`,`cart_id`,`book_id`,`quantity`,`status`) values (6,2,NULL,28,3,'0');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `uri` varchar(30) DEFAULT NULL,
  `class_name` varchar(30) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`name`,`uri`,`class_name`,`status`) values (1,'图书管理','/book/manage','fa fa-book','1');
insert  into `menu`(`id`,`name`,`uri`,`class_name`,`status`) values (2,'用户管理','/user/manage','fa fa-user','1');
insert  into `menu`(`id`,`name`,`uri`,`class_name`,`status`) values (3,'图书类别管理','/type/manage','fa fa-sort-amount-asc','1');
insert  into `menu`(`id`,`name`,`uri`,`class_name`,`status`) values (4,'出版社管理','/press/manage','fa fa-desktop','1');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(28) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `finish_time` datetime DEFAULT NULL,
  `pay_amount` decimal(13,2) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (1,'2018051312345678',NULL,'2018-05-13 00:00:00',NULL,'2018-05-17 00:00:00',NULL,NULL,NULL,NULL,'1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (2,'2018051312345679',NULL,'2018-05-01 00:00:00',NULL,'2018-05-04 00:00:00',NULL,NULL,NULL,NULL,'1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (3,'2018051312345680',NULL,'2018-04-04 00:00:00',NULL,'2018-05-16 00:00:00',NULL,NULL,NULL,NULL,'1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (6,'20180519055230',2,'2018-05-19 17:52:30',NULL,NULL,'409.70','11111','11111111111','山西省晋城市沁水县1','1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (7,'20180519061242',2,'2018-05-19 18:12:43',NULL,NULL,'409.70','11111','11111111111','山西省晋城市沁水县1','2');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (8,'20180519061654',2,'2018-05-19 18:16:54',NULL,NULL,'169.02','11111','11111111111','山西省晋城市沁水县1','2');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (9,'20180519061854',2,'2018-05-19 18:18:54',NULL,NULL,'240.68','11111','11111111111','山西省晋城市沁水县1','2');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (10,'20180519062142',2,'2018-05-19 18:21:43',NULL,'2018-05-25 06:16:14','409.70','11111','11111111111','山西省晋城市沁水县1','0');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (11,'20180519062302',2,'2018-05-19 18:23:02',NULL,NULL,'409.70','11111','11111111111','山西省晋城市沁水县1','1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (12,'20180519064254',2,'2018-05-19 18:42:55',NULL,NULL,'409.70','蓝蓝路','13829320734','安徽省芜湖市芜湖县dasima','1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (13,'20180519064545',2,'2018-05-19 18:45:45',NULL,NULL,'409.70','金凯瑞','13144144114','浙江省杭州市上城区芙蓉路1353号','1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (14,'20180519064833',2,'2018-05-19 18:48:33',NULL,NULL,'409.70','zero','11111111111','内蒙古自治区包头市东河区ddawda','1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (15,'20180525102602',2,'2018-05-25 10:26:03',NULL,NULL,'89.23','11111','11111111111','山西省晋城市沁水县1','1');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (16,'20180525104515',2,'2018-05-25 10:45:16',NULL,'2018-05-25 06:36:16','54.32','11111','11111111111','山西省晋城市沁水县1','2');
insert  into `order`(`id`,`order_no`,`user_id`,`create_time`,`pay_time`,`finish_time`,`pay_amount`,`receiver`,`tel`,`address`,`status`) values (17,'20180525021531',2,'2018-05-25 14:15:32',NULL,'2018-05-25 06:24:25','119.01','金凯瑞','13144144114','浙江省杭州市上城区芙蓉路1353号','0');

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `single_money` decimal(10,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `order_detail` */

insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (1,1,1,NULL,3,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (2,1,2,NULL,4,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (3,1,3,NULL,5,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (4,2,4,NULL,6,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (5,2,5,NULL,43,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (6,2,6,NULL,22,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (7,3,2,NULL,6,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (8,3,5,NULL,7,NULL,'1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (9,6,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (10,6,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (11,7,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (12,7,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (13,8,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (14,9,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (15,10,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (16,10,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (17,11,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (18,11,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (19,12,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (20,12,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (21,13,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (22,13,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (23,14,1,'120.34',2,'240.68','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (24,14,2,'56.34',3,'169.02','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (25,15,2,'89.23',1,'89.23','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (26,16,46,'54.32',1,'54.32','1');
insert  into `order_detail`(`id`,`order_id`,`book_id`,`single_money`,`quantity`,`total`,`status`) values (27,17,28,'39.67',3,'119.01','1');

/*Table structure for table `syscode` */

DROP TABLE IF EXISTS `syscode`;

CREATE TABLE `syscode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `pro_name` varchar(100) DEFAULT NULL,
  `pro_value` int(11) DEFAULT NULL,
  `f_id` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `syscode` */

insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (1,'图书类别','科学技术',1,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (2,'图书类别','文学艺术',2,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (3,'图书类别','童书',3,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (4,'图书类别','教育',4,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (5,'图书类别','人文社科',5,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (6,'图书类别','悦享生活',6,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (7,'图书类别','计算机',7,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (8,'图书类别','程序设计',8,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (9,'图书类别','办公软件',9,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (10,'图书类别','科普读物',10,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (11,'图书类别','医学',11,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (12,'图书类别','建筑',12,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (13,'图书类别','工业技术',13,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (14,'图书类别','自然科学',14,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (15,'图书类别','农业林业',15,1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (16,'图书类别','青春文学',16,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (17,'图书类别','动漫/幽默',17,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (18,'图书类别','小说',18,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (19,'图书类别','传记',19,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (20,'图书类别','成功/励志',20,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (21,'图书类别','文学',21,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (22,'图书类别','艺术',22,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (23,'图书类别','文化',23,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (24,'图书类别','心理学',24,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (25,'出版社','Bloomsbury',NULL,-1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (26,'出版社','上海晨光出版公司',NULL,-1,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (27,'图书类别','哲学',NULL,1,'0');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (28,'图书类别','王の哲学',NULL,2,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (29,'图书类别','计算机111',NULL,1,'0');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (30,'图书类别','王的哲学',NULL,2,'0');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (31,'出版社','哔哩哔哩出版社',NULL,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (32,'出版社','北方工业出版社',NULL,NULL,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (34,'出版社','联想扬天出版社',NULL,NULL,'1');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `nick_name` varchar(16) DEFAULT NULL,
  `img` varchar(60) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (1,'zhangsan','zs',NULL,'123456','0',NULL,'21233@qq.com','123453323','0');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (2,'georgelee','lee','4602e0a79ab2430e85c9c8f11892922f.jpg','123456','1','2018-05-20','21233@qq.com','18829382345','3');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (3,NULL,'wangwu',NULL,'123456',NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (4,NULL,'zhaoliu',NULL,'123456',NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (5,NULL,'damu',NULL,'123456',NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (7,NULL,'heiba',NULL,'123456',NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (8,NULL,'laojiu',NULL,'110120',NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (9,'佟大为','tongdawei',NULL,'123456',NULL,'2018-05-03','327648676@qq.com','18829382345','0');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (10,'佟大为','tongdawei',NULL,'123456',NULL,'2018-05-03','327648676@qq.com','18829382345','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (11,'切格瓦拉','budagon',NULL,'123456','',NULL,'','','3');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (12,'琼恩斯诺','johnsino',NULL,'jionsino','1','2018-05-01','jonhnsino@qq.com','12734849321','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (13,'北桥疯','bqf',NULL,'bqf123','1','2018-05-24','beiqiaofeng@163.com','18766666666','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (14,'林夕梦','linxm',NULL,'lxm123','0','2018-05-02','linxm@163.com','18237482394','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (15,'巫妖王','wyw',NULL,'wyw123','1','2018-05-20','wyw@outlook.com','18766666666','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (16,'南慕容','nanmurong',NULL,'nmr123','1','2018-05-02','nanmorong@163.com','13872389991','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (17,'zhangsan','zs',NULL,'123456','1',NULL,'21233@qq.com','123453323','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (18,'zhangsan','zs',NULL,'123456','1',NULL,'21233@qq.com','123453323','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
