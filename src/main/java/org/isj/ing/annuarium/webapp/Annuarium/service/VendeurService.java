package org.isj.ing.annuarium.webapp.Annuarium.service;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Ivendeur;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Vendeur;
import org.isj.ing.annuarium.webapp.Annuarium.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;

import java.util.List;

@Service
@Transactional
@Slf4j
public class VendeurService implements Ivendeur {
    @Autowired
    VendeurRepository vendeurRepository;

    @Override
    public Vendeur saveV(Vendeur vend)throws isjException {
        vend.setId(vend.getId());
        vend.setEmail(vend.getEmail());
        vend.setNomComplet(vend.getNomComplet());
        vend.setQuartier(vend.getQuartier());
        vend.setTel(vend.getTel());
        vend.setVille(vend.getVille());
       Vendeur vendeurSave= vendeurRepository.save(vend);
        if (vendeurSave==null){
            throw new isjException("Imposssible d'enregister ,réessayez plustard", Status.NOT_FOUND);
        }

        return vendeurSave;
    }

    @Override
    public Vendeur updateV(Integer id) throws isjException {
        Vendeur vend = vendeurRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.VENDEUR_NOT_FOUND));
        vend.setEmail(vend.getEmail());
        vend.setNomComplet(vend.getNomComplet());
        vend.setQuartier(vend.getQuartier());
        vend.setTel(vend.getTel());
        vend.setVille(vend.getVille());
        Vendeur vendUpdate = vendeurRepository.save(vend);
        if (vendUpdate==null){
            throw new isjException("Imposssible d'enregister ,réessayez plustard", Status.NOT_FOUND);
        }
        return vendUpdate;
    }

    @Override
    public List<Vendeur> listvendeur(int page, int size) {
        List<Vendeur> vendeurList = vendeurRepository.findAll(PageRequest.of(page, size)).toList();
        return vendeurList;
    }

    @Override
    public String deleteV(Integer id) throws isjException {
        Vendeur vendeur= vendeurRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.VENDEUR_NOT_FOUND));
        vendeurRepository.deleteById(id);
        return "Le compte"+vendeur.getNomComplet()+"à étè srppimier avec succéss";
    }

    @Override
    public Vendeur findVendeurById(Integer id) throws isjException {
        return vendeurRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.VENDEUR_NOT_FOUND));
    }

    @Override
    public Long countArticlesVedus() {
        return null;
    }
}
