-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: UserDB
-- ------------------------------------------------------
-- Server version	5.5.47

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
-- Table structure for table `Report`
--

DROP TABLE IF EXISTS `Report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Report` (
  `reportId` int(11) NOT NULL,
  `nameOfBuilding` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `zipCode` varchar(45) NOT NULL,
  `yearBuild` varchar(45) DEFAULT NULL,
  `buildingSizeInSquareMetres` int(11) DEFAULT NULL,
  `buildingPurpose` varchar(45) DEFAULT NULL,
  `roofNoticeBoolean` bit(1) NOT NULL,
  `roofPictureBoolean` bit(1) NOT NULL,
  `roofNotice` varchar(45) NOT NULL,
  `wallNoticeBoolean` bit(1) NOT NULL,
  `wallPictureBoolean` bit(1) NOT NULL,
  `wallNotice` varchar(45) NOT NULL,
  `roomId` int(11) NOT NULL,
  `writer` varchar(45) NOT NULL,
  `coWriter` varchar(45) DEFAULT NULL,
  `condition` int(11) NOT NULL,
  `buildingId` int(11) NOT NULL,
  PRIMARY KEY (`reportId`),
  FOREIGN KEY(`buildingId`)
  REFERENCES Room(`roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Report`
--

LOCK TABLES `Report` WRITE;
/*!40000 ALTER TABLE `Report` DISABLE KEYS */;
/*!40000 ALTER TABLE `Report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Room` (
 `roomId` int(11) NOT NULL,
  `roomName` varchar(45) NOT NULL,
  `notices` bit(1) DEFAULT NULL,
  `damagedRoom` bit(1) NOT NULL,
  `dateOfDamage` varchar(45) DEFAULT NULL,
  `descriptionOfLocation` varchar(45) DEFAULT NULL,
  `explanationOfDamage` varchar(45) DEFAULT NULL,
  `repairs` varchar(45) DEFAULT NULL,
  `moisture` bit(1) DEFAULT NULL,
  `sponge` bit(1) DEFAULT NULL,
  `mold` bit(1) DEFAULT NULL,
  `fire` bit(1) DEFAULT NULL,
  `otherDamage` bit(1) DEFAULT NULL,
  `moistureDescription` varchar(45) DEFAULT NULL,
  `spongeDescription` varchar(45) DEFAULT NULL,
  `moldDescription` varchar(45) DEFAULT NULL,
  `fireDescription` varchar(45) DEFAULT NULL,
  `otherDamageDescription` varchar(45) DEFAULT NULL,
  `reportId` int(11) NOT NULL,
  PRIMARY KEY (`roomId`),
  FOREIGN KEY (`reportId') 
  REFERENCES Report(`reportId`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-05 14:49:52
