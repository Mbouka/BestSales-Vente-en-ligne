package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Ilivraison;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commandeproduit;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Livraison;
import org.isj.ing.annuarium.webapp.Annuarium.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Status;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class LivraisonService implements Ilivraison {
    @Autowired
    LivraisonRepository livraisonRepository;
    @Override
    public Livraison saveLivraison(Livraison liv, Commandeproduit cmdPrd) throws isjException {
        liv.setId(liv.getId());
        liv.setDateLiv(liv.getDateLiv());
        liv.setPrixLiv(liv.getPrixLiv());
        liv.setQuartier(liv.getQuartier());
        liv.setVille(liv.getVille());
        liv.setIdComprod(cmdPrd.getId());
        Livraison livSave = livraisonRepository.save(liv);
        if(livSave==null){
            throw new isjException("Imposssible de modifier ,réessayez plustard", Status.NOT_FOUND);
        }
        return livSave;
    }

    @Override
    public Livraison updateLivraison(Integer id, Livraison liv) throws isjException {
        return null;
    }

    @Override
    public List<Livraison> listLivraison() {
        List<Livraison> list= livraisonRepository.findAll();
        return list;
    }

    @Override
    public String deleteLivraison(Integer id) throws isjException {
        return null;
    }

    @Override
    public Livraison findLivraisonById(Integer id) throws isjException {
        return livraisonRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.LIVRAISON_NOT_FOUND));
    }
}
