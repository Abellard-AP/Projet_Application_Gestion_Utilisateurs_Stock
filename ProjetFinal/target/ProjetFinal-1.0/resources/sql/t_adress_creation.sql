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
-- Structure de la table `t_adress`
--

DROP TABLE IF EXISTS `t_adress`;
CREATE TABLE IF NOT EXISTS `t_adress` (
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_VOIRIE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `A_CODEPOSTAL` varchar(200) COLLATE utf8_bin NOT NULL,
  `A_VILLE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`A_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_adress`
--

INSERT INTO `t_adress` (`A_ID`, `A_VOIRIE`, `A_CODEPOSTAL`, `A_VILLE`) VALUES
(1, '3, rue de la liberation', '37000', 'Tours'),
(3, '5 rue de la mairie', '37000', 'Tours'),
(4, '3, rue de la liberation', '37000', 'Tours'),
(5, '3, rue de la liberation', '37000', 'Tours');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
