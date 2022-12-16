package org.isj.ing.annuarium.webapp.Annuarium.service;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Iproduit;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.ProductNotExistException;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Vendeur;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CategorieRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.ProduitRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProduitService implements Iproduit {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    VendeurRepository vendeurRepository;
    @Autowired
    CategorieRepository categorieRepository;



    @Override
    public Produit saveProd(Produit produit) throws isjException {
        produit.setId(produit.getId());
        produit.setNomProduit(produit.getNomProduit());
        produit.setSeuil(produit.getSeuil());
        produit.setPrixUnit(produit.getPrixUnit());
        produit.setQntiteEnStock(produit.getQntiteEnStock());
        produit.setNomImage(produit.getNomImage());
        produit.setDescription(produit.getDescription());
        produit.setQntiteCommander(0);
        Produit prsave = produitRepository.save(produit);

        if (prsave == null){
            throw new isjException("Imposssible d'enregister ,réessayez plustard", Status.NOT_FOUND);
        }
        return prsave;
    }

    @Override
    public Produit updateProd(Integer id,Produit produit) throws isjException {

        produit.setNomProduit(produit.getNomProduit());
        produit.setNomImage(produit.getNomImage());
        produit.setSeuil(produit.getSeuil());
        produit.setPrixUnit(produit.getPrixUnit());
        produit.setQntiteEnStock(produit.getQntiteEnStock());
        produit.setDescription(produit.getDescription());
        produit.setQntiteCommander(produit.getQntiteCommander());

       Produit prUpdate = produitRepository.save(produit);
       if (prUpdate== null){
           throw new isjException("Imposssible de modifier ,réessayez plustard", Status.NOT_FOUND);
       }
        return prUpdate;
    }

    @Override
    public List<Produit> PRODUIT_LIST(int page, int size) {
        List<Produit> produitList = produitRepository.findAll(PageRequest.of(page, size)).toList();
        return produitList;
    }

    @Override
    public List<Produit> listProduit()  {
        List<Produit> prdList = produitRepository.findAll();
        return prdList;
    }

    @Override
    public Long countProduit() {
        return produitRepository.count();
    }

    @Override
    public String deleteProd(Integer id) throws isjException {
        Produit produit = produitRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.PRODUIT_NOT_FOUND));
        produitRepository.deleteById(id);
        return "Le produit" + produit.getNomProduit() + " à étè supprimer avec succés";
    }

    @Override
    public Produit findProduitById(Integer id) throws isjException {
        return produitRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.PRODUIT_NOT_FOUND));
    }

   @Override
    public List<Produit> findProduitByCategorie(Integer idcat) throws isjException {
        Categorie categorie=categorieRepository.findById(idcat).orElseThrow(()->new isjException(ErrorInfo.CATEGORIE_NOT_FOUND));
        List<Produit> produitListCat = new ArrayList<>();

        for (int i=0;i<listProduit().size();i++){
            if (listProduit().get(i).getNomCat().equals(categorie.getNomCat())){
                produitListCat.add(listProduit().get(i));
            }
        }
       System.out.println(produitListCat);
        return produitListCat;
    }

   /* @Override
    public List<Produit> findProduitByVendeur(Integer idvendeur, int page, int size) throws isjException {
        Vendeur vendeur=vendeurRepository.findById(idvendeur).orElseThrow(()->new isjException(ErrorInfo.VENDEUR_NOT_FOUND));
        List<Produit> produitListVendeur = new ArrayList<>();
        for (int i=0;i<PRODUIT_LIST(page, size).size();i++){
            if (PRODUIT_LIST(page, size).get(i).getIdCategorie().equals(vendeur.getId())){
                produitListVendeur.add(PRODUIT_LIST(page, size).get(i));
            }
        }
        return produitListVendeur;
    }*/


}
