-- MySQL dump 10.10
--
-- Host: localhost    Database: personnel
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

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
-- Table structure for table `bak`
--

DROP TABLE IF EXISTS `bak`;
CREATE TABLE `bak` (
  `bakId` varchar(200) NOT NULL,
  `opId` varchar(200) default NULL,
  `bakRemark` varchar(200) default NULL,
  `bakDate` datetime default NULL,
  `path` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`bakId`),
  KEY `FK17C0C16837361` (`opId`),
  CONSTRAINT `FK17C0C16837361` FOREIGN KEY (`opId`) REFERENCES `operater` (`opId`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`opId`) REFERENCES `operater` (`opId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bak`
--


/*!40000 ALTER TABLE `bak` DISABLE KEYS */;
LOCK TABLES `bak` WRITE;
INSERT INTO `bak` VALUES ('123','1','efd','2014-08-27 23:24:20','ef',0),('222','1','sajfk','2014-09-20 23:24:07','dsfjk',0),('2fre','1','sdfg','2014-09-11 23:24:48','sdfds',0),('adfdsaf','1','ersfdsaefsad','2014-09-20 18:17:53','asdfsdf',0),('dsf','1','sdfg','2014-09-11 23:24:48','sdfds',0),('dsfdsf','1','sdfg','2014-09-11 23:24:48','sdfds',0),('dsfsdfg','1','sdfg','2014-09-11 23:24:48','sdfds',0),('dskglsad','1','sdfg','2014-09-11 23:24:48','sdfds',0),('gf','1','sdfg','2014-09-11 23:24:48','sdfds',0),('sdjfk','1','sdfg','2014-09-11 23:24:48','sdfds',0),('sef','1','sdfg','2014-09-11 23:24:48','sdfds',0),('wewq','1','sdfg','2014-09-11 23:24:48','sdfds',0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `bak` ENABLE KEYS */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` varchar(200) NOT NULL,
  `departmentName` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--


/*!40000 ALTER TABLE `department` DISABLE KEYS */;
LOCK TABLES `department` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

--
-- Table structure for table `dept_job_rel`
--

DROP TABLE IF EXISTS `dept_job_rel`;
CREATE TABLE `dept_job_rel` (
  `dept_job_relId` varchar(200) NOT NULL,
  `salaryId` varchar(200) default NULL,
  `departmentId` varchar(200) default NULL,
  `jobId` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`dept_job_relId`),
  KEY `FK5A2ED1DBA09BAB6` (`departmentId`),
  KEY `FK5A2ED1D6137DBE` (`jobId`),
  KEY `FK5A2ED1DF7CD5D26` (`salaryId`),
  CONSTRAINT `FK5A2ED1D6137DBE` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`),
  CONSTRAINT `FK5A2ED1DBA09BAB6` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `FK5A2ED1DF7CD5D26` FOREIGN KEY (`salaryId`) REFERENCES `salary` (`salaryId`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`salaryId`) REFERENCES `salary` (`salaryId`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dept_job_rel`
--


/*!40000 ALTER TABLE `dept_job_rel` DISABLE KEYS */;
LOCK TABLES `dept_job_rel` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `dept_job_rel` ENABLE KEYS */;

--
-- Table structure for table `diction_log`
--

DROP TABLE IF EXISTS `diction_log`;
CREATE TABLE `diction_log` (
  `sId` varchar(200) NOT NULL,
  `pId` varchar(200) default NULL,
  `name` varchar(200) default NULL,
  `diction_logDate` datetime default NULL,
  `diction_logRemark` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`sId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `diction_log`
--


/*!40000 ALTER TABLE `diction_log` DISABLE KEYS */;
LOCK TABLES `diction_log` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `diction_log` ENABLE KEYS */;

--
-- Table structure for table `duty`
--

DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `dutyId` varchar(200) NOT NULL,
  `dutyName` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`dutyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `duty`
--


/*!40000 ALTER TABLE `duty` DISABLE KEYS */;
LOCK TABLES `duty` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `duty` ENABLE KEYS */;

--
-- Table structure for table `encorchast`
--

DROP TABLE IF EXISTS `encorchast`;
CREATE TABLE `encorchast` (
  `encOrChastId` varchar(200) NOT NULL,
  `personnelEncOrChastPoint` decimal(10,0) default NULL,
  `money` decimal(10,0) default NULL,
  `personnelEncOrChastSort` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`encOrChastId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `encorchast`
--


/*!40000 ALTER TABLE `encorchast` DISABLE KEYS */;
LOCK TABLES `encorchast` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `encorchast` ENABLE KEYS */;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `jobId` varchar(200) NOT NULL,
  `jobName` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job`
--


/*!40000 ALTER TABLE `job` DISABLE KEYS */;
LOCK TABLES `job` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` varchar(200) NOT NULL,
  `men_menuId` varchar(200) default NULL,
  `menuName` varchar(200) default NULL,
  `menuUrl` varchar(200) default NULL,
  `remark` varchar(200) default NULL,
  `menuDate` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`menuId`),
  KEY `FK33155F876AEF59` (`men_menuId`),
  CONSTRAINT `FK33155F876AEF59` FOREIGN KEY (`men_menuId`) REFERENCES `menu` (`menuId`),
  CONSTRAINT `FK_Relationship_18` FOREIGN KEY (`men_menuId`) REFERENCES `menu` (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu`
--


/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
LOCK TABLES `menu` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log` (
  `operate_logId` varchar(200) NOT NULL,
  `opId` varchar(200) default NULL,
  `bakDate` datetime default NULL,
  `event` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`operate_logId`),
  KEY `FK77B7A0916837361` (`opId`),
  CONSTRAINT `FK77B7A0916837361` FOREIGN KEY (`opId`) REFERENCES `operater` (`opId`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`opId`) REFERENCES `operater` (`opId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `operate_log`
--


/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
LOCK TABLES `operate_log` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;

--
-- Table structure for table `operater`
--

DROP TABLE IF EXISTS `operater`;
CREATE TABLE `operater` (
  `opId` varchar(200) NOT NULL,
  `personnelId` varchar(200) default NULL,
  `popedom` varchar(200) default NULL,
  `opName` varchar(200) default NULL,
  `opPassword` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`opId`),
  KEY `FKE22A276ECAA98332` (`personnelId`),
  CONSTRAINT `FKE22A276ECAA98332` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `operater`
--


/*!40000 ALTER TABLE `operater` DISABLE KEYS */;
LOCK TABLES `operater` WRITE;
INSERT INTO `operater` VALUES ('1',NULL,NULL,'lc','lc',0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `operater` ENABLE KEYS */;

--
-- Table structure for table `peoc`
--

DROP TABLE IF EXISTS `peoc`;
CREATE TABLE `peoc` (
  `peocId` varchar(200) NOT NULL,
  `encOrChastId` varchar(200) default NULL,
  `personnelId` varchar(200) default NULL,
  `peocDate` datetime default NULL,
  `peocReason` varchar(200) default NULL,
  `personnelTrainRemark` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`peocId`),
  KEY `FK347289EDA82452` (`encOrChastId`),
  KEY `FK347289CAA98332` (`personnelId`),
  CONSTRAINT `FK347289CAA98332` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`),
  CONSTRAINT `FK347289EDA82452` FOREIGN KEY (`encOrChastId`) REFERENCES `encorchast` (`encOrChastId`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`encOrChastId`) REFERENCES `encorchast` (`encOrChastId`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `peoc`
--


/*!40000 ALTER TABLE `peoc` DISABLE KEYS */;
LOCK TABLES `peoc` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `peoc` ENABLE KEYS */;

--
-- Table structure for table `personneladjustsalary`
--

DROP TABLE IF EXISTS `personneladjustsalary`;
CREATE TABLE `personneladjustsalary` (
  `personnelAdjustSalaryId` varchar(200) NOT NULL,
  `dept_job_relId` varchar(200) default NULL,
  `adjustSalaryDate` datetime default NULL,
  `adjustSalaryReason` varchar(200) default NULL,
  `personnelAdjustSalaryRemark` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`personnelAdjustSalaryId`),
  KEY `FK71267C39C323ECB0` (`dept_job_relId`),
  CONSTRAINT `FK71267C39C323ECB0` FOREIGN KEY (`dept_job_relId`) REFERENCES `dept_job_rel` (`dept_job_relId`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`dept_job_relId`) REFERENCES `dept_job_rel` (`dept_job_relId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personneladjustsalary`
--


/*!40000 ALTER TABLE `personneladjustsalary` DISABLE KEYS */;
LOCK TABLES `personneladjustsalary` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `personneladjustsalary` ENABLE KEYS */;

--
-- Table structure for table `personnelappraise`
--

DROP TABLE IF EXISTS `personnelappraise`;
CREATE TABLE `personnelappraise` (
  `personnelAppraiseId` varchar(200) NOT NULL,
  `personnelId` varchar(200) default NULL,
  `personnelAppraiseDate` datetime default NULL,
  `personnelAppraiseResult` varchar(200) default NULL,
  `personnelAppraiseContent` varchar(200) default NULL,
  `personnelAppraiseRemark` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`personnelAppraiseId`),
  KEY `FKAB158C8BCAA98332` (`personnelId`),
  CONSTRAINT `FKAB158C8BCAA98332` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personnelappraise`
--


/*!40000 ALTER TABLE `personnelappraise` DISABLE KEYS */;
LOCK TABLES `personnelappraise` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `personnelappraise` ENABLE KEYS */;

--
-- Table structure for table `personnelinfo`
--

DROP TABLE IF EXISTS `personnelinfo`;
CREATE TABLE `personnelinfo` (
  `personnelId` varchar(200) NOT NULL,
  `dutyId` varchar(200) default NULL,
  `dept_job_relId` varchar(200) default NULL,
  `personnelNo` varchar(200) default NULL,
  `personnelName` varchar(200) default NULL,
  `personnelSex` varchar(200) default NULL,
  `birthday` datetime default NULL,
  `age` int(11) default NULL,
  `identityId` varchar(200) default NULL,
  `wedLock` varchar(200) default NULL,
  `race` varchar(200) default NULL,
  `nativePlace` varchar(200) default NULL,
  `politic` varchar(200) default NULL,
  `e_mail` varchar(200) default NULL,
  `phone` varchar(200) default NULL,
  `address` varchar(200) default NULL,
  `engageForm` varchar(200) default NULL,
  `tipTopDegree` varchar(200) default NULL,
  `spacialty` varchar(200) default NULL,
  `school` varchar(200) default NULL,
  `beginWorkDate` datetime default NULL,
  `workState` varchar(200) default NULL,
  `workId` varchar(200) default NULL,
  `contractTerm` int(11) default NULL,
  `beFormDate` datetime default NULL,
  `notWorkState` datetime default NULL,
  `beginContract` datetime default NULL,
  `endContract` datetime default NULL,
  `workAge` int(11) default NULL,
  `score` int(11) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`personnelId`),
  KEY `FKC71626CEB2797DFE` (`dutyId`),
  KEY `FKC71626CEC323ECB0` (`dept_job_relId`),
  CONSTRAINT `FKC71626CEB2797DFE` FOREIGN KEY (`dutyId`) REFERENCES `duty` (`dutyId`),
  CONSTRAINT `FKC71626CEC323ECB0` FOREIGN KEY (`dept_job_relId`) REFERENCES `dept_job_rel` (`dept_job_relId`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`dept_job_relId`) REFERENCES `dept_job_rel` (`dept_job_relId`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`dutyId`) REFERENCES `duty` (`dutyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personnelinfo`
--


/*!40000 ALTER TABLE `personnelinfo` DISABLE KEYS */;
LOCK TABLES `personnelinfo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `personnelinfo` ENABLE KEYS */;

--
-- Table structure for table `personnelremove`
--

DROP TABLE IF EXISTS `personnelremove`;
CREATE TABLE `personnelremove` (
  `personnelRemoveId` varchar(200) NOT NULL,
  `personnelId` varchar(200) default NULL,
  `afterRemoveDepartment` varchar(200) default NULL,
  `beforeRemoveDepartment` varchar(200) default NULL,
  `afterRemoveJob` varchar(200) default NULL,
  `beforeRemoveJob` varchar(200) default NULL,
  `removeDate` datetime default NULL,
  `removeReason` varchar(200) default NULL,
  `personnelRemoveRemark` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`personnelRemoveId`),
  KEY `FK6907B2A4CAA98332` (`personnelId`),
  CONSTRAINT `FK6907B2A4CAA98332` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personnelremove`
--


/*!40000 ALTER TABLE `personnelremove` DISABLE KEYS */;
LOCK TABLES `personnelremove` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `personnelremove` ENABLE KEYS */;

--
-- Table structure for table `personneltrain`
--

DROP TABLE IF EXISTS `personneltrain`;
CREATE TABLE `personneltrain` (
  `personnelTrainId` varchar(200) NOT NULL,
  `personnelId` varchar(200) default NULL,
  `personnelTrainDate` datetime default NULL,
  `personnelTrainConten` varchar(200) default NULL,
  `personnelTrainRemark` varchar(200) default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`personnelTrainId`),
  KEY `FK1C4B73E8CAA98332` (`personnelId`),
  CONSTRAINT `FK1C4B73E8CAA98332` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`personnelId`) REFERENCES `personnelinfo` (`personnelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personneltrain`
--


/*!40000 ALTER TABLE `personneltrain` DISABLE KEYS */;
LOCK TABLES `personneltrain` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `personneltrain` ENABLE KEYS */;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `salaryId` varchar(200) NOT NULL,
  `bonus` decimal(10,0) default NULL,
  `lunchSalary` decimal(10,0) default NULL,
  `trafficSalary` decimal(10,0) default NULL,
  `basicSalary` decimal(10,0) default NULL,
  `allSalary` decimal(10,0) default NULL,
  `useredDate` datetime default NULL,
  `isDelete` int(11) default NULL,
  PRIMARY KEY  (`salaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `salary`
--


/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
LOCK TABLES `salary` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

