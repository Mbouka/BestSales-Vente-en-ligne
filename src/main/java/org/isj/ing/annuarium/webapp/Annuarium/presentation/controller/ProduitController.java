package org.isj.ing.annuarium.webapp.Annuarium.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Iproduit;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;


@Controller
@Slf4j
public class ProduitController {

    @Autowired
    Iproduit iProduit;

    @GetMapping("/")
    public String pageAccueil(Model model) {

        return "index";
    }


    @GetMapping("/enregistrerproduitform")
    public String enregistrerProduitForm( Model model) {
        Produit produit=  new Produit();
        model.addAttribute("produit",produit);
        return "saveproduit";
    }

    @PostMapping("/enregistrerproduit")
    public String enregistrerMateriel(@ModelAttribute Produit produit ,Integer idCat, Integer idvnte) throws isjException {

        ProduitController.log.info("enregistrer-produit");
        // appel de la couche service ou metier injectée pour enregistrer un materiel
        iProduit.saveProd(idCat,idvnte,produit);
        return "redirect:index";
    }

}
