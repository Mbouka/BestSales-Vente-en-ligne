package org.isj.ing.annuarium.webapp.Annuarium.Iservice;

import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Paiement;

import java.util.List;

public interface Ipaiement {
    Paiement savePaiement(Paiement paie)throws isjException;
    Paiement updatePaiement(Integer id,Paiement paie) throws isjException;
    List<Paiement> listPaiement ();
    String deletePaiement(Integer id) throws isjException;
    Paiement findPaiementById(Integer id) throws isjException;
}
