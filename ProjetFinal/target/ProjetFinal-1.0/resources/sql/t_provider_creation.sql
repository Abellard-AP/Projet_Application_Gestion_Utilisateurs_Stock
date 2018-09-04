-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 31 août 2018 à 13:02
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_provider`
--

DROP TABLE IF EXISTS `t_provider`;
CREATE TABLE IF NOT EXISTS `t_provider` (
  `FR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FR_REFERENCE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `FR_NOM` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `A_ID` int(11) NOT NULL,
  PRIMARY KEY (`FR_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_provider`
--

INSERT INTO `t_provider` (`FR_ID`, `FR_REFERENCE`, `FR_NOM`, `A_ID`) VALUES
(1, 'ref-dell', 'DELL', 1),
(3, 'Ref-121', 'AC/DC', 3),
(4, 'ref-dell', 'Dell', 4),
(5, 'ref-dell', 'Dell', 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
