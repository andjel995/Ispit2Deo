-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2020 at 07:51 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bazaispit`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

CREATE TABLE `angazovanje` (
  `angazovanjeid` bigint(20) NOT NULL,
  `tipNastave` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `predmet` bigint(20) NOT NULL,
  `profesor` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `angazovanje`
--

INSERT INTO `angazovanje` (`angazovanjeid`, `tipNastave`, `predmet`, `profesor`) VALUES
(32, 'Predavanja', 1, 1),
(33, 'LabaratorijskeVezbe', 1, 3),
(38, 'Predavanja', 1, 4),
(46, 'LabaratorijskeVezbe', 4, 5),
(49, 'Predavanja', 2, 2),
(51, 'Predavanja', 4, 1),
(52, 'Predavanja', 4, 3),
(53, 'Predavanja', 4, 4),
(54, 'Predavanja', 5, 3),
(55, 'Vezbe', 5, 2),
(56, 'Predavanja', 5, 1),
(57, 'Predavanja', 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnikId` bigint(20) NOT NULL,
  `korisnickoIme` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lozinka` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnikId`, `korisnickoIme`, `lozinka`, `ime`, `prezime`) VALUES
(1, 'jovana1', 'jovana1', 'Jovana', 'Andjelkovic'),
(2, 'sara1', 'sara1', 'Sara', 'Petrovic'),
(3, 'jelena', 'jelena', 'Jelena', 'Andric');

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `predmetId` bigint(20) NOT NULL,
  `naziv` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`predmetId`, `naziv`) VALUES
(1, 'Matematika'),
(2, 'Osnove ekonomije'),
(3, 'Pravo'),
(4, 'Engleski'),
(5, 'Fizika'),
(6, 'Sistemi');

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

CREATE TABLE `profesor` (
  `profesorId` bigint(20) NOT NULL,
  `ime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `profesor`
--

INSERT INTO `profesor` (`profesorId`, `ime`, `prezime`) VALUES
(1, 'Sasa', 'Nikolic'),
(2, 'Marko', 'Savic'),
(3, 'Sanja', 'Petrovic'),
(4, 'Aleksa', 'Peric'),
(5, 'Sandra', 'Velickovic');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD PRIMARY KEY (`angazovanjeid`),
  ADD KEY `fk2` (`predmet`),
  ADD KEY `fk4` (`profesor`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnikId`);

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`predmetId`);

--
-- Indexes for table `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`profesorId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angazovanje`
--
ALTER TABLE `angazovanje`
  MODIFY `angazovanjeid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnikId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `predmetId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `profesor`
--
ALTER TABLE `profesor`
  MODIFY `profesorId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`predmet`) REFERENCES `predmet` (`predmetId`),
  ADD CONSTRAINT `fk4` FOREIGN KEY (`profesor`) REFERENCES `profesor` (`profesorId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
