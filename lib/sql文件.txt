CREATE TABLE `Blog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL DEFAULT '',
  `authorId` int(10)  NULL  ,
   `state` varchar(10) NOT NULL DEFAULT '',
   `featured` tinyint(1)  NOT NULL DEFAULT 0,
   `style` varchar(20)  NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;