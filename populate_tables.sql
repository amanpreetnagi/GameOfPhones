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
-- Dumping data for table `monthly_revenue`
--

INSERT INTO `monthly_revenue` (`revenueId`, `month`, `androidRevenue`, `iosRevenue`, `otherRevenue`) VALUES
(1, 'jan', 4500, 5200, 4800),
(2, 'feb', 4090, 4330, 4410),
(3, 'mar', 4240, 5140, 3820),
(4, 'apr', 3900, 5300, 5000),
(5, 'may', 3480, 4060, 3880),
(6, 'jun', 4210, 4100, 4330),
(7, 'jul', 4000, 3970, 3870),
(8, 'aug', 3660, 4141, 4438),
(9, 'sep', 3820, 4610, 4110),
(10, 'oct', 4440, 4190, 4300),
(11, 'nov', 3470, 3770, 3390),
(12, 'dec', 4850, 5240, 5010);

-- --------------------------------------------------------
--
-- Dumping data for table `os_sale`
--

INSERT INTO `os_sale` (`salesId`, `androidSale`, `iosSale`, `otherSale`, `saleDate`) VALUES
(1, 30, 39, 36, '2017-03-20'),
(2, 18, 27, 31, '2017-03-21'),
(3, 22, 23, 20, '2017-03-22'),
(4, 24, 23, 20, '2017-03-23'),
(5, 40, 42, 48, '2017-03-24'),
(6, 21, 35, 45, '2017-03-25'),
(7, 43, 50, 41, '2017-03-26');

-- --------------------------------------------------------
--
-- Dumping data for table `os_users`
--

INSERT INTO `os_users` (`hoursId`, `week`, `iosUsers`, `androidUsers`, `otherUsers`) VALUES
(1, 'Week 1', 22000, 14000, 19000),
(2, 'Week 2', 30000, 20000, 16000),
(3, 'Week 3', 20000, 21000, 18000),
(4, 'Week 4', 28000, 18050, 30000),
(5, 'Week 5', 12000, 17000, 16000);

-- --------------------------------------------------------
--
-- Dumping data for table `week_hours`
--

INSERT INTO `week_hours` (`weekHoursId`, `day`, `games`, `utility`, `music`) VALUES
(1, 'Monday', 10, 8, 4),
(2, 'Tuesday', 14, 12, 11),
(3, 'Wednesday', 12, 13, 7),
(4, 'Thursday', 11, 14, 14),
(5, 'Friday', 12, 10, 11),
(6, 'Saturday', 8, 6, 5),
(7, 'Sunday', 6, 5, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monthly_revenue`
--
ALTER TABLE `monthly_revenue`
  ADD PRIMARY KEY (`revenueId`);

--
-- Indexes for table `os_sale`
--
ALTER TABLE `os_sale`
  ADD PRIMARY KEY (`salesId`),
  ADD UNIQUE KEY `Games_Sale_salesId_uindex` (`salesId`);

--
-- Indexes for table `os_users`
--
ALTER TABLE `os_users`
  ADD PRIMARY KEY (`hoursId`),
  ADD UNIQUE KEY `GamesHours_hoursId_uindex` (`hoursId`);

--
-- Indexes for table `week_hours`
--
ALTER TABLE `week_hours`
  ADD PRIMARY KEY (`weekHoursId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `monthly_revenue`
--
ALTER TABLE `monthly_revenue`
  MODIFY `revenueId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `os_sale`
--
ALTER TABLE `os_sale`
  MODIFY `salesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `os_users`
--
ALTER TABLE `os_users`
  MODIFY `hoursId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `week_hours`
--
ALTER TABLE `week_hours`
  MODIFY `weekHoursId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
