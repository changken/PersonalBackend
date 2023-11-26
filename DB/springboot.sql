-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2023-11-26 04:59:46
-- 伺服器版本： 10.4.27-MariaDB
-- PHP 版本： 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `springboot`
--

-- --------------------------------------------------------

--
-- 資料表結構 `memotbl`
--

CREATE TABLE `memotbl` (
  `nid` bigint(11) NOT NULL,
  `vchtitle` varchar(100) NOT NULL,
  `vchcontent` varchar(4000) NOT NULL,
  `nis_did` int(1) NOT NULL,
  `nuserid` bigint(11) NOT NULL,
  `dcreated_at` datetime NOT NULL DEFAULT current_timestamp(),
  `dupdated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `memotbl`
--

INSERT INTO `memotbl` (`nid`, `vchtitle`, `vchcontent`, `nis_did`, `nuserid`, `dcreated_at`, `dupdated_at`) VALUES
(1, 'aaa', 'bbb', 1, 1, '2023-11-26 11:59:30', '2023-11-26 11:59:30');

-- --------------------------------------------------------

--
-- 資料表結構 `usertbl`
--

CREATE TABLE `usertbl` (
  `nid` bigint(11) NOT NULL,
  `vchusername` varchar(255) NOT NULL,
  `vchpassword` varchar(64) NOT NULL,
  `vchlevel` varchar(20) NOT NULL,
  `dbirthday` datetime NOT NULL,
  `dcreated_at` datetime NOT NULL DEFAULT current_timestamp(),
  `dupdated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `usertbl`
--

INSERT INTO `usertbl` (`nid`, `vchusername`, `vchpassword`, `vchlevel`, `dbirthday`, `dcreated_at`, `dupdated_at`) VALUES
(1, 'changken', '25', 'admin', '1998-10-11 00:00:00', '2023-11-26 11:31:21', '2023-11-26 11:31:38');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `memotbl`
--
ALTER TABLE `memotbl`
  ADD PRIMARY KEY (`nid`);

--
-- 資料表索引 `usertbl`
--
ALTER TABLE `usertbl`
  ADD PRIMARY KEY (`nid`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `memotbl`
--
ALTER TABLE `memotbl`
  MODIFY `nid` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `usertbl`
--
ALTER TABLE `usertbl`
  MODIFY `nid` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
