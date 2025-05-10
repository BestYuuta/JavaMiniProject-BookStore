-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.41

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
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Lập trình Java','Nguyễn Văn A',10,'2024-11-30 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(2,'Cơ sở dữ liệu','Trần Thị B',7,'2024-12-02 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(3,'Thiết kế Web','Lê Văn C',12,'2025-01-09 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(4,'Python cơ bản','Phạm Thị D',9,'2025-01-14 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(5,'Thuật toán nâng cao','Ngô Văn E',4,'2025-01-31 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(6,'Hệ điều hành','Hoàng Thị F',6,'2025-02-09 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(7,'Mạng máy tính','Đặng Văn G',8,'2025-02-14 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(8,'An toàn thông tin','Lý Thị H',3,'2025-02-28 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(9,'Trí tuệ nhân tạo','Đỗ Văn I',5,'2025-03-04 17:00:00','https://th.bing.com/th/id/OIP.pTicKhP4tdB7_wYh_0nivQAAAA?cb=iwp1&rs=1&pid=ImgDetMain'),(10,'Học máy','Nguyễn Thị J',11,'2025-03-09 17:00:00','images/ml.jpg'),(11,'Cấu trúc dữ liệu','Trần Văn K',6,'2025-03-19 17:00:00','images/data_structure.jpg'),(12,'Phân tích thiết kế hệ thống','Vũ Thị L',7,'2025-03-31 17:00:00','images/analysis.jpg'),(13,'Java nâng cao','Nguyễn Văn M',9,'2025-04-04 17:00:00','images/java_advanced.jpg'),(14,'Phát triển ứng dụng web','Phan Thị N',4,'2025-04-09 17:00:00','images/web_dev.jpg'),(15,'Quản trị cơ sở dữ liệu','Mai Văn O',10,'2025-04-14 17:00:00','images/db_admin.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-10  8:56:52
