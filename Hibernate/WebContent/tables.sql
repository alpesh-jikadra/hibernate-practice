CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(64) DEFAULT NULL,
  `last_name` varchar(64) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(256) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `state` varchar(64) DEFAULT NULL,
  `zip` varchar(64) DEFAULT NULL,
  `country` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(16) DEFAULT NULL,
  `value` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_key` (`key`)
) ENGINE=InnoDB;