-- MySQL dump 10.13  Distrib 9.2.0, for Linux (aarch64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	9.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `stock` int DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `bookcover` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (3,'Thiết kế Web','Lê Văn C',12,'2025-01-09 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(5,'Thuật toán nâng cao','Ngô Văn E',3,'2025-01-31 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(6,'Hệ điều hành','Hoàng Thị F',6,'2025-02-09 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(7,'Mạng máy tính','Đặng Văn G',8,'2025-02-14 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(8,'An toàn thông tin','Lý Thị H',3,'2025-02-28 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(9,'Trí tuệ nhân tạo','Đỗ Văn I',5,'2025-03-04 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(10,'Học máy','Nguyễn Thị J',11,'2025-03-09 17:00:00','images/ml.jpg'),(11,'Cấu trúc dữ liệu','Trần Văn K',6,'2025-03-19 17:00:00','images/data_structure.jpg'),(13,'Java nâng cao','Nguyễn Văn M',9,'2025-04-04 17:00:00','images/java_advanced.jpg'),(16,'test','thái bảo',5,'2025-05-10 22:04:46','/Users/macbookprom1/Downloads/492929554_697177536394146_8583043701460759325_n.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentals`
--

DROP TABLE IF EXISTS `rentals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentals` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `rent_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  `status` enum('rented','returned') DEFAULT 'rented',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `rentals_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `rentals_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentals`
--

LOCK TABLES `rentals` WRITE;
/*!40000 ALTER TABLE `rentals` DISABLE KEYS */;
INSERT INTO `rentals` VALUES (7,3,16,'2025-05-12','2025-05-12','returned'),(8,3,16,'2025-05-12','2025-05-12','returned'),(9,3,3,'2025-05-12','2025-05-12','returned'),(10,3,3,'2025-05-12','2025-05-12','returned'),(11,3,9,'2025-05-12','2025-05-12','returned'),(12,3,16,'2025-05-12','2025-05-12','returned'),(13,3,16,'2025-05-12','2025-05-12','returned'),(14,3,16,'2025-05-12','2025-05-12','returned'),(15,3,3,'2025-05-12','2025-05-12','returned'),(16,3,3,'2025-05-12','2025-05-12','returned'),(17,3,10,'2025-05-12','2025-05-12','returned'),(18,3,16,'2025-05-12','2025-05-12','returned'),(19,3,16,'2025-05-12','2025-05-12','returned'),(20,3,3,'2025-05-12','2025-05-12','returned'),(21,3,16,'2025-05-12','2025-05-12','returned'),(22,3,13,'2025-05-12','2025-05-12','returned'),(23,3,5,'2025-05-12',NULL,'rented'),(24,3,3,'2025-05-12','2025-05-12','returned');
/*!40000 ALTER TABLE `rentals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','user') DEFAULT 'user',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ADMIN','admin','$2a$10$6052.y.cMy.j8hfnoVDMa.6CajhiUXPXYqpDyB1dvpc1Vbzhi57we','admin','2025-05-08 14:19:51'),(3,'Thái Bảo','tbao','$2a$10$zQzk7ar8OzhtDFGr.DXJvu8iVsQv1rLmLs7cH15j6NjgPxQF.Y5qK','user','2025-05-09 10:04:17'),(4,'Thái Bảo 2','tbao2','$2a$10$lipqoA3viUzlbDwLsc6fBeCguQlEKOWR3flmLp73mh7cRtswpUsNe','user','2025-05-09 10:05:33'),(5,'Thái Bảo đẹp zai','sdssd','$2a$10$69HRWGs5cre/Edr6xCkKKerVg.VJShZ7tzDVtxRF.c.NqEDf/OuF6','user','2025-05-12 09:58:59');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-17  9:53:03
