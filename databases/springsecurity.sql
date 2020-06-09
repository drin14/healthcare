-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2020 at 02:02 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springsecurity`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `idappointment` int(11) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`idappointment`, `date`, `time`, `doctor_name`, `patient_name`) VALUES
(16, 'test', 12, 'test', 'lum'),
(18, 'test', 13, 'test', 'adis'),
(19, 'test', 15, 'test', 'adis'),
(20, 'test', 16, 'test', 'lum'),
(21, 'neser', 20, 'vjosa', 'lum');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(23);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `roles` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `roles`, `user_name`) VALUES
(1, 1, 'pass', 'ROLE_DOCTOR', 'user'),
(2, 1, 'drin123', 'ROLE_ADMIN', 'drin'),
(3, 1, 'lum123', 'ROLE_PATIENT', 'lum'),
(8, 1, 'adis123', 'ROLE_PATIENT', 'adis'),
(11, 1, 'vjosa123', 'ROLE_DOCTOR', 'vjosa'),
(12, 1, 'arber123', 'ROLE_ADMIN', 'arber'),
(13, 1, 'nora123', 'ROLE_ADMIN', 'nora');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`idappointment`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
