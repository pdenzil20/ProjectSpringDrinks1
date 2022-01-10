drop table if exists drink cascade;
CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alcoholpercentage` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int DEFAULT NULL,
  `taste` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
