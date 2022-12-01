package org.isj.ing.annuarium.webapp.Annuarium.Iservice;

import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commande;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;

import java.util.List;

public interface Icommande {
    Commande saveCommande(Commande cmd)throws isjException;
  //  Commande updateCommande(Integer id,Commande cmd) throws isjException;
    List<Commande> listCommande ();
    String deleteCommande(Integer id) throws isjException;
    Commande findCommandeById(Integer id) throws isjException;
}
