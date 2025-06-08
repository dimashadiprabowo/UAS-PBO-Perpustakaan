-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2025 at 04:36 PM
-- Server version: 8.0.39
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `litera`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` int NOT NULL,
  `nama` varchar(45) NOT NULL,
  `tempat_lahir` varchar(41) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id_anggota`, `nama`, `tempat_lahir`, `tanggal_lahir`, `tanggal`) VALUES
(1200, 'Vania Ardelia Zahra', 'Bekasi', '2005-03-03', '2025-03-23'),
(1201, 'Jaizah Lutfiyah', 'Bekasi', '2005-01-01', '2025-03-24'),
(1202, 'Raka Firmansyah', 'Depok', '2004-06-14', '2025-03-25'),
(1203, 'Nabila Khairunnisa', 'Bogor', '2005-08-22', '2025-03-26'),
(1204, 'Dimas Pratama', 'Tangerang', '2003-10-09', '2025-03-27'),
(1205, 'Aulia Rahmawati', 'Cikarang', '2004-01-30', '2025-03-28'),
(1206, 'Rizky Aditya', 'Karawang', '2004-11-18', '2025-03-29'),
(1207, 'Fahmi Setiawan', 'Bekasi', '2005-07-07', '2025-03-30'),
(1208, 'Putri Oktaviani', 'Jakarta', '2004-02-02', '2025-03-31'),
(1209, 'Zahra Mardhiyah', 'Bandung', '2005-05-25', '2025-03-31'),
(1210, 'Paramesti Gita Khairunnisa', 'Bekasi', '2006-12-30', '2025-05-30');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` int NOT NULL,
  `kode` varchar(8) NOT NULL,
  `jenis` int NOT NULL,
  `judul` varchar(68) NOT NULL,
  `tanggal` date NOT NULL,
  `pengarang` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `kode`, `jenis`, `judul`, `tanggal`, `pengarang`) VALUES
(1, '23NOVL', 1, 'Laskar Pelangi', '2025-01-10', 'Andrea Hirata'),
(2, '23ENSK', 2, 'Ensiklopedia Sains Modern', '2025-01-12', 'Tim Ilmuwan Indonesia'),
(3, '23PLJR', 3, 'Matematika Wajib SMA Kelas 12', '2025-01-13', 'Sutrisno Ahmad'),
(4, '23NVL2', 1, 'Bumi', '2024-11-05', 'Tere Liye'),
(5, '23ENS2', 2, 'Ensiklopedia Dunia Hewan', '2025-01-16', 'Dr. Faizal Rahman'),
(6, '23PLJ2', 3, 'Fisika SMA Kelas 11', '2025-01-18', 'Nina Setyaningsih'),
(7, '23NVL3', 1, 'Negeri 5 Menara', '2024-08-22', 'Ahmad Fuadi'),
(8, '23ENS3', 2, 'Ensiklopedia Teknologi', '2025-01-21', 'Rendy Saputra'),
(9, '23PLJ3', 3, 'Bahasa Indonesia Kelas 10', '2025-01-23', 'Yuni Puspitasari'),
(10, '23NVL4', 1, 'Ayah', '2025-01-24', 'Andrea Hirata'),
(11, '23ENS4', 2, 'Ensiklopedia Islam', '2025-01-25', 'Dr. Yusuf Maulana'),
(12, '23PLJ4', 3, 'Sejarah Indonesia Kelas 12', '2023-06-30', 'Dewi Ayu Lestari'),
(13, '23NVL5', 1, 'Hujan', '2024-05-17', 'Tere Liye'),
(14, '23ENS5', 2, 'Ensiklopedia Alam Semesta', '2025-01-28', 'Dr. Lintang Bintang'),
(15, '23PLJ5', 1, 'Kimia SMA Kelas 12', '2025-01-29', 'Putri Anggraini');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` int NOT NULL,
  `id_anggota` int DEFAULT NULL,
  `nama` varchar(45) NOT NULL,
  `kode` varchar(8) NOT NULL,
  `judul` varchar(68) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `id_anggota`, `nama`, `kode`, `judul`, `tanggal`) VALUES
(1, 1200, 'Vania Ardelia Zahra', '23NOVL', 'Laskar Pelangi', '2025-03-23'),
(2, 1201, 'Jaizah Lutfiyah', '23PLJR', 'Matematika Wajib SMA Kelas 12', '2025-03-24'),
(3, 1202, 'Raka Firmansyah', '23ENSK', 'Ensiklopedia Sains Modern', '2025-03-25'),
(4, 1203, 'Nabila Khairunnisa', '23NVL2', 'Bumi', '2025-03-26'),
(5, 1204, 'Dimas Pratama', '23PLJ2', 'Fisika SMA Kelas 11', '2025-03-27'),
(6, 1205, 'Aulia Rahmawati', '23NVL3', 'Negeri 5 Menara', '2025-03-28'),
(7, 1206, 'Rizky Aditya', '23ENS3', 'Ensiklopedia Teknologi', '2025-03-29'),
(8, 1207, 'Fahmi Setiawan', '23PLJ3', 'Bahasa Indonesia Kelas 10', '2025-03-30'),
(9, 1208, 'Putri Oktaviani', '23NVL4', 'Ayah', '2025-03-31'),
(10, 1209, 'Zahra Mardhiyah', '23ENS4', 'Ensiklopedia Islam', '2025-03-31');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `username`, `password`) VALUES
(1001, 'shafaaulia2', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`,`kode`) USING BTREE;

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `fk_id_anggota` (`id_anggota`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id_anggota` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1212;

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id_peminjaman` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id_petugas` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `fk_id_anggota` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
