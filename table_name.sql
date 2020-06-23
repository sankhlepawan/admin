-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `test`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10),(10);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_detail`
--

DROP TABLE IF EXISTS `item_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_detail` (
  `item_id` bigint(20) NOT NULL,
  `detail_id` bigint(20) NOT NULL,
  PRIMARY KEY (`item_id`,`detail_id`),
  KEY `FKnwlrl3ln0vji45jbbjbwmsfy6` (`detail_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_detail`
--

LOCK TABLES `item_detail` WRITE;
/*!40000 ALTER TABLE `item_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKacv47iqkxkb7oks87v5ab66tk` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (6,2),(9,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_address`
--

DROP TABLE IF EXISTS `wb_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_address` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `full_address` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_address`
--

LOCK TABLES `wb_address` WRITE;
/*!40000 ALTER TABLE `wb_address` DISABLE KEYS */;
INSERT INTO `wb_address` VALUES (1,NULL,NULL,'new','34.55,45.66','323443',NULL),(4,NULL,NULL,'new colony','34.55,45.44','343443',NULL),(7,NULL,NULL,'new colony','45.55,65.55','453441',NULL);
/*!40000 ALTER TABLE `wb_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_bio`
--

DROP TABLE IF EXISTS `wb_bio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_bio` (
  `id` bigint(20) NOT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `birth_time` varchar(255) DEFAULT NULL,
  `cast` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `complextion` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `create_on` datetime DEFAULT NULL,
  `current_work_location` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `eating_habits` varchar(255) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `father_occupation` varchar(255) DEFAULT NULL,
  `full_address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `gotra` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `manglik` bit(1) NOT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `mother_name` varchar(255) DEFAULT NULL,
  `mother_occupation` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `petlover` bit(1) NOT NULL,
  `primary_contact_number` varchar(255) DEFAULT NULL,
  `profile_pic` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `secondary_contact_number` varchar(255) DEFAULT NULL,
  `siblings` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `working` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_bio`
--

LOCK TABLES `wb_bio` WRITE;
/*!40000 ALTER TABLE `wb_bio` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_bio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_category`
--

DROP TABLE IF EXISTS `wb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_category` (
  `id` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `category_unit` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_category`
--

LOCK TABLES `wb_category` WRITE;
/*!40000 ALTER TABLE `wb_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_file`
--

DROP TABLE IF EXISTS `wb_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_file` (
  `id` int(11) NOT NULL,
  `bio_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `file_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc4uy7llrs5036i2hdy86bo65n` (`file_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_file`
--

LOCK TABLES `wb_file` WRITE;
/*!40000 ALTER TABLE `wb_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_item`
--

DROP TABLE IF EXISTS `wb_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_item` (
  `id` bigint(20) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `qwt` int(11) DEFAULT NULL,
  `sub_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK16eim23abipa5furk2te5gsw` (`sub_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_item`
--

LOCK TABLES `wb_item` WRITE;
/*!40000 ALTER TABLE `wb_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_item_detail`
--

DROP TABLE IF EXISTS `wb_item_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_item_detail` (
  `id` bigint(20) NOT NULL,
  `item_detail_name` varchar(255) DEFAULT NULL,
  `item_detail_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_item_detail`
--

LOCK TABLES `wb_item_detail` WRITE;
/*!40000 ALTER TABLE `wb_item_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_item_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_location`
--

DROP TABLE IF EXISTS `wb_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_location` (
  `id` double NOT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_location`
--

LOCK TABLES `wb_location` WRITE;
/*!40000 ALTER TABLE `wb_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_milk_collection`
--

DROP TABLE IF EXISTS `wb_milk_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_milk_collection` (
  `id` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `density` double DEFAULT NULL,
  `fat` double DEFAULT NULL,
  `lactose` double DEFAULT NULL,
  `protein` double DEFAULT NULL,
  `qwt` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `salts` double DEFAULT NULL,
  `snf` double DEFAULT NULL,
  `collection_status` varchar(255) DEFAULT NULL,
  `temp` double DEFAULT NULL,
  `test_mode` varchar(255) DEFAULT NULL,
  `animal_type` varchar(255) DEFAULT NULL,
  `water` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_milk_collection`
--

LOCK TABLES `wb_milk_collection` WRITE;
/*!40000 ALTER TABLE `wb_milk_collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_milk_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_order`
--

DROP TABLE IF EXISTS `wb_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_order` (
  `orderid` bigint(20) NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `is_fulfilled` bit(1) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `is_paid` bit(1) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `payment_id` tinyblob,
  `ship_date` datetime DEFAULT NULL,
  `shipping_address` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `is_whtsapp_number` bit(1) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_order`
--

LOCK TABLES `wb_order` WRITE;
/*!40000 ALTER TABLE `wb_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_order_item`
--

DROP TABLE IF EXISTS `wb_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_order_item` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKta7x7ibmmj36boffw6tsnyqg5` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_order_item`
--

LOCK TABLES `wb_order_item` WRITE;
/*!40000 ALTER TABLE `wb_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_payment`
--

DROP TABLE IF EXISTS `wb_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_payment` (
  `paymentid` bigint(20) NOT NULL,
  `allowed` bit(1) DEFAULT NULL,
  `transection_status` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paymentid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_payment`
--

LOCK TABLES `wb_payment` WRITE;
/*!40000 ALTER TABLE `wb_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_role`
--

DROP TABLE IF EXISTS `wb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_role` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_role`
--

LOCK TABLES `wb_role` WRITE;
/*!40000 ALTER TABLE `wb_role` DISABLE KEYS */;
INSERT INTO `wb_role` VALUES (1,'role for normal user','ROLE_SUPPLIER'),(2,'this role is for supplier','ROLE_USER'),(3,'role for normal admin','ROLE_ADMIN');
/*!40000 ALTER TABLE `wb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_sub_category`
--

DROP TABLE IF EXISTS `wb_sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_sub_category` (
  `id` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK61edbmk3t8l7yq9xfa8uqtfnq` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_sub_category`
--

LOCK TABLES `wb_sub_category` WRITE;
/*!40000 ALTER TABLE `wb_sub_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_subscription`
--

DROP TABLE IF EXISTS `wb_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_subscription` (
  `id` int(11) NOT NULL,
  `wb_end_date` datetime DEFAULT NULL,
  `wb_qwt` int(11) DEFAULT NULL,
  `wb_start_date` datetime DEFAULT NULL,
  `wb_unit` varchar(255) DEFAULT NULL,
  `userid` tinyblob,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa5dih3lodcj3kjd8vwhqd99ha` (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_subscription`
--

LOCK TABLES `wb_subscription` WRITE;
/*!40000 ALTER TABLE `wb_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_user`
--

DROP TABLE IF EXISTS `wb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_user` (
  `id` bigint(20) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `is_whatsapp_number` bit(1) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `detail_id` bigint(20) DEFAULT NULL,
  `preference_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq67jrhp7odcs4qlkw8xgqim9d` (`address_id`),
  KEY `FKp2ngawfsvkxi6h6xyoajws33t` (`detail_id`),
  KEY `FK3u9knacbnsufwao594vlc7od1` (`preference_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_user`
--

LOCK TABLES `wb_user` WRITE;
/*!40000 ALTER TABLE `wb_user` DISABLE KEYS */;
INSERT INTO `wb_user` VALUES (6,_binary '\0',_binary '','rajak','rajak','4343454345','$2a$10$TGnucstNgC3fknXcMAoDIuPOZxOSnjY.vOi1Zlxh.u/3v7FGAh3Gu','rajak',_binary '\0',4,NULL,5),(9,_binary '\0',_binary '\0','psankhle','psankhle','5456545654','$2a$10$aSbqovlhdDIEn2OoC.RvdefIJZTddLxset2exvaWj52mf.NZMV3oS','psankhle',_binary '\0',7,NULL,8);
/*!40000 ALTER TABLE `wb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_user_details`
--

DROP TABLE IF EXISTS `wb_user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_user_details` (
  `id` bigint(20) NOT NULL,
  `account_non_expired` bit(1) DEFAULT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_user_details`
--

LOCK TABLES `wb_user_details` WRITE;
/*!40000 ALTER TABLE `wb_user_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `wb_user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wb_user_preference`
--

DROP TABLE IF EXISTS `wb_user_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wb_user_preference` (
  `id` int(11) NOT NULL,
  `lang` varchar(255) DEFAULT NULL,
  `last_seleted_menu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wb_user_preference`
--

LOCK TABLES `wb_user_preference` WRITE;
/*!40000 ALTER TABLE `wb_user_preference` DISABLE KEYS */;
INSERT INTO `wb_user_preference` VALUES (2,'',NULL),(5,'us_EN',NULL),(8,'us_EN',NULL);
/*!40000 ALTER TABLE `wb_user_preference` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23 18:35:31
