package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icustomer;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Ilivraison;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commandeproduit;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Livraison;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CommandeproduitRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CustomerRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Status;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class LivraisonService implements Ilivraison {
    @Autowired
    LivraisonRepository livraisonRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CommandeproduitRepository commandeproduitRepository;
    @Autowired
    Icustomer icustomer;


    @Override
    public Livraison saveLivraison(Livraison liv ) throws isjException {
       // Commandeproduit cmdPrd = commandeproduitRepository.findById(idcmPrd).orElseThrow(()->new isjException(ErrorInfo.COMMANDE_PRODUIT_NOT_FOUND));
        Customer cus = new Customer();
        liv.setId(liv.getId());
        //liv.setIdComprod(cmdPrd.getId());
        liv.setPrixLiv(liv.getPrixLiv());

        for (int i=0;i<icustomer.listClient().size();i++){
            if (icustomer.listClient().get(i).getNomComplet().equals(liv.getClient())){
                liv.setClient(cus.getNomComplet());
                liv.setEmail(cus.getEmail());
                liv.setQuartier(cus.getQuartier());
                liv.setTelephone(cus.getTelephone());
                liv.setVille(cus.getVille());

            }else{
                cus.setId(cus.getId());
                cus.setNomComplet(liv.getClient());
                cus.setQuartier(liv.getQuartier());
                cus.setTelephone(liv.getTelephone());
                cus.setEmail(liv.getEmail());
                cus.setVille(liv.getVille());
                customerRepository.save(cus);
            }
            /*liv.setQuartier(cus.getQuartier());
            liv.setTelephone(cus.getTelephone());
            liv.setVille(cus.getVille());
            liv.setClient(cus.getNomComplet());*/
        }
        Livraison livSave = livraisonRepository.save(liv);
        if(livSave==null){
            throw new isjException("Imposssible de modifier ,réessayez plustard", Status.NOT_FOUND);
        }
        return livSave;
    }

    @Override
    public Livraison updateLivraison(Integer id, Livraison liv, Integer idclient ) throws isjException {
        Customer cus = customerRepository.findById(idclient).orElseThrow(()->new isjException(ErrorInfo.CUSTOMER_NOT_FOUND));
        liv.setId(liv.getId());
        liv.setDateLiv(liv.getDateLiv());
        liv.setPrixLiv(liv.getPrixLiv());
        liv.setQuartier(liv.getQuartier());
        liv.setVille(liv.getVille());
        liv.setEmail(liv.getEmail());
        liv.setTelephone(liv.getTelephone());
        liv.setClient(liv.getClient());
        Livraison livUpdate = livraisonRepository.save(liv);
        if(livUpdate==null){
            throw new isjException("Imposssible de modifier ,réessayez plustard", Status.NOT_FOUND);
        }
        return livUpdate;
    }

    @Override
    public List<Livraison> listLivraison() {
        List<Livraison> list= livraisonRepository.findAll();
        return list;
    }

    @Override
    public String deleteLivraison(Integer id) throws isjException {
        livraisonRepository.deleteById(id);
        return "Livraison supprimer avec succés";
    }

    @Override
    public Livraison findLivraisonById(Integer id) throws isjException {
        return livraisonRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.LIVRAISON_NOT_FOUND));
    }
}
