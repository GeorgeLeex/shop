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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`user_id`,`receiver`,`tel`,`province`,`city`,`county`,`address_detail`,`status`) values (1,2,'马克思','18234564456','河北省','石家庄市','无极县','哲学之家','1');

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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`author`,`price`,`description`,`word_num`,`page_num`,`image`,`publish_time`,`press_id`,`sale_status`,`inventory`,`type`,`status`) values (47,'哈利·波特与死亡圣器','【英】J·K·罗琳','58.34','还有四天，哈利就要迎来自己十七岁的生日，成为一名真正的魔法师。然而，他不得不提前离开女贞路 4号，永远离开这个他曾经生活了将近十七年的地方。\r\n凤凰社的成员精心谋划了秘密转移哈利的计划，以防哈利遭到伏地魔及其追随者食死徒的袭击。然而，可怕的意外还是发生了。\r\n与此同时，卷土重来的伏地魔已经染指霍格沃茨魔法学校，占领了魔法部，控制了半个魔法界，形势急转直下。\r\n哈利在罗恩、赫敏的陪伴下，不得不逃亡在外，隐形遁迹。为了完成校长邓布利多的遗命，一直在暗中寻机销毁伏地魔魂器的哈利，意外地获悉如果他们能够拥有传说中的三件死亡圣器，伏地魔将必死无疑。但是，伏地魔也早已开始了寻找长老魔杖的行动，并派出众多食死徒，布下天罗地网追捕哈利。\r\n哈利与伏地魔在魔法学校的禁林中相遇了，哈利倒在伏地魔抢先到手的一件致命的圣器之下。\r\n然而，伏地魔未能如愿以偿，魂器不可能战胜纯正的灵魂。哈利赢得了这场殊死较量的最终胜利。\r\n哈利·波特虽然差点身亡，最后神奇的死而复生，还和好朋友罗恩的妹妹金妮结婚生子，而之前传出最可能会死亡的罗恩和赫敏也逃过一劫，还幸福的走上红毯。 所有的秘密都已揭晓。19年后，哈利和金妮有三个孩子，赫敏和罗恩也结婚生子。两家人重聚九又四分之三站台，送孩子们去霍格沃茨',516000,607,'7c6134693ed74e1db76af88f5d22e1a6.jpg','2007-10-28',25,NULL,1999,18,'1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

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
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `order_detail` */

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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

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
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (36,'图书类别','0-2岁',NULL,3,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (37,'图书类别','3-6岁',NULL,3,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (38,'图书类别','7-10岁',NULL,3,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (39,'图书类别','11-14岁',NULL,3,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (40,'图书类别','外语',NULL,4,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (41,'图书类别','考试',NULL,4,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (42,'图书类别','中小学教辅',NULL,4,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (43,'图书类别','教材',NULL,4,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (44,'图书类别','历史',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (45,'图书类别','古籍',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (46,'图书类别','哲学/宗教',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (47,'图书类别','政治/军事',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (48,'图书类别','经济',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (49,'图书类别','管理',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (50,'图书类别','投资理财',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (51,'图书类别','社会科学',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (52,'图书类别','法律',NULL,5,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (53,'图书类别','保健/养生',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (54,'图书类别','旅游/地图',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (55,'图书类别','时尚/美妆',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (56,'图书类别','烹饪/美食',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (57,'图书类别','两性关系',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (58,'图书类别','孕产/胎教',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (59,'图书类别','育儿/早教',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (60,'图书类别','亲子/家教',NULL,6,'1');
insert  into `syscode`(`id`,`type`,`pro_name`,`pro_value`,`f_id`,`status`) values (61,'图书类别','家庭/家居',NULL,6,'1');

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
  `email` varchar(50) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (2,'georgelee','lee','4602e0a79ab2430e85c9c8f11892922f.jpg','123456','1','2018-05-20','21233@qq.com','18829382345','3');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (3,'牛顿','niudun','af85c0a6460849f8b7f10ad38f4440d7.jpg','123456','1','1977-06-07','niudun@niubi.com','13872389990','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (4,'切格瓦拉','qiegewala','7aadf8e5069b4e2c8503791a4d31f0d0.jpg','qgwl123','1','2014-01-27','qgwl@bdg.com','13756743577','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (5,'金克斯','jinx','994b3f93fb5c4260bcb0ac994cb5dc3a.jpg','jinxjinx','0','2013-01-01','jinx@lol.com','17638493021','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (6,'阿甘左','aganzo','ba931a753cad4ff9a7c1833d821113aa.jpg','agz123','1','1983-04-01','aganzo@dnf.com','17384940321','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (7,'赛利亚','sailia','ae4841b6e2d541c99ee600836549d296.jpg','sly123','0','2008-01-01','sailia@dnf.com','18345352356','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (8,'Taylor Swift','taylor','9a8431ab76fd40c6844915d2b0af55a3.jpg','tl1989','0','1989-12-24','taylor@tl.com','17344543543','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (9,'欧尔麦特','オルメット','9de610da16d449bd86cbf41e6646fece.jpg','THEPEACE','1','1982-03-21','orumeto@xiongying.com','18324353667','1');
insert  into `user`(`id`,`name`,`nick_name`,`img`,`password`,`gender`,`birth`,`email`,`tel`,`status`) values (11,'junk dog','joe','eadcccb7b43448bdbfbbe9abcf93e652.jpg','joe123','1','1993-04-07','joe@megalobox.com','18766666666','1');

/* Trigger structure for table `order_detail` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tg_bookQuantity` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tg_bookQuantity` BEFORE INSERT ON `order_detail` FOR EACH ROW begin
  declare num int;
  set num = (select inventory-new.quantity  from book where id = new.book_id);
  if num < 0 then
    signal sqlstate 'HY000' set message_text = '库存不足';
  end if;
  update book set inventory = num where id = new.book_id;
end */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
