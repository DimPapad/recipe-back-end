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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(10) NOT NULL,
  `password` varchar(24) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=705 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'qwe@recipemail.com','Thodoris','ROLE_ADMIN','1234'),(2,'ads@recipemail.com','Kyriakos','ROLE_ADMIN','1234'),(3,'zxc@recipemail.com','Kyriakos','ROLE_ADMIN','1234'),(4,'wer@recipemail.com','Manousos','ROLE_USER','1234'),(5,'sdf@recipemail.com','Efthimios','ROLE_USER','1234'),(6,'xcv@recipemail.com','Stamatis','ROLE_USER','1234'),(7,'ert@recipemail.com','Theofylaktos','ROLE_USER','1234'),(8,'dfg@recipemail.com','Epameinondas','ROLE_USER','1234'),(9,'cxv@recipemail.com','Alex','ROLE_USER','1234'),(10,'rty@recipemail.com','Andreas','ROLE_USER','1234'),(11,'fgh@recipemail.com','Nikoleta','ROLE_USER','1234'),(12,'vbn@recipemail.com','Liza','ROLE_USER','1234'),(13,'tyu@recipemail.com','Grigoria','ROLE_USER','1234'),(14,'ghj@recipemail.com','Nasia','ROLE_USER','1234'),(15,'bnm@recipemail.com','Penelope','ROLE_USER','1234'),(16,'yui@recipemail.com','Erato','ROLE_USER','1234'),(17,'hjk@recipemail.com','Antigoni','ROLE_USER','1234'),(18,'nmk@recipemail.com','Roxanni','ROLE_USER','1234'),(19,'iop@recipemail.com','Lia','ROLE_USER','1234'),(20,'jkl@recipemail.com','Evgenia','ROLE_USER','1234'),(21,'qsd@recipemail.com','Epameinondas','ROLE_USER','1234'),(22,'zxdf@recipemail.com','Takis','ROLE_USER','1234'),(23,'ergb@recipemail.com','Anargyros','ROLE_USER','1234'),(24,'cvhbg@recipemail.com','Dimos','ROLE_USER','1234'),(25,'thn@recipemail.com','Menelaos','ROLE_USER','1234'),(26,'vbn@recipemail.com','Fotios','ROLE_USER','1234'),(27,'trhgj@recipemail.com','Serafim','ROLE_USER','1234'),(28,'dfsdf@recipemail.com','Adam','ROLE_USER','1234'),(29,'cxv@recipemail.com','Yannis','ROLE_USER','1234'),(30,'dfbv@recipemail.com','Makis','ROLE_USER','1234'),(666,'georgeazakas@outlook.com','Yourwash','ROLE_ADMIN','777'),(674,'a@a','aa','ROLE_ADMIN','123'),(675,'ev@ev','evgenia','ROLE_USER','456'),(684,'p@gmail.com','acs','ROLE_USER','1234'),(685,'a@a.com','aaa','ROLE_USER','1234'),(686,'asdf@asdf.com','asdf','ROLE_USER','asdf'),(687,'asdf1@gmail.com','asdf1','ROLE_USER','asdf1'),(688,'asdf12@gmail.com','asdf12','ROLE_USER','asdf123'),(689,'asdf@gmail.com','asdff','ROLE_USER','asdff'),(690,'asdg@gmail.com','asdfg','ROLE_USER','12341234'),(691,'asdf@asdf.com','12345','ROLE_USER','12345'),(692,'123@gmail.com','asdfgh','ROLE_USER','asdf'),(693,'123asd@gmail.com','123asd','ROLE_USER','1234'),(694,'1234@gmail.com','1234','ROLE_USER','1234'),(695,'egg@fapening.com','EggieFabriemelatou','ROLE_USER','9876'),(696,'georgeazakas@outlook.com','SpirosMavros','ROLE_USER','777'),(697,'azakas@outlook.com','Spiros','ROLE_USER','777'),(698,'aaa@aaaa.com','aaaaa','ROLE_USER','1234'),(699,'bb@bb.com','bb','ROLE_USER','1234'),(700,'la@la.com','lala','ROLE_USER','1234'),(701,'144@com.com','Malakas','ROLE_USER','1234'),(702,'d@2.ogt','dvg','ROLE_USER','1234'),(703,'gg@tt.com','Moutsos','ROLE_USER','1234'),(704,'tsi@blas.gg','Tsiblas','ROLE_USER','1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-01  4:12:09
