
SET NAMES utf8mb4 ;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

 --SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` json NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D649F85E0677` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `user`
--

--LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES (1,'admin','[\"ROLE_ADMIN\"]','admin'),(3,'CristinaBosch','[\"ROLE_HR\"]','password'),(4,'JohnDoe','[\"ROLE_USER\"]','password'),(6,'AnnaNova','[\"ROLE_HR\"]','password'),(7,'JanKowalski','[]','password'),(8,'JohnSmith','[]','password'),(9,'JaneDoe','[]','password'),(10,'JeremiTonks','[]','password');

--UNLOCK TABLES;

--
-- Table structure for table `personal_data`
--

DROP TABLE IF EXISTS `personal_data`;

-- SET character_set_client = utf8mb4 ;
CREATE TABLE `personal_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `birth_place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_9CF9F45E9D86650F` (`user_id_id`),
  CONSTRAINT `FK_9CF9F45E9D86650F` FOREIGN KEY (`user_id_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `personal_data`
--

--LOCK TABLES `personal_data` WRITE;

INSERT INTO `personal_data` VALUES (1,'Doe','John','1970-01-01','Luxembourg',NULL,4),(2,'Nova','Anna','1977-09-15','London',NULL,6),(3,'Bosch','Cristina','1977-06-16','Luxembourg',NULL,3),(4,'Kowalski','Jan','1983-09-07','Varsovia',NULL,7),(5,'Smith','John','1980-12-28','Manchester',NULL,8),(6,'Doe','Jane','1973-07-07','Luxembourg',NULL,9),(7,'Tonks','Jeremi','1977-01-01','Cardiff',NULL,10);

--UNLOCK TABLES;

--
-- Table structure for table `phone_numbers`
--

DROP TABLE IF EXISTS `phone_numbers`;

-- SET character_set_client = utf8mb4 ;
CREATE TABLE `phone_numbers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `prim` tinyint(1) NOT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_E7DC46CB1D775834` (`value`),
  KEY `IDX_E7DC46CBA76ED395` (`user_id`),
  CONSTRAINT `FK_E7DC46CBA76ED395` FOREIGN KEY (`user_id`) REFERENCES `personal_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `phone_numbers`
--

--LOCK TABLES `phone_numbers` WRITE;

INSERT INTO `phone_numbers` VALUES (1,1,1,'123 456 789'),(2,1,0,'+352 987 654 321'),(3,4,1,'666 666 666'),(4,5,1,'900 800 700'),(5,2,1,'888 500 177'),(6,5,0,'100 200 300');

--UNLOCK TABLES;

--
-- Table structure for table `staff_category`
--

DROP TABLE IF EXISTS `staff_category`;

-- SET character_set_client = utf8mb4 ;
CREATE TABLE `staff_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `staff_category`
--

--LOCK TABLES `staff_category` WRITE;

INSERT INTO `staff_category` VALUES (1,'Profesor'),(2,'Assistant'),(3,'Secretary'),(4,'Administrative support');

--UNLOCK TABLES;

--
-- Table structure for table `adres`
--

DROP TABLE IF EXISTS adres;

--SET character_set_client = utf8mb4 ;
CREATE TABLE adres (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `prim` tinyint(1) NOT NULL,
  `street` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `local` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `town` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_50C7CAEEA76ED395` (`user_id`),
  CONSTRAINT `FK_50C7CAEEA76ED395` FOREIGN KEY (`user_id`) REFERENCES `personal_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `adres`
--

--LOCK TABLES `adres` WRITE;
INSERT INTO `adres` VALUES (1,1,1,'Cite Galerie Hondsbech','2','15','04-023','Niederkorn'),(2,2,1,'Nowhere','1',NULL,'00-000','Middle of Nowhere'),(3,4,1,'Avenue da Liberte','17a',NULL,'004-12','Differendage'),(4,5,1,'Somwhere','12',NULL,'00-123','London'),(5,5,0,'La Madelina','1145','12a','34-567','Petange');

--UNLOCK TABLES;

--
-- Table structure for table `emails`
--

DROP TABLE IF EXISTS `emails`;

SET character_set_client = utf8mb4 ;
CREATE TABLE `emails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `prim` tinyint(1) NOT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_4C81E8521D775834` (`value`),
  KEY `IDX_4C81E852A76ED395` (`user_id`),
  CONSTRAINT `FK_4C81E852A76ED395` FOREIGN KEY (`user_id`) REFERENCES `personal_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `emails`
--

LOCK TABLES `emails` WRITE;

INSERT INTO `emails` VALUES (1,1,1,'john.doe@uni.lu'),(2,2,1,'anna.nova@uni.lu'),(3,4,1,'jan.kowalski@uni.lu'),(4,5,1,'john.smith@uni.lu');

UNLOCK TABLES;

--
-- Table structure for table `engagement`
--

DROP TABLE IF EXISTS `engagement`;

 --SET character_set_client = utf8mb4 ;
CREATE TABLE `engagement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `staff_category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_D86F0141217BBB47` (`person_id`),
  KEY `IDX_D86F0141E3742DB0` (`staff_category_id`),
  CONSTRAINT `FK_D86F0141217BBB47` FOREIGN KEY (`person_id`) REFERENCES `personal_data` (`id`),
  CONSTRAINT `FK_D86F0141E3742DB0` FOREIGN KEY (`staff_category_id`) REFERENCES `staff_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `engagement`
--

--LOCK TABLES `engagement` WRITE;

INSERT INTO `engagement` VALUES (1,1,1),(2,2,3),(3,5,2),(4,6,1),(5,4,4);

--UNLOCK TABLES;

--
-- Table structure for table `job_data`
--

DROP TABLE IF EXISTS `job_data`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `job_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_contract` date NOT NULL,
  `end_contract` date NOT NULL,
  `monthly_salary` int(11) NOT NULL,
  `working_hours_per_week` int(11) NOT NULL,
  `bank_info` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bank_account_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_2A3F8522A76ED395` (`user_id`),
  CONSTRAINT `FK_2A3F8522A76ED395` FOREIGN KEY (`user_id`) REFERENCES `personal_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `job_data`
--

--LOCK TABLES `job_data` WRITE;

INSERT INTO `job_data` VALUES (1,'2014-03-05','2017-03-06',500,40,'TrierBank','000000000000000000000',1),(2,'2013-01-01','2020-01-01',666,40,'Luxembourg Bank','2134567812345678',2),(3,'2013-01-01','2020-01-01',567,34,'Luxembourg Bank','09900990099009900990',3),(4,'2013-01-01','2023-01-01',800,40,'Luxembourg Bank','8866668880455622009987',4),(5,'2013-01-01','2019-01-01',340,15,'Royal Bank','99333344440000000145558888',5),(6,'2016-01-01','2022-01-01',456,40,'TrierBank','GB33BUKB20201555555555',6);

--UNLOCK TABLES;

DROP TABLE IF EXISTS `units`;

-- SET character_set_client = utf8mb4 ;
CREATE TABLE `units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `boss_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_E9B07449727ACA70` (`parent_id`),
  KEY `IDX_E9B07449261FB672` (`boss_id`),
  CONSTRAINT `FK_E9B07449261FB672` FOREIGN KEY (`boss_id`) REFERENCES `personal_data` (`id`),
  CONSTRAINT `FK_E9B07449727ACA70` FOREIGN KEY (`parent_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `units`
--

--LOCK TABLES `units` WRITE;

INSERT INTO `units` VALUES (2,'Faculty of Computing','Faculty',NULL,1),(3,'Paralell Computing','Research',2,1),(4,'Faculty of Science','Faculty',NULL,6),(5,'Cell Researches','Research',4,6),(6,'HR department','Other',NULL,2);

--UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;

-- SET character_set_client = utf8mb4 ;
CREATE TABLE `membership` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `working_hours_per_week` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_86FFD285217BBB47` (`person_id`),
  KEY `IDX_86FFD285F8BD700D` (`unit_id`),
  CONSTRAINT `FK_86FFD285217BBB47` FOREIGN KEY (`person_id`) REFERENCES `personal_data` (`id`),
  CONSTRAINT `FK_86FFD285F8BD700D` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `membership`
--

--LOCK TABLES `membership` WRITE;

INSERT INTO `membership` VALUES (1,1,2,12),(2,4,2,40),(3,5,2,15),(4,6,4,40),(5,2,6,40),(6,3,6,30);

--UNLOCK TABLES;



--
-- Table structure for table `temporary_personal_data`
--

DROP TABLE IF EXISTS `temporary_personal_data`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `temporary_personal_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime NOT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `family_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birth_date` date NOT NULL,
  `birth_place` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `adres` json DEFAULT NULL,
  `emails` json DEFAULT NULL,
  `phone_numbers` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Dumping data for table `temporary_personal_data`
--

--LOCK TABLES `temporary_personal_data` WRITE;
--
--UNLOCK TABLES;

--
-- Table structure for table `units`
--

--
-- modify roles
--
ALTER TABLE user MODIFY COLUMN roles VARCHAR(255);

