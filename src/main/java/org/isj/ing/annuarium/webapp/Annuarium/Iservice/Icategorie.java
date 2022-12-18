package org.isj.ing.annuarium.webapp.Annuarium.Iservice;


import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;

import java.util.List;

public interface Icategorie {
  Categorie saveCat(Categorie cat) throws isjException;
  Categorie updateCat(Categorie cat) throws  isjException;
  List<Categorie> listCat ();
  Categorie findCat(Integer id) throws isjException;
  Categorie searchNom(String nom) throws isjException;
  String deleteCat (Integer id) throws  isjException;
  List<Categorie> searchCategorieByKeyword(String keyword);
}
