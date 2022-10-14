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
-- Table structure for table `saved_recipes`
--

DROP TABLE IF EXISTS `saved_recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_recipes` (
  `saved_recipes_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `recipe_id` int(11) NOT NULL,
  `paid_for` bit(1) DEFAULT NULL,
  PRIMARY KEY (`saved_recipes_id`),
  KEY `fk_user_has_recipe_user1_idx` (`user_id`),
  KEY `fk_user_has_recipe_recipe1_idx` (`recipe_id`),
  CONSTRAINT `fk_user_has_recipe_recipe1` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_has_recipe_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_recipes`
--

LOCK TABLES `saved_recipes` WRITE;
/*!40000 ALTER TABLE `saved_recipes` DISABLE KEYS */;
INSERT INTO `saved_recipes` VALUES (1,23,42,_binary '\0'),(2,8,18,_binary ''),(3,1,23,_binary '\0'),(5,21,2,_binary '\0'),(6,8,21,_binary ''),(7,8,11,_binary ''),(8,12,25,_binary ''),(9,30,12,_binary '\0'),(10,13,12,_binary '\0'),(11,14,10,_binary '\0'),(12,15,11,_binary '\0'),(13,12,13,_binary '\0'),(14,19,15,_binary '\0'),(15,17,22,_binary '\0'),(16,14,1,_binary '\0'),(17,1,19,_binary '\0'),(19,13,15,_binary '\0'),(20,12,29,_binary '\0'),(22,11,5,_binary ''),(23,13,1,_binary '\0'),(24,11,1,_binary ''),(25,9,3,_binary ''),(26,9,22,_binary ''),(27,3,1,_binary '\0'),(28,10,7,_binary ''),(29,7,1,_binary '\0'),(30,9,25,_binary ''),(31,674,2,_binary '\0'),(32,666,11,_binary '\0'),(33,666,13,_binary ''),(34,666,17,_binary ''),(35,674,13,_binary '\0'),(36,675,2,_binary '\0'),(38,666,10,_binary '\0'),(39,666,36,_binary '\0'),(40,675,36,_binary '\0'),(41,697,3,_binary ''),(42,697,2,_binary '\0');
/*!40000 ALTER TABLE `saved_recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-01  4:12:06
