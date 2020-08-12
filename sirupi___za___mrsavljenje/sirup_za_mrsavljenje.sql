-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 12, 2020 at 02:10 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sirup_za_mrsavljenje`
--

-- --------------------------------------------------------

--
-- Table structure for table `narudzbina`
--

CREATE TABLE `narudzbina` (
  `narudzbinaID` int(11) NOT NULL,
  `sirupID` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `datumPreuzimanja` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `narudzbina`
--

INSERT INTO `narudzbina` (`narudzbinaID`, `sirupID`, `kolicina`, `datumPreuzimanja`) VALUES
(8, 2, 9, '2020-08-08 15:09:35'),
(9, 3, 3, '2020-08-08 17:29:30'),
(10, 6, 6, '2020-08-09 12:11:03'),
(11, 3, 4, '2020-08-09 12:47:24'),
(12, 4, 3, '2020-08-10 11:55:17');

-- --------------------------------------------------------

--
-- Table structure for table `sirup`
--

CREATE TABLE `sirup` (
  `sirupID` int(11) NOT NULL,
  `nazivVrste` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cenaSirupa` decimal(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sirup`
--

INSERT INTO `sirup` (`sirupID`, `nazivVrste`, `cenaSirupa`) VALUES
(2, 'Amazon', '1000.00'),
(3, 'Detox', '900.00'),
(4, 'Elixir', '800.00'),
(5, 'Honey', '950.00'),
(6, 'Cinnamon', '1100.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD PRIMARY KEY (`narudzbinaID`);

--
-- Indexes for table `sirup`
--
ALTER TABLE `sirup`
  ADD PRIMARY KEY (`sirupID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `narudzbina`
--
ALTER TABLE `narudzbina`
  MODIFY `narudzbinaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sirup`
--
ALTER TABLE `sirup`
  MODIFY `sirupID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
