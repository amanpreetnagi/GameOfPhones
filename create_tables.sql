-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2017 at 09:26 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store`
--

-- --------------------------------------------------------

--
-- Table structure for table `monthly_revenue`
--

CREATE TABLE `monthly_revenue` (
  `revenueId` int(11) NOT NULL,
  `month` varchar(10) NOT NULL,
  `androidRevenue` int(11) DEFAULT NULL,
  `iosRevenue` int(11) DEFAULT NULL,
  `otherRevenue` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `os_sale`
--

CREATE TABLE `os_sale` (
  `salesId` int(11) NOT NULL,
  `androidSale` int(11) DEFAULT NULL,
  `iosSale` int(11) DEFAULT NULL,
  `otherSale` int(11) DEFAULT NULL,
  `saleDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------
--
-- Table structure for table `os_users`
--

CREATE TABLE `os_users` (
  `hoursId` int(11) NOT NULL,
  `week` varchar(30) DEFAULT NULL,
  `iosUsers` int(11) DEFAULT NULL,
  `androidUsers` int(11) DEFAULT NULL,
  `otherUsers` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------
--
-- Table structure for table `week_hours`
--

CREATE TABLE `week_hours` (
  `weekHoursId` int(11) NOT NULL,
  `day` char(20) DEFAULT NULL,
  `games` int(11) DEFAULT NULL,
  `utility` int(11) DEFAULT NULL,
  `music` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;