# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.1.35-community
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2013-07-11 22:16:26
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for ood
CREATE DATABASE IF NOT EXISTS `ood` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ood`;


# Dumping structure for table ood.booth
CREATE TABLE IF NOT EXISTS `booth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `boothStatus` int(11) DEFAULT NULL,
  `builder` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `saloon` int(11) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK59923B64F81060F` (`showPlace`),
  KEY `FK59923B6123645E9` (`owner`),
  CONSTRAINT `FK59923B6123645E9` FOREIGN KEY (`owner`) REFERENCES `user` (`id`),
  CONSTRAINT `FK59923B64F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.boothlog
CREATE TABLE IF NOT EXISTS `boothlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `booth` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7803E3AE27849047` (`booth`),
  CONSTRAINT `FK7803E3AE27849047` FOREIGN KEY (`booth`) REFERENCES `booth` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.file
CREATE TABLE IF NOT EXISTS `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `newsEntity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2FF57CFB2250B4` (`newsEntity`),
  CONSTRAINT `FK2FF57CFB2250B4` FOREIGN KEY (`newsEntity`) REFERENCES `news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `isPublic` bit(1) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.penalty
CREATE TABLE IF NOT EXISTS `penalty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `lastStatus` int(11) DEFAULT NULL,
  `booth` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD74F388927849047` (`booth`),
  CONSTRAINT `FKD74F388927849047` FOREIGN KEY (`booth`) REFERENCES `booth` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.peoplereport
CREATE TABLE IF NOT EXISTS `peoplereport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `peopleReportStatus` int(11) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK29410CA34F81060F` (`showPlace`),
  CONSTRAINT `FK29410CA34F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.phonenumber
CREATE TABLE IF NOT EXISTS `phonenumber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `phoneNumberStatus` int(11) DEFAULT NULL,
  `newsEntity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB8E4BA57FB2250B4` (`newsEntity`),
  CONSTRAINT `FKB8E4BA57FB2250B4` FOREIGN KEY (`newsEntity`) REFERENCES `news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.poll
CREATE TABLE IF NOT EXISTS `poll` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3497BF4F81060F` (`showPlace`),
  CONSTRAINT `FK3497BF4F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.poststuff
CREATE TABLE IF NOT EXISTS `poststuff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `destination` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `postStuffStatus` int(11) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.process
CREATE TABLE IF NOT EXISTS `process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `processStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.processlog
CREATE TABLE IF NOT EXISTS `processlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1929C2554F81060F` (`showPlace`),
  CONSTRAINT `FK1929C2554F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.property
CREATE TABLE IF NOT EXISTS `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `propertyStatus` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.propertylog
CREATE TABLE IF NOT EXISTS `propertylog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50EB012F4F81060F` (`showPlace`),
  CONSTRAINT `FK50EB012F4F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.questionentity
CREATE TABLE IF NOT EXISTS `questionentity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `resultBad` int(11) DEFAULT NULL,
  `resultGood` int(11) DEFAULT NULL,
  `resultNotBad` int(11) DEFAULT NULL,
  `resultVeryGood` int(11) DEFAULT NULL,
  `poll` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK638607698F58CFE9` (`poll`),
  CONSTRAINT `FK638607698F58CFE9` FOREIGN KEY (`poll`) REFERENCES `poll` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.receipt
CREATE TABLE IF NOT EXISTS `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `receiptStatus` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK408272384F81060F` (`showPlace`),
  CONSTRAINT `FK408272384F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.request
CREATE TABLE IF NOT EXISTS `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `requestStatus` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.showplace
CREATE TABLE IF NOT EXISTS `showplace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `implementationStatus` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.showplace_process
CREATE TABLE IF NOT EXISTS `showplace_process` (
  `showPlace_id` int(11) NOT NULL,
  `processes_id` int(11) NOT NULL,
  `processes` int(11) NOT NULL,
  PRIMARY KEY (`showPlace_id`,`processes`),
  KEY `FK77DB7F3A5B804FC7` (`processes_id`),
  KEY `FK77DB7F3AF8326735` (`showPlace_id`),
  CONSTRAINT `FK77DB7F3AF8326735` FOREIGN KEY (`showPlace_id`) REFERENCES `showplace` (`id`),
  CONSTRAINT `FK77DB7F3A5B804FC7` FOREIGN KEY (`processes_id`) REFERENCES `process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.showplace_property
CREATE TABLE IF NOT EXISTS `showplace_property` (
  `showPlace_id` int(11) NOT NULL,
  `properties_id` int(11) NOT NULL,
  `properties` int(11) NOT NULL,
  PRIMARY KEY (`showPlace_id`,`properties`),
  KEY `FK8825FA8A2B17F567` (`properties_id`),
  KEY `FK8825FA8AF8326735` (`showPlace_id`),
  CONSTRAINT `FK8825FA8AF8326735` FOREIGN KEY (`showPlace_id`) REFERENCES `showplace` (`id`),
  CONSTRAINT `FK8825FA8A2B17F567` FOREIGN KEY (`properties_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.storestuff
CREATE TABLE IF NOT EXISTS `storestuff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastDateStatusChange` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `storeStuffStatus` int(11) DEFAULT NULL,
  `showPlace` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK364A89934F81060F` (`showPlace`),
  CONSTRAINT `FK364A89934F81060F` FOREIGN KEY (`showPlace`) REFERENCES `showplace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.validationrule
CREATE TABLE IF NOT EXISTS `validationrule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table ood.validationrule_property
CREATE TABLE IF NOT EXISTS `validationrule_property` (
  `validationRule_id` int(11) NOT NULL,
  `property2_id` int(11) NOT NULL,
  `property2` int(11) NOT NULL,
  `property1_id` int(11) NOT NULL,
  `property1` int(11) NOT NULL,
  PRIMARY KEY (`validationRule_id`,`property1`),
  KEY `FK4E2D2BDF4F3CA4FE` (`property1_id`),
  KEY `FK4E2D2BDF4331DBA5` (`validationRule_id`),
  KEY `FK4E2D2BDF4F3D195D` (`property2_id`),
  CONSTRAINT `FK4E2D2BDF4F3D195D` FOREIGN KEY (`property2_id`) REFERENCES `property` (`id`),
  CONSTRAINT `FK4E2D2BDF4331DBA5` FOREIGN KEY (`validationRule_id`) REFERENCES `validationrule` (`id`),
  CONSTRAINT `FK4E2D2BDF4F3CA4FE` FOREIGN KEY (`property1_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
