-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2024 at 11:23 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajemen_resto`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `nama`, `harga`) VALUES
(1, 'nasi goreng', 12500),
(2, 'air mineral', 3000),
(3, 'teh manis', 5000),
(4, 'mie goreng', 13000),
(8, 'baru', 111),
(12, 'fdsa', 11),
(13, 'fdsas', 22);

-- --------------------------------------------------------

--
-- Table structure for table `menu_pesanan`
--

CREATE TABLE `menu_pesanan` (
  `id` int(11) NOT NULL,
  `pesanan_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `jumlah_pesanan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_pesanan`
--

INSERT INTO `menu_pesanan` (`id`, `pesanan_id`, `menu_id`, `jumlah_pesanan`) VALUES
(7, 14, 1, 5),
(8, 14, 2, 1),
(9, 15, 2, 12),
(10, 15, 8, 11);

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id` int(11) NOT NULL,
  `tanggal` timestamp NOT NULL DEFAULT current_timestamp(),
  `total_biaya` double NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id`, `tanggal`, `total_biaya`, `user_id`) VALUES
(14, '2024-11-25 15:28:04', 65500, 8),
(15, '2024-11-28 07:26:27', 37221, 8),
(16, '2023-10-01 03:00:00', 100.5, 8),
(17, '2023-10-05 05:30:00', 200.75, 8),
(18, '2023-10-10 07:45:00', 150, 8),
(19, '2023-10-15 02:15:00', 300.2, 8),
(20, '2023-10-20 09:00:00', 250, 8),
(21, '2023-10-22 04:30:00', 400, 8),
(22, '2023-10-25 01:00:00', 175.9, 8),
(23, '2023-10-28 12:00:00', 225.45, 8),
(24, '2023-10-30 06:00:00', 320.1, 8),
(25, '2023-10-31 08:00:00', 180.6, 8),
(26, '2024-11-22 17:00:00', 100.5, 8),
(27, '2024-11-25 17:00:00', 200.75, 8),
(28, '2024-11-26 17:00:00', 150, 8),
(29, '2024-11-21 17:00:00', 300.2, 8),
(30, '2024-11-25 17:00:00', 250, 8),
(31, '2024-11-24 17:00:00', 400, 8),
(32, '2024-11-22 17:00:00', 175.9, 8),
(33, '2024-11-25 17:00:00', 225.45, 8),
(34, '2024-11-26 17:00:00', 320.1, 8),
(35, '2024-11-21 17:00:00', 180.6, 8),
(36, '2024-11-17 17:00:00', 100.5, 8),
(37, '2024-11-01 17:00:00', 200.75, 8),
(38, '2024-11-18 17:00:00', 150, 8),
(39, '2024-11-01 17:00:00', 300.2, 8),
(40, '2024-11-11 17:00:00', 250, 8);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `no_telp` varchar(16) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL DEFAULT 'pelanggan'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `no_telp`, `password`, `role`) VALUES
(1, 'admin', '0812343243', '1234', 'admin'),
(6, 'baru', '345', 'pass', 'pelanggan'),
(7, 'rba', '2342', 'fdsa', 'pelanggan'),
(8, 'coba', '123', 'pass', 'pelanggan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nama` (`nama`);

--
-- Indexes for table `menu_pesanan`
--
ALTER TABLE `menu_pesanan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pesanan_id` (`pesanan_id`),
  ADD KEY `menu_id` (`menu_id`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `menu_pesanan`
--
ALTER TABLE `menu_pesanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menu_pesanan`
--
ALTER TABLE `menu_pesanan`
  ADD CONSTRAINT `menu_pesanan_ibfk_1` FOREIGN KEY (`pesanan_id`) REFERENCES `pesanan` (`id`),
  ADD CONSTRAINT `menu_pesanan_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`);

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `pesanan_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
