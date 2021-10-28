-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 28, 2021 lúc 04:51 AM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `usermanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(250) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `address`, `birthday`, `sex`, `description`) VALUES
(1, 'hoangloc', '123456', 'Ha Noi', '2000-09-15', 'Male', 'Love butterflies, hate birds'),
(2, 'duydamdang2k', '12345678', 'Ha Noi', '2000-01-01', 'Male', 'Naughty LTV'),
(3, 'ngthanhbinh', '123456', 'Ha Noi', '2000-03-20', 'Male', 'Javascript Master'),
(4, 'huyencute', 'qwerty', 'Ho Chi Minh', '2000-01-10', 'Female', 'FWB, ONS, 429'),
(5, 'baolong1102', 'bodoi', 'Ha Noi', '2000-03-29', 'Male', 'You only live once'),
(6, 'katilyn', '123456', 'Nghe An', '2000-04-20', 'Female', 'Have to be strong'),
(7, 'thaongoc', '123456', 'Da Nang', '2000-11-11', 'Female', 'FPT university'),
(8, 'thutrang', '123456', 'Vung Tau', '2000-05-17', 'Female', 'Lovely pussy cat'),
(9, 'hienthu', '123456', 'Hai Phong', '1999-02-02', 'Female', 'Lady of the house'),
(10, 'dohieu', '123456', 'Ha Noi', '2001-10-05', 'Male', 'Master of Java'),
(11, 'linhnhi', '123456', 'Ha Noi', '2000-10-10', 'Female', 'Abcdxyz');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
