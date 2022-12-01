package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.IcommandeProduit;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commande;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commandeproduit;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Livraison;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CommandeproduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CommandeproduitService implements IcommandeProduit {
    @Autowired
    CommandeproduitRepository commandeproduitRepository;
    @Override
    public Commandeproduit saveCmmndProduit(Produit idProduit, Commandeproduit cmprd, Commande cmd, Livraison liv) throws isjException {
        cmprd.setId(cmprd.getId());
        cmprd.setIdProduit(idProduit);
        cmprd.setIdCommande(cmd);
        cmprd.setIdLivraison(liv);
        Commandeproduit cmprdSave= commandeproduitRepository.save(cmprd);
        if(cmprdSave==null){
            throw new isjException("Imposssible de modifier ,réessayez plustard", Status.NOT_FOUND);
        }
        return cmprdSave;
    }

    @Override
    public Commandeproduit updateCmmndPrd(Integer id, Commandeproduit cmdprd) throws isjException {
        return null;
    }

    @Override
    public List<Commandeproduit> listeCmdPrd() {
        List<Commandeproduit> commandeproduitList = commandeproduitRepository.findAll();
        return commandeproduitList;
    }

    @Override
    public String deletCmdPrd(Integer id) throws isjException {
        commandeproduitRepository.deleteById(id);
        return "suppression reussi";
    }

    @Override
    public Commandeproduit findCommandeproduitById(Integer id) throws isjException {
        return commandeproduitRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.COMMANDE_PRODUIT_NOT_FOUND));
    }
}
