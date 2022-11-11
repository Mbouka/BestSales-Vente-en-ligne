drop database if exists vente;
create database vente  ;
use vente;


drop table if exists customer;
create table customer(
	id_client int auto_increment primary key,
    nom_complet CHAR(255) not null,
    telephone bigint not null,
    ville char(255) not null,
    quartier char(255) not null,
    email char(255)
)ENGINE = INNODB;

drop table if exists commande;
create table commande(
	id_commande int auto_increment primary key,
    id_client int not null,
    date_com date not null,
    foreign key(id_client)
		references customer(id_client)
)ENGINE = INNODB;

drop table if exists categorie;
create table categorie(
	id_categorie int auto_increment primary key,
    nom_cat char(255) not null
)ENGINE = INNODB;

drop table if exists vendeur;
create table vendeur(
	id_vendeur int auto_increment primary key,
    nom_complet char(255) not null,
    tel bigint not null,
    ville char(255),
    quartier char(255),
    email char(255)
)ENGINE = INNODB;

drop table if exists paiement;
CREATE TABLE paiement (
    id_paiement INT AUTO_INCREMENT PRIMARY KEY,
    methode ENUM('Carte', 'Espèce')
)ENGINE = INNODB;

drop table if exists produit;
create table produit(
	id_produit int auto_increment primary key,
    id_vendeur int not null,
    nom_vendeur char(255) not null,
    prix_unit int not null,
    qntite_en_stock int not null,
    nom_produit char(255) not null,
    id_categorie int not null,
    nom_categorie char(255) not null,
    nom_image char(255) ,
    image_produit longblob,
    
    foreign key(id_vendeur) references vendeur(id_vendeur),
    foreign key(id_categorie) references categorie(id_categorie)
)ENGINE = INNODB;

drop table if exists livraison;
create table livraison(
	id_livraison int auto_increment primary key,
    id_comprod int not null,
    prix_liv int not null,
    quartier char(255) not null,
    ville char(255),
    date_liv date
)ENGINE = INNODB;

drop table if exists commandeProduit;
create table commandeProduit(
	id_com_prod int auto_increment primary key,
    id_commande int not null,
    id_produit int not null,
    id_livraison int not null,
    foreign key(id_commande) references commande(id_commande),
    foreign key(id_produit) references produit(id_produit),
    foreign key(id_livraison) references livraison(id_livraison)
)ENGINE = INNODB;

drop table if exists facture;
create table facture(
	num_facture int auto_increment primary key,
    id_commande int not null,
    montant int not null,
    id_paiement int not null,
    foreign key(id_commande) references commande(id_commande),
    foreign key(id_paiement) references paiement(id_paiement)
     
)ENGINE = INNODB;

