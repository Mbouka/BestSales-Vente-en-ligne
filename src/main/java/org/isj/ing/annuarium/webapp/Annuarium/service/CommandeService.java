package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icommande;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Commande;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CommandeRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CommandeService implements Icommande {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Commande saveCommande(Commande cmd, Customer client) throws isjException {
        cmd.setId(cmd.getId());
        cmd.setNomClient(client.getNomComplet());
        cmd.setDateCom(LocalDate.now());
        Commande cmdSave = commandeRepository.save(cmd);
        if (cmdSave== null){
            throw new isjException("Imposssible d'enregister ,réessayez plustard", Status.NOT_FOUND);
        }
        return cmdSave;
    }

    @Override
    public Commande updateCommande(Integer id, Commande cmd) throws isjException {
        return null;
    }

    @Override
    public List<Commande> listCommande() {
        List<Commande> commandeList = commandeRepository.findAll();
        return commandeList;
    }

    @Override
    public String deleteCommande(Integer id) throws isjException {
        return null;
    }

    @Override
    public Commande findCommandeById(Integer id) throws isjException {
        return commandeRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.COMMANDE_NOT_FOUND));
    }
}
