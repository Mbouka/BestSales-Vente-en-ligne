package org.isj.ing.annuarium.webapp.Annuarium.Iservice;


import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Vendeur;

import java.util.List;

public interface Ivendeur {
    Vendeur saveV(Vendeur vendeur) throws isjException ;
    Vendeur updateV(Integer id) throws isjException;
    List<Vendeur> listvendeur (int page, int size);
    String deleteV (Integer id) throws  isjException;
    Vendeur findVendeurById(Integer id) throws isjException;
    Long countArticlesVedus();
}
