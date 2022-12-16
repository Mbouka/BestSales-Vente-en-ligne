package org.isj.ing.annuarium.webapp.Annuarium.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.IcommandeProduit;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icustomer;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Ilivraison;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class LivraisonController {
    @Autowired
    Ilivraison ilivraison;
    @Autowired
    IcommandeProduit icommandeProduit;
    @Autowired
    Icustomer icustomer;

    @GetMapping("/enregistrerlivraisonform")
    public String enregistrerlivraisonform( Model model) {
        Livraison liv=  new Livraison();
        liv.setPrixLiv("FRS CFA 1000");
        model.addAttribute("liv",liv);
        return "livraison";
    }

    @PostMapping("/enregistrerlivraison")
    public String enregistrerlivraison(@ModelAttribute Livraison liv, BindingResult message) throws isjException {
        //Commandeproduit cmdPrd = icommandeProduit.findCommandeproduitById(idcmPrd);
        ilivraison.saveLivraison(liv);
        return "redirect:LivraisonReussi";
    }

    @GetMapping("/LivraisonReussi")
    public String pageListeProduit(Model model)  {

        return "livraisonReussi";
    }
  /*  @GetMapping("/")
    public String retourAcceuil(Model model){
        return "index";
    }*/
}
