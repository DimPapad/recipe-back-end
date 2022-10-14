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
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `instructions` text,
  `utensils` text,
  `description` text,
  `ingredients` text,
  `photo` varchar(100) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `paid` bit(1) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_recipe_user1_idx` (`owner_id`),
  CONSTRAINT `fk_recipe_user1` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'Fire-Roasted Sweet & Spicy Bear','OEUBKBUNEFLVNK','The Bigwig','XTYAIH','XTYAIH, GOBFHA, XCMFSE',NULL,NULL,'Breakfast',_binary '\0',20),(2,'Stewed Pepper Mammoth','KOFDXEBDMCQXND','The Handler','GOBFHA','GOBFHA, XCMFSE, SMCZQN',NULL,NULL,'Breakfast',_binary '',2),(3,'Baked Orange & Mustard Mussels','HGEBSGNESNDMKX','The Phaser','XCMFSE','XCMFSE, SMCZQN, YBXYPR',NULL,NULL,'Lunch',_binary '',3),(4,'Roasted Egg & Beet Alligator','PHESNQYXNONZEH','The Fixer','SMCZQN','SMCZQN, YBXYPR, MSHCGL',NULL,NULL,'Breakfast',_binary '',3),(5,'Infused Pine Lasagna','AOQFDBBAHMQRAG','The Sharpner','YBXYPR','YBXYPR, MSHCGL, XFQVRJ',NULL,NULL,'Dinner',_binary '',8),(6,'Smoked Blueberry & Mushroom Kebabs','AWMNLNXHCEAYFL','The Salsa','MSHCGL','MSHCGL, XFQVRJ, XLHCVC',NULL,NULL,'Breakfast',_binary '\0',14),(7,'Peanut and Grape Bread','OOLZQUWGHDWYNG','The Slacker','XFQVRJ','XFQVRJ, XLHCVC, ZISCUG',NULL,NULL,'Dinner',_binary '',14),(8,'Strawberry and Praline Fudge','NKLBPZLJKGFLTU','The Spoon','XLHCVC','XLHCVC, ZISCUG, FLTTOA',NULL,NULL,'Lunch',_binary '\0',5),(9,'Chocolate Split','OLLKKJQIHFLMKA','The Bear Paw','ZISCUG','ZISCUG, FLTTOA, NXNZSE',NULL,NULL,'Lunch',_binary '',5),(10,'Kiwi Cake','DHEOWQGRVEFYUT','The Sludge','FLTTOA','FLTTOA, NXNZSE, PJPQNF',NULL,NULL,'Breakfast',_binary '\0',6),(11,'Pressure-Fried Silver Koodoo','JFCJQIXREKOUYH','The Sparrow','NXNZSE','NXNZSE, PJPQNF, WEZEMH',NULL,NULL,'Breakfast',_binary '\0',8),(12,'Fire-Grilled Pulse Reindeer','RSLHBETLUPJXVA','The Dirty Bomb','PJPQNF','PJPQNF, WEZEMH, ICZSFX',NULL,NULL,'Lunch',_binary '',8),(13,'Breaded Stone Capybara','OPZYFGNSSMVGGO','The Measurer','WEZEMH','WEZEMH, ICZSFX, DQRCRN',NULL,NULL,'Breakfast',_binary '',7),(14,'Pickled Enchanted Canary','QKDZCBLJHCDLCR','The Duster','ICZSFX','ICZSFX, DQRCRN, MQEZTI',NULL,NULL,'Lunch',_binary '\0',16),(15,'Solar Honey Milk','BGYYFZNEMSXSCS','The Hole Digger','DQRCRN','DQRCRN, MQEZTI, CSOXOT',NULL,NULL,'Lunch',_binary '',12),(16,'Arcane Black Pepper Jelly','GGRRULNJKVHRUK','The Winger','MQEZTI','MQEZTI, CSOXOT, BAHZBS',NULL,NULL,'Lunch',_binary '\0',20),(17,'Manticore Pud','KYZJDTVKSWNXAN','The Duster','CSOXOT','CSOXOT, BAHZBS, BHUGGY',NULL,NULL,'Breakfast',_binary '',2),(18,'Crocotta Bread','MSQAPCLIZGKULA','The Boomer','BAHZBS','BAHZBS, BHUGGY, JCFEXG',NULL,NULL,'Breakfast',_binary '',8),(19,'exiona Bonbons','UXTYBFSVICVWUN','The Seahorse','BHUGGY','BHUGGY, JCFEXG, EOZOCL',NULL,NULL,'Lunch',_binary '',5),(20,'yiwine Bread','QJLZIKSYUNBZBT','The Picker','JCFEXG','JCFEXG, EOZOCL, ZKMBLQ',NULL,NULL,'Lunch',_binary '\0',12),(21,'Dried Figs & Olive Pigeon','QVBNAIHNVRRIMO','The Guzzler','EOZOCL','EOZOCL, ZKMBLQ, WHXRPT',NULL,NULL,'Dinner',_binary '\0',12),(22,'Infused Souther-Style Pheasant','GOXLAGHMAYOOCC','The Spine','ZKMBLQ','ZKMBLQ, WHXRPT, XORDMK',NULL,NULL,'Lunch',_binary '',11),(23,'Fire-Grilled Savory Cockles','YRCFLRATXRJAUN','The Guardian','WHXRPT','WHXRPT, XORDMK, QXAUTG',NULL,NULL,'Breakfast',_binary '',9),(24,'Smoked Forest Cockles','BEYPBKQEEVJQJD','The Chipper','XORDMK','XORDMK, QXAUTG, JCFXOL',NULL,NULL,'Dinner',_binary '\0',9),(25,'Engine-Cooked Garlic & Rosemary Sandwich','QBXVDPFLVCCSQM','The Scratcher','QXAUTG','QXAUTG, JCFXOL, JXIIGQ',NULL,NULL,'Dinner',_binary '',18),(26,'Tenderized Lime-Coated Bisque','PHSPQHGTJJSQPL','The Stitcher','JCFXOL','JCFXOL, JXIIGQ, JTXQXF',NULL,NULL,'Dinner',_binary '\0',15),(27,'Melon and Blueberry Pastry','ZTSKQQRZWHLJDT','The Spiderleg','JXIIGQ','JXIIGQ, JTXQXF, MEUGEN',NULL,NULL,'Dinner',_binary '',9),(28,'Cranberry and Avocado Fruit Salad','WRGCHHAYIHTLAQ','The Fuse Gate','JTXQXF','JTXQXF, MEUGEN, EAKLEO',NULL,NULL,'Lunch',_binary '',9),(29,'Rum Bonbons','RHWPAOJFASHHUS','The Horn Head','MEUGEN','MEUGEN, EAKLEO, KFNDVI',NULL,NULL,'Lunch',_binary '\0',19),(30,'Pistachio Genoise','CPVAYHKWEBUTJW','The Wazoo','EAKLEO','EAKLEO, KFNDVI, ESCLII',NULL,NULL,'Lunch',_binary '\0',12),(31,'Slow-Cooked Masked Swan','QMAXGJHPSFOFHO','The Monkey Suit','KFNDVI','KFNDVI, ESCLII, SKRYXS',NULL,NULL,'Lunch',_binary '',8),(32,'Brined Silk Burro','SFCQNJMQZDFQOC','The Cube','ESCLII','ESCLII, SKRYXS, GHFJZU',NULL,NULL,'Breakfast',_binary '',8),(33,'Shallow-Fried Flame Jackrabbit','ZHBSHEDZZZNRWL','The Sharpner','SKRYXS','SKRYXS, GHFJZU, QOPKCI',NULL,NULL,'Dinner',_binary '',20),(34,'Oven-Grilled Light Okapi','OXTVLECDZXSRQU','The Gobbler','GHFJZU','GHFJZU, QOPKCI, RIHJHJ',NULL,NULL,'Lunch',_binary '',7),(35,'Great Pine Waffles','ZWFOXYUQZSMMVP','The Wazoo','QOPKCI','QOPKCI, RIHJHJ, RKUGTU',NULL,NULL,'Breakfast',_binary '\0',2),(36,'Radiant Honey & Nuts Candy','BPGHFZDRDWKDYR','The Big Blue','RIHJHJ','RIHJHJ, RKUGTU, MYONGB',NULL,NULL,'Breakfast',_binary '\0',18),(37,'Manticore Fruitcake','QDVHOOIQAIKEJL','The Rat Skin','RKUGTU','RKUGTU, MYONGB, HJRFHU',NULL,NULL,'Dinner',_binary '',18),(38,'Bunyip Milk','XKILEHSBXDTDXE','The Firecrackers','MYONGB','MYONGB, HJRFHU, ZACAOB',NULL,NULL,'Lunch',_binary '\0',8),(39,'pruxaragus Cake','HVDKRYOEKMLOHD','The Snackbox','HJRFHU','HJRFHU, ZACAOB, DSCHHU',NULL,NULL,'Dinner',_binary '',7),(40,'ivemond Bread','NDIKXPJOAUHJTT','The Icicle','ZACAOB','ZACAOB, DSCHHU, TSJUMT',NULL,NULL,'Breakfast',_binary '',12),(41,'Dried Coconut Rabbit','FFSELFUMWFLYYC','The Whiskey Stick','DSCHHU','DSCHHU, TSJUMT, YAEJHJ',NULL,NULL,'Dinner',_binary '',7),(42,'Stir-Fried Fennel Pigeon','TFPJFIGGWDHDGX','The Chucker','TSJUMT','TSJUMT, YAEJHJ, DNFFPO',NULL,NULL,'Breakfast',_binary '\0',7),(43,'Shallow-Fried Parmesan Clams','UOZMNXHKHIUMYH','The Burner','YAEJHJ','YAEJHJ, DNFFPO, HRZHBZ',NULL,NULL,'Lunch',_binary '',12),(44,'Slow-Cooked Mustard & Rosemary Tuna','YTXUWUEPVICEHC','The Guts','DNFFPO','DNFFPO, HRZHBZ, TCOHDN',NULL,NULL,'Breakfast',_binary '\0',20),(45,'Steamed Confit of Rice','GNBOZYRDYVPOLL','The Burner','HRZHBZ','HRZHBZ, TCOHDN, KZMXBD',NULL,NULL,'Breakfast',_binary '\0',20),(46,'Brined Mustard Omelet','ZKWYLCXEBAVKRQ','The Hand Shoe','TCOHDN','TCOHDN, KZMXBD, DZQSEP',NULL,NULL,'Dinner',_binary '',8),(47,'Grape and Coconut Bonbons','TEIOAAMZFGZHOS','The Wonker','KZMXBD','KZMXBD, DZQSEP, ROEUCF',NULL,NULL,'Breakfast',_binary '',5),(48,'Cherry and Apple Roll','GMMQWCGHSSJFCR','The Rambler','DZQSEP','DZQSEP, ROEUCF, UZCTFV',NULL,NULL,'Lunch',_binary '',12),(49,'Guava Gingerbread','MXNHFUWPDSIQIK','The Crusher','ROEUCF','ROEUCF, UZCTFV, XTYAIH',NULL,NULL,'Breakfast',_binary '\0',3),(50,'Hazelnut Wafer','REORLNGJIPBXMM','The Guardian','UZCTFV','UZCTFV, XTYAIH, GOBFHA',NULL,NULL,'Lunch',_binary '',11),(51,'Smurf Meat Balls','This is the sentace caontaining instructions.','Bowl : 4-l, Pot: 8-l','Smurf Meat Balls, achieve imortality, provide great hospitality.','UZCTFV, XTYAIH, GOBFHA',NULL,NULL,'Breakfast',_binary '\0',666),(65,'IKEA meatballs','JUST EAT THEM','your hands','fresh made horse meatballs','horse, horse, horse',NULL,NULL,'breakfast',_binary '',8),(86,'Syntagi a@a 2','lala','lalaland','AAA','gigilos',NULL,NULL,'breakfast',_binary '',674),(87,'haviola','Mutso grande picorino cabrone','spoons! show me you spoons!','mutso mutso','no ingredients, never was',NULL,NULL,'dinner',_binary '\0',674),(88,'hola mundo - not sell','spoons','spoons','spoons','spoons',NULL,NULL,'lunch',_binary '\0',674),(89,'yOURWASH','ASDFASDF','FSADASDFSDF','SADFASDF','ASDFASDF',NULL,NULL,'Lunch',_binary '',666),(90,'a','a','a','a','a',NULL,NULL,'breakfast',_binary '',675),(91,'b','b','b','b','b',NULL,NULL,'breakfast',_binary '',675),(92,'c','c','c','c','c',NULL,NULL,'lunch',_binary '',675),(93,'d','d','d','d','d',NULL,NULL,'lunch',_binary '\0',675),(94,'e','e','e','e','e',NULL,NULL,'lunch',_binary '',675),(95,'f','f','f','f','f',NULL,NULL,'dinner',_binary '',675),(96,'1','1','1','1','1',NULL,NULL,'breakfast',_binary '\0',675),(97,'','','','','FGSDFG',NULL,NULL,'',_binary '\0',697);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-01  4:12:11
