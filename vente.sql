-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 29 nov. 2022 à 09:23
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vente`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cat` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom_cat`) VALUES
(1, 'electro-ménagé'),
(2, 'cuisine'),
(3, 'mode'),
(4, 'mécanique'),
(5, 'voyage');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `date_com` date NOT NULL,
  `id_client` int(11) NOT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `FKfli8jhlji7kqjm5dpuey15agd` (`id_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commandeproduit`
--

DROP TABLE IF EXISTS `commandeproduit`;
CREATE TABLE IF NOT EXISTS `commandeproduit` (
  `id_com_prod` int(11) NOT NULL AUTO_INCREMENT,
  `id_commande` int(11) NOT NULL,
  `id_livraison` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  PRIMARY KEY (`id_com_prod`),
  KEY `FKd8lynlfvria0w1t78o3mu8xj3` (`id_commande`),
  KEY `FK4nwxfmlr6xo2msrqd196tauq` (`id_livraison`),
  KEY `FKg9c2m3dfki7f56rmsfw9wftny` (`id_produit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom_complet` varchar(255) NOT NULL,
  `quartier` varchar(255) NOT NULL,
  `telephone` bigint(20) NOT NULL,
  `ville` varchar(255) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `num_facture` int(11) NOT NULL AUTO_INCREMENT,
  `montant` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `id_paiement` int(11) NOT NULL,
  PRIMARY KEY (`num_facture`),
  KEY `FKfxh5cabn1jfgp5y7u63wc9cxh` (`id_commande`),
  KEY `FKhohblaxunitla4myo8r866ad3` (`id_paiement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `id_livraison` int(11) NOT NULL AUTO_INCREMENT,
  `date_liv` date DEFAULT NULL,
  `id_comprod` int(11) NOT NULL,
  `prix_liv` int(11) NOT NULL,
  `quartier` varchar(255) NOT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_livraison`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
CREATE TABLE IF NOT EXISTS `paiement` (
  `id_paiement` int(11) NOT NULL AUTO_INCREMENT,
  `methode` longtext,
  PRIMARY KEY (`id_paiement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `nom_cat` varchar(255) DEFAULT NULL,
  `nom_image` varchar(255) DEFAULT NULL,
  `nom_produit` varchar(255) DEFAULT NULL,
  `prix_unit` int(11) DEFAULT NULL,
  `qntite_en_stock` int(11) DEFAULT NULL,
  `seuil` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `description`, `nom_cat`, `nom_image`, `nom_produit`, `prix_unit`, `qntite_en_stock`, `seuil`) VALUES
(1, 'j', '1', NULL, 'ordinateur 3g', 1000, 70, 5),
(2, 'bonne ', '1', NULL, 'ordinateur 2g', 800, 100, 5),
(3, 'bon', '2', NULL, 'beignet', 25, 7, 1),
(4, 'fgh', '2', NULL, 'wa', 7552, 8, 2),
(5, 'wertz', 'mode', NULL, 'papaye', 800, 4, 8);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `id_vendeur` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom_complet` varchar(255) NOT NULL,
  `quartier` varchar(255) DEFAULT NULL,
  `tel` bigint(20) NOT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_vendeur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
