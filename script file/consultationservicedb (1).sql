-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 03, 2023 at 02:08 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `consultationservicedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE IF NOT EXISTS `appointments` (
  `appointment_id` varchar(50) NOT NULL,
  `consultant_id` varchar(50) DEFAULT NULL,
  `job_seeker_id` varchar(50) DEFAULT NULL,
  `appointment_date` varchar(50) DEFAULT NULL,
  `appointment_time` varchar(50) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `job_type_specialization_id` varchar(50) NOT NULL,
  `country_specialization_id` varchar(50) NOT NULL,
  PRIMARY KEY (`appointment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`appointment_id`, `consultant_id`, `job_seeker_id`, `appointment_date`, `appointment_time`, `status`, `job_type_specialization_id`, `country_specialization_id`) VALUES
('APP00002', 'CON00006', 'JBS00002', '2023-08-16', '13:56', 'Completed', 'JT00002', 'CTS00007'),
('APP00003', 'CON00006', 'JBS00003', '2023-08-16', '13:56', 'Accepted', 'JT00002', 'CTS00007'),
('APP00004', NULL, 'JBS00004', '2023-09-01', '23:09', 'Accepted', 'JT00002', 'CTS00007'),
('APP00005', '', 'JBS00005', '2023-09-05', '20:32', 'Pending', 'JT00001', 'CTS00007');

-- --------------------------------------------------------

--
-- Table structure for table `consultants`
--

DROP TABLE IF EXISTS `consultants`;
CREATE TABLE IF NOT EXISTS `consultants` (
  `consultant_id` varchar(50) NOT NULL,
  `employee_id` varchar(50) DEFAULT NULL,
  `country_specialization_id` varchar(50) DEFAULT NULL,
  `job_type_specialization_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`consultant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `consultants`
--

INSERT INTO `consultants` (`consultant_id`, `employee_id`, `country_specialization_id`, `job_type_specialization_id`) VALUES
('CON00006', 'EMP00005', 'CTS00007', 'JT00002');

-- --------------------------------------------------------

--
-- Table structure for table `country_specialization`
--

DROP TABLE IF EXISTS `country_specialization`;
CREATE TABLE IF NOT EXISTS `country_specialization` (
  `country_specialization_id` varchar(50) NOT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`country_specialization_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `country_specialization`
--

INSERT INTO `country_specialization` (`country_specialization_id`, `country_name`) VALUES
('1', 'New Zealand'),
('CTS00006', 'UK'),
('CTS00007', 'Sri Lanka ');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` varchar(50) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `nic` varchar(50) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_no` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `full_name`, `dob`, `nic`, `user_type`, `address`, `contact_no`, `email`, `password`) VALUES
('EMP00005', 'Ashoka', '2023-08-01', '199802123456', 'admin', 'no.5,vijaya mw, samanpura, dambulla', '0874561234', 'ashoka@gmail.com', '1'),
('EMP00006', 'Chathuranga', '2023-08-03', '123456789', 'normal', 'No.12 ,naranitiya, colombo', '0781234567', 'chathuranga@gmail.com', '1');

-- --------------------------------------------------------

--
-- Table structure for table `job_seekers`
--

DROP TABLE IF EXISTS `job_seekers`;
CREATE TABLE IF NOT EXISTS `job_seekers` (
  `job_seeker_id` varchar(50) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`job_seeker_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `job_seekers`
--

INSERT INTO `job_seekers` (`job_seeker_id`, `full_name`, `contact_number`, `email`, `address`) VALUES
('JBS00001', 'Sanjalie', '0764817067', 'sanjalie@gmail.com', 'no.56,malkaduwawa , kurunegala'),
('JBS00002', 'Akmal', '0671234567', 'akmal@gmail.com', 'no.87, bauddhaloka , colombo'),
('JBS00003', 'Wikramasinghe', '789345221', 'wikrama@gmail.com', 'no.23, samanpola, ibbagamuwa'),
('JBS00004', 'Gauthmi', '076485617070', 'gauthmi@gmail.com', 'no89, thissa mawatha, plonarurawa'),
('JBS00005', 'Sanjalie', '0764815678', 'dushmanp123@gmail.com', 'no.56, jayatnhi mw, samanpola, kurunegala ');

-- --------------------------------------------------------

--
-- Table structure for table `job_type_specialization`
--

DROP TABLE IF EXISTS `job_type_specialization`;
CREATE TABLE IF NOT EXISTS `job_type_specialization` (
  `job_type_specialization_id` varchar(50) NOT NULL,
  `job_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`job_type_specialization_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `job_type_specialization`
--

INSERT INTO `job_type_specialization` (`job_type_specialization_id`, `job_type_name`) VALUES
('JT00002', 'Teaching'),
('JT00001', 'Software Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `number_primary_key_generator`
--

DROP TABLE IF EXISTS `number_primary_key_generator`;
CREATE TABLE IF NOT EXISTS `number_primary_key_generator` (
  `table_name` varchar(50) NOT NULL,
  `prefix` varchar(50) DEFAULT NULL,
  `number_part` int DEFAULT NULL,
  PRIMARY KEY (`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `number_primary_key_generator`
--

INSERT INTO `number_primary_key_generator` (`table_name`, `prefix`, `number_part`) VALUES
('country_specialization', 'CTS', 8),
('job_type_specialization', 'JT', 2),
('employee', 'EMP', 6),
('consultants', 'CON', 6),
('appointments', 'APP', 5),
('job_seekers', 'JBS', 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
