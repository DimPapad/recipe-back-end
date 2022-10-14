CREATE DATABASE  IF NOT EXISTS `InitialD` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `InitialD`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: ra1.anystream.eu    Database: InitialD
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friendship` (
  `friendship_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `request_valid` bit(1) DEFAULT NULL,
  PRIMARY KEY (`friendship_id`),
  KEY `fk_user_has_user_user2_idx` (`friend_id`),
  KEY `fk_user_has_user_user1_idx` (`user_id`),
  CONSTRAINT `fk_friendshiptouser_friendid_id` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_friendshiptouser_userid_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship`
--

LOCK TABLES `friendship` WRITE;
/*!40000 ALTER TABLE `friendship` DISABLE KEYS */;
INSERT INTO `friendship` VALUES (3,30,29,_binary '\0'),(4,3,2,_binary '\0'),(5,8,24,_binary '\0'),(6,3,13,_binary '\0'),(9,22,30,_binary '\0'),(10,2,25,_binary '\0'),(11,29,17,_binary ''),(12,21,14,_binary ''),(13,6,26,_binary ''),(14,18,15,_binary ''),(15,1,5,_binary '\0'),(16,23,19,_binary ''),(17,9,1,_binary '\0'),(18,4,5,_binary '\0'),(19,16,27,_binary '\0'),(20,19,23,_binary ''),(21,30,24,_binary '\0'),(23,26,22,_binary ''),(24,24,27,_binary ''),(25,21,18,_binary ''),(26,25,9,_binary ''),(27,5,18,_binary ''),(28,7,15,_binary '\0'),(29,15,28,_binary ''),(30,11,19,_binary '\0'),(31,11,6,_binary '\0'),(32,16,29,_binary ''),(33,666,20,_binary ''),(39,674,675,_binary ''),(40,666,2,_binary ''),(41,666,8,_binary ''),(42,666,14,_binary ''),(43,666,7,_binary ''),(44,674,20,_binary ''),(45,695,20,_binary ''),(46,695,2,_binary ''),(47,697,20,_binary '');
/*!40000 ALTER TABLE `friendship` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-01  4:12:07
