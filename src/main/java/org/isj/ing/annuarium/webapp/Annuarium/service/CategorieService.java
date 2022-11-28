package org.isj.ing.annuarium.webapp.Annuarium.service;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icategorie;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;

import java.util.List;

@Service
@Slf4j
@Transactional
public class CategorieService implements Icategorie {
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie saveCat(Categorie categorie) throws isjException {

        categorie.setId(categorie.getId());
        categorie.setNomCat(categorie.getNomCat());
        Categorie catSave = categorieRepository.save(categorie);
        if (catSave == null) {
            throw new isjException("Imposssible d'enregister ,réessayez plustard", Status.NOT_FOUND);
        }
        return catSave;
    }

    @Override
    public Categorie updateCat(Categorie cat) throws isjException {
        Categorie categorie = categorieRepository.findById(cat.getId()).orElseThrow(() -> new isjException(ErrorInfo.CATEGORIE_NOT_FOUND));
        categorie.setNomCat(categorie.getNomCat());
       Categorie  catUpdate = categorieRepository.save(categorie);
        return catUpdate;
    }

    @Override
    public List<Categorie> listCat() {
        List<Categorie> list = categorieRepository.findAll();
        return list;
    }

    @Override
    public Categorie findCat(Integer id) throws isjException {
        return categorieRepository.findById(id).orElseThrow(() -> new isjException(ErrorInfo.CATEGORIE_NOT_FOUND));
    }

    @Override
    public Categorie searchNom(String nom) throws isjException {
        return categorieRepository.findCatBynomCat(nom).orElseThrow(() -> new isjException(ErrorInfo.CATEGORIE_NOT_FOUND));
    }

    @Override
    public String deleteCat(Integer id) throws isjException {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new isjException(ErrorInfo.CATEGORIE_NOT_FOUND));
        categorieRepository.deleteById(id);
        return "Categorie" + categorie.getNomCat() + "supprimer avec succés";

    }
}
