-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 11:31 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arsoppgave`
--

-- --------------------------------------------------------

--
-- Table structure for table `arsoppgave`
--

CREATE TABLE `arsoppgave` (
  `id` int(11) NOT NULL,
  `navn` varchar(255) DEFAULT NULL,
  `hp` int(255) DEFAULT NULL,
  `wpn` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `arsoppgave`
--

INSERT INTO `arsoppgave` (`id`, `navn`, `hp`, `wpn`, `position`) VALUES
(9, 'Uy', 15, 'Fist', ' backBedRoom'),
(11, 'Navn', 15, 'Fist', 'backBedRoom'),
(19, 'Uuyyy', 14, 'Fist', 'backBedRoom'),
(32, 'Navsadn', 15, 'Fist', 'backBedRoom'),
(33, 'ds', 9, 'Fist', 'win'),
(34, 'iy', 14, 'Fist', 'whoYouLady'),
(35, 'ds', 9, 'Fist', 'win'),
(36, 'asdasd', 10, 'Knife', 'rewardKnife'),
(37, 'nbb', 7, 'Knife', 'goOutDoor'),
(38, 'asdas', 15, 'Fist', 'searchRoom'),
(39, 'bbbb', 15, 'Fist', 'backBedRoom'),
(40, 'bbbb', 15, 'Fist', 'BedDoor'),
(42, 'nbb', 7, 'Knife', 'goOutDoor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `arsoppgave`
--
ALTER TABLE `arsoppgave`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `arsoppgave`
--
ALTER TABLE `arsoppgave`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
