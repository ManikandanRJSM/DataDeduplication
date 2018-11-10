-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 17, 2017 at 05:05 AM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `securedds`
--

-- --------------------------------------------------------

--
-- Table structure for table `fileinfotab`
--

CREATE TABLE IF NOT EXISTS `fileinfotab` (
  `u_email` varchar(500) NOT NULL,
  `tag_id` varchar(5000) NOT NULL,
  `f_name` varchar(5000) NOT NULL,
  `f_size` varchar(20) NOT NULL,
  `b_dir` varchar(2000) NOT NULL,
  `utype` int(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fileinfotab`
--


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(5) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `email` varchar(2000) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `u_key` int(6) NOT NULL,
  `usr_typ` int(5) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `uname`, `pwd`, `email`, `dob`, `u_key`, `usr_typ`) VALUES
(14, 'xyz', '123456', 'datasecuresharing@gmail.com', '1984-05-05', 29665, 1);
