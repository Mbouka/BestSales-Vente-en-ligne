package org.isj.ing.annuarium.webapp.Annuarium.Iservice;

import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commande;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commandeproduit;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Livraison;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;

import java.util.List;

public interface IcommandeProduit {
    Commandeproduit saveCmmndProduit (Produit idProduit , Commandeproduit cmprd, Commande cmd , Livraison liv) throws isjException;
    Commandeproduit updateCmmndPrd (Integer id,Commandeproduit cmdprd) throws  isjException;
    List<Commandeproduit> listeCmdPrd();
    String deletCmdPrd(Integer id) throws  isjException;
    Commandeproduit findCommandeproduitById(Integer id)throws isjException;
}
