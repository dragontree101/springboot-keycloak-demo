CREATE DATABASE demo;
USE demo;

CREATE TABLE `family_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL,
  `age` smallint(6) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;