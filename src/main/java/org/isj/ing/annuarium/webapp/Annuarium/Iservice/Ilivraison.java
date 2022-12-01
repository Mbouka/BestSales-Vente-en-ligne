package org.isj.ing.annuarium.webapp.Annuarium.Iservice;

import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commande;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commandeproduit;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Livraison;


import java.util.List;

public interface Ilivraison {
    Livraison saveLivraison(Livraison liv)throws isjException;
    Livraison updateLivraison(Integer id,Livraison liv, Integer idclient) throws isjException;
    List<Livraison> listLivraison ();
    String deleteLivraison (Integer id) throws isjException;
    Livraison findLivraisonById(Integer id) throws isjException;
}
