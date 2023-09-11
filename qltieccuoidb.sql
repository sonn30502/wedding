CREATE DATABASE  IF NOT EXISTS `qltieccuoidb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qltieccuoidb`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: qltieccuoidb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `bookingID` int NOT NULL AUTO_INCREMENT,
  `eventID` int DEFAULT NULL,
  `hallID` int DEFAULT NULL,
  `menuID` int DEFAULT NULL,
  `serviceID` int DEFAULT NULL,
  `UserID` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  KEY `eventID` (`eventID`),
  KEY `hallID` (`hallID`),
  KEY `menuID` (`menuID`),
  KEY `serviceID` (`serviceID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`hallID`) REFERENCES `halls` (`hallID`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`),
  CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`),
  CONSTRAINT `booking_ibfk_5` FOREIGN KEY (`UserID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `branchID` int NOT NULL AUTO_INCREMENT,
  `branchName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`branchID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (2,'THE ADORA CENTER','431 Hoàng Văn Thụ, Phường 4, Quận Tân Bình','18001001','https://res.cloudinary.com/da7tpv6qw/image/upload/v1692969358/mv2zk3uqb2lnc8pacdzn.jpg'),(8,'GRAND PALACE','142/18 Cộng Hòa, P.4, Q.Tân Bình, TP.HCM','18001002','https://res.cloudinary.com/da7tpv6qw/image/upload/v1693322240/lvvnta5xikzegg2gpjgy.jpg'),(9,'THE ADORA ATHENA','371 Nguyễn Kiệm, Phường 3, Quận Gò Vấp','18001003','https://res.cloudinary.com/da7tpv6qw/image/upload/v1693581444/dols5dvjcwfxeaqojs3u.jpg'),(10,'THE ADORA LUXURY','198 Hoàng Văn Thụ, Phường 9, Quận Phú Nhuận','18001004','https://res.cloudinary.com/da7tpv6qw/image/upload/v1694321676/e0ziryltopx9pckqsgki.jpg'),(11,'THE ADORA DYNASTY','1A Tôn Thất Tùng, Phường Phạm Ngũ Lão, Quận 1','18001005','https://res.cloudinary.com/da7tpv6qw/image/upload/v1694321997/z8sdcqqsrzn4vwzzhxca.jpg'),(12,'THE ADORA GRANDVIEW','421 Ngô Gia Tự, Phường 9, Quận 5','18001006','https://res.cloudinary.com/da7tpv6qw/image/upload/v1694322006/j6lv2hl5lvdn57pjxykx.jpg'),(13,'THE ADORA PREMIUM','803 Nguyễn Văn Linh, Phường Tân Phú, Quận 7','18001007','https://res.cloudinary.com/da7tpv6qw/image/upload/v1694322020/hubo9sskrhdcsmgprbj6.jpg');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `eventID` int NOT NULL AUTO_INCREMENT,
  `branchID` int DEFAULT NULL,
  `hallID` int DEFAULT NULL,
  `menuID` int DEFAULT NULL,
  `serviceID` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `eventDate` date DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT NULL,
  `status` enum('Đã xác nhận','Chưa xác nhận','Đã hủy') CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`eventID`),
  KEY `branchID` (`branchID`),
  KEY `hallID` (`hallID`),
  KEY `menuID` (`menuID`),
  KEY `serviceID` (`serviceID`),
  KEY `userID` (`userID`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`),
  CONSTRAINT `event_ibfk_2` FOREIGN KEY (`hallID`) REFERENCES `halls` (`hallID`),
  CONSTRAINT `event_ibfk_3` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`),
  CONSTRAINT `event_ibfk_4` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`),
  CONSTRAINT `event_ibfk_5` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedbackID` int NOT NULL AUTO_INCREMENT,
  `serviceID` int DEFAULT NULL,
  `feedbackDate` date DEFAULT NULL,
  `feedbackContent` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `rating` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`feedbackID`),
  KEY `eventID` (`serviceID`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`serviceID`) REFERENCES `event` (`eventID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,NULL,'2023-09-02','đồ ăn ngon đúng mô tả',5,NULL),(2,NULL,'2023-09-02','tất cả đều tốt',2,NULL),(3,NULL,'2023-09-02','tạm',4,NULL),(4,NULL,'2023-09-03','tệ hại',1,NULL);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `halls`
--

DROP TABLE IF EXISTS `halls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `halls` (
  `hallID` int NOT NULL AUTO_INCREMENT,
  `branchID` int DEFAULT NULL,
  `hallName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `priceMorning` decimal(10,2) DEFAULT NULL,
  `priceAfternoon` decimal(10,2) DEFAULT NULL,
  `priceEvening` decimal(10,2) DEFAULT NULL,
  `priceWeekend` decimal(10,2) DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  PRIMARY KEY (`hallID`),
  KEY `branchID` (`branchID`),
  CONSTRAINT `halls_ibfk_1` FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halls`
--

LOCK TABLES `halls` WRITE;
/*!40000 ALTER TABLE `halls` DISABLE KEYS */;
INSERT INTO `halls` VALUES (1,8,'SẢNH PLATIN',10.00,20.00,30.00,100.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693319463/fu0uhuymej4adfdo4dvs.jpg','Sảnh Platin với kích thước 386 m2 được bày trí theo phong cách Châu Âu sang trọng sẽ thật sự phù hợp cho một hôn lễ ấm cúng với số lượng khách mời trong khoảng 20 đến 26 bàn tiệc. Diện tích sảnh có thể mở rộng linh hoạt với sức chứa lên đến 1500 khách (150 bàn) nhằm đáp ứng cho nhiều hình thức và nhu cầu đặt tiệc khác nhau.'),(3,2,'SẢNH VENUS',20.00,40.00,60.00,80.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693392255/rfkql5z5qunxrtep0tgk.jpg','Sảnh Venus với kích thước sảnh 544 m2 được bày trí theo phong cách Châu Âu sang trọng có sức chứa từ 30 đến 40 bàn tiệc trên nền vàng ấn tượng. Diện tích sảnh có thể mở rộng linh hoạt với sức chứa lên đến 1500 khách (150 bàn) nhằm đáp ứng cho nhiều hình thức và nhu cầu đặt tiệc khác nhau.'),(5,2,'SẢNH ELITE',40.00,80.00,100.00,120.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693392508/oyvqbex14fza9tikfi9f.jpg','Sảnh Elite với kích thước sảnh 544 m2 được bày trí theo phong cách Châu Âu sang trọng có sức chứa từ 30 đến 40 bàn tiệc trên nền vàng ấn tượng. Diện tích sảnh có thể mở rộng linh hoạt với sức chứa lên đến 1500 khách (150 bàn) nhằm đáp ứng cho nhiều hình thức và nhu cầu đặt tiệc khác nhau.'),(6,2,'SẢNH MERCURY',10.00,20.00,30.00,40.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693398780/hya5vdvommaqdvyrwgzx.jpg','Sảnh Mercury với kích thước sảnh 544 m2 được bày trí theo phong cách Châu Âu sang trọng có sức chứa từ 30 đến 40 bàn tiệc trên nền vàng ấn tượng. Diện tích sảnh có thể mở rộng linh hoạt với sức chứa lên đến 1500 khách (150 bàn) nhằm đáp ứng cho nhiều hình thức và nhu cầu đặt tiệc khác nhau.'),(7,8,'SẢNH PAVILON',100.00,200.00,300.00,400.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693398815/sm1fezantfhzlg73xz9t.jpg','Sảnh Pavilon với kích thước sảnh 544 m2 được bày trí theo phong cách Châu Âu sang trọng có sức chứa từ 30 đến 40 bàn tiệc trên nền xanh độc đáo. Diện tích sảnh có thể mở rộng linh hoạt với sức chứa lên đến 850 khách (85 bàn) nhằm đáp ứng cho nhiều hình thức và nhu cầu đặt tiệc khác nhau.'),(8,8,'SẢNH FONTANA',500.00,1000.00,2000.00,3000.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693847656/xeq0dliwsvuyvyjb2n9y.jpg','Sảnh Fontana với kích thước sảnh 544 m2 được bày trí theo phong cách Châu Âu sang trọng có sức chứa từ 30 đến 40 bàn tiệc trên nền xanh độc đáo. Diện tích sảnh có thể mở rộng linh hoạt với sức chứa lên đến 850 khách (85 bàn) nhằm đáp ứng cho nhiều hình thức và nhu cầu đặt tiệc khác nhau.');
/*!40000 ALTER TABLE `halls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menuID` int NOT NULL AUTO_INCREMENT,
  `branchID` int DEFAULT NULL,
  `menuName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `price` decimal(10,2) DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  PRIMARY KEY (`menuID`),
  KEY `branchID` (`branchID`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (15,2,'SWEET LOVE','Thực đơn Sweet Love nó mang đến một sự kết hợp giữa các món ăn ngon lành và hương vị lãng mạn, tạo nên một trải nghiệm ẩm thực đặc biệt cho khách mời',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694319001/pshm6gjyym36ayzqtqok.jpg','2023-09-10 00:00:00'),(16,8,'GỎI TÔM THÁI TÂY THI','rất là ngon, rất lạ miệng',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694319894/f3nekjwtukpjlbtc4dsj.jpg','2023-09-10 00:00:00'),(17,9,'CUA LỘT SỐT CHANH DÂY','abvxcvsdg ngon sieu cay',288.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694319935/umvsjx6dllcabf5bgaj5.jpg','2023-09-10 00:00:00'),(18,2,'CÁ CUỘN BACON ĐÚT LÒ SỐT BBQ MẬT ONG','dong la binh duong ',100.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694319966/yjxuratgybq2lhfmyxki.jpg','2023-09-10 00:00:00'),(19,2,'CÁ HỒI HẤP TAM SẮC SỐT THƯỢNG HẠNG','CÁ HỒI HẤP TAM SẮC SỐT THƯỢNG HẠNG',100.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320248/x1yhvutfcyyvdtozkams.jpg','2023-09-10 00:00:00'),(20,2,'CÁ BỚP ĐÚT LÒ SỐT TERIYAKI','CÁ BỚP ĐÚT LÒ SỐT TERIYAKI',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320268/jqcyme0ocsdr41utra8t.jpg','2023-09-10 00:00:00'),(21,8,'CÁ BỐNG MÚ HẤP HỒNG KÔNG','CÁ BỐNG MÚ HẤP HỒNG KÔNG',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320281/hnca7cqsvp69hgyorjhd.jpg','2023-09-10 00:00:00'),(22,8,'BÒ HẦM RƯỢU VANG - Bánh mì','BÒ HẦM RƯỢU VANG - Bánh mì',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320293/iyw7saa7tlvp7yse4cyn.jpg','2023-09-10 00:00:00'),(23,8,'BỒ CÂU QUAY','BỒ CÂU QUAY',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320306/k1gz1j8v3hcqtrkf7xxu.jpg','2023-09-10 00:00:00'),(24,9,'CHẢ GIÒ GRAND PALACE','CHẢ GIÒ GRAND PALACE',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320318/gagou2fahqji0k5ccw22.jpg','2023-09-10 00:00:00'),(25,9,'MÌ XÀO SA TẾ TÔM','MÌ XÀO SA TẾ TÔM',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320327/vck8wxnq9iu6ccdq9af0.jpg','2023-09-10 00:00:00'),(26,2,'CƠM CHIÊN GÀ QUAY LÁ É','CƠM CHIÊN GÀ QUAY LÁ É',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694320338/lvbm2tcpi55un5osrz6z.jpg','2023-09-10 00:00:00');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentID` int NOT NULL AUTO_INCREMENT,
  `eventID` int DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `paymentMethod` enum('Trực tiếp','Momo','ZaloPay') CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `invoiceNumber` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `details` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  PRIMARY KEY (`paymentID`),
  KEY `eventID` (`eventID`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `serviceID` int NOT NULL AUTO_INCREMENT,
  `branchID` int DEFAULT NULL,
  `serviceName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `price` decimal(10,2) DEFAULT NULL,
  `image` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`serviceID`),
  KEY `branchID` (`branchID`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (7,9,'Fresh flowers for the party table','Fresh flowers for the party table',1000.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694317869/i3krpcdexyzj3fuybjfk.jpg'),(9,8,'Âm thanh và ánh sáng','Dịch vụ âm thanh và ánh sáng là một phần quan trọng trong việc tạo ra không gian tiệc cưới thú vị và sống động. Nhà hàng tiệc cưới cung cấp hệ thống âm thanh chất lượng cao và cung cấp ánh sáng phù hợp để tạo ra không gian lãng mạn và phù hợp với chủ đề tiệc cưới.',200.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694318015/tfecbtstlhuyxghfgdgv.jpg'),(10,2,'Tổ chức tiệc cưới','Nhà hàng tiệc cưới cung cấp dịch vụ tổ chức tiệc cưới đầy đủ, bao gồm việc thu xếp không gian, thiết kế và trang trí, sắp xếp bàn ghế, âm thanh và ánh sáng, quản lý sự kiện và các chi tiết khác liên quan để tạo ra một buổi tiệc cưới hoàn hảo.',500.00,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1694318429/njbtxqbawgvpr1ipf1h9.jpg');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistic`
--

DROP TABLE IF EXISTS `statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statistic` (
  `statisticID` int NOT NULL AUTO_INCREMENT,
  `branchID` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `quarter` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `eventCount` int DEFAULT NULL,
  `revenue` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`statisticID`),
  KEY `branchID` (`branchID`),
  CONSTRAINT `statistic_ibfk_1` FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistic`
--

LOCK TABLES `statistic` WRITE;
/*!40000 ALTER TABLE `statistic` DISABLE KEYS */;
/*!40000 ALTER TABLE `statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `lastName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `profileImage` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `userRole` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Son','DC','son111@gmail.com',NULL,NULL,'dcs111','$2a$10$5pQ1TFjM5M4sW6zjvpOTn.pcmf02/.Ev4RT1P5/zkW8YiUIQ5Z4iy','ROLE_USER'),(2,'son','dc','dcson123@gmail.com',NULL,NULL,'dcsAdmin','$2a$10$cPjXr7uQbaAb571rx4T09O75zBycYhj18HgPYFVS5d3sxy.qkVFye','ROLE_ADMIN'),(7,'n','dcs','sonn@gmail.com',NULL,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693301719/k4uhazrc13twebo1i5k3.png','sonn','$2a$10$MiRv6Lqlm/ofj7UsEjafAuqnJSv6ZiO7U01jywzg.rpVPtjWK9CM2','ROLE_USER'),(8,'Hồ Ngọc','Giang','ghn123@gmail.com',NULL,'https://res.cloudinary.com/da7tpv6qw/image/upload/v1693499987/pdwhpf8nz7te0njxq5ld.jpg','ghn123','$2a$10$VTnxFivVf7Ck2Qu4OnZU2e0TFtu2RQqHDopBf3T.JSo7ewKrsJ/hq','ROLE_USER');
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

-- Dump completed on 2023-09-10 18:12:59
