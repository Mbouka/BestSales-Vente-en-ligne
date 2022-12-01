package org.isj.ing.annuarium.webapp.Annuarium.Iservice;

import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Facture;

import java.util.List;

public interface Ifacture {
    Facture saveFacture(Facture fac)throws isjException;
    Facture updateFacture(Integer id,Facture fac) throws isjException;
    List<Facture> listFacture ();
    String deleteFacture(Integer id) throws isjException;
    Facture findFactureById(Integer id) throws isjException;
}
