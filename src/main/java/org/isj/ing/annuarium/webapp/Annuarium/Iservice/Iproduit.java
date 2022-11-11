package org.isj.ing.annuarium.webapp.Annuarium.Iservice;


import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;

import java.util.List;

public interface Iproduit {
    Produit saveProd(Produit produit) throws isjException;
    Produit updateProd(Integer id) throws  isjException;
    List<Produit> PRODUIT_LIST (int page, int size);
    String deleteProd (Integer id) throws  isjException;
    Produit findProduitById(Integer id) throws isjException;
   /* List<Produit> findProduitByCategorie(Integer idcat,int page, int size) throws  isjException;
    List<Produit> findProduitByVendeur (Integer idvendeur,int page, int size) throws  isjException;*/
}
