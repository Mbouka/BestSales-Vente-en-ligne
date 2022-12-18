package org.isj.ing.annuarium.webapp.Annuarium.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icategorie;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Iproduit;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
public class ProduitController {

    @Autowired
    Iproduit iProduit;
    @Autowired
    private Icategorie icategorie;

    /*@GetMapping("/")
    public String pageAccueil(Model model) {

        return "index";
    }*/


    @GetMapping("/enregistrerproduitform")
    public String enregistrerProduitForm( Model model) {
        Produit produit=  new Produit();
        produit.setPrixUnit("FRS CFA");
        List<Categorie> cat=icategorie.listCat();
        model.addAttribute("cat",cat);
        System.out.println(cat);
        model.addAttribute("produit",produit);
        return "saveproduit";
    }

    @PostMapping("/enregistrerproduit")
    public String enregistrerMateriel(@ModelAttribute Produit produit) throws isjException {

        ProduitController.log.info("enregistrer-produit");
        iProduit.saveProd(produit);
        return "redirect:Listes";
    }

    @GetMapping("/Listes")
    public String pageListeProduit(Model model)  {
        List<Produit> prd =iProduit.listProduit();
        model.addAttribute("prd",prd);
        List<Categorie> cat =icategorie.listCat();
        model.addAttribute("cat",cat);
        long compt= iProduit.countProduit();
        long numPrd=compt;
        model.addAttribute("numPrd",numPrd);
        return "listeproduit";
    }

    @GetMapping("/Listescat")
    public String pageListeCat(Model model,@RequestParam(name ="idcat")Integer idcat) throws isjException {
        List<Produit> prd=iProduit.findProduitByCategorie(idcat);
        model.addAttribute("prd",prd);
        List<Categorie> cat =icategorie.listCat();
        model.addAttribute("cat",cat);
        long compt= iProduit.countProduit();
        long numPrd=compt;
        model.addAttribute("numPrd",numPrd);
        return "listeproduit";
    }

    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name ="id")Integer id,Model model) throws isjException {
        Produit prd = iProduit.findProduitById(id);
        model.addAttribute("prd",prd);
        return "details";
    }

    @GetMapping("/carts")
    public String pageCart(Model model) throws isjException{
      /*  Produit prd = iProduit.findProduitById(id);
        model.addAttribute("prd",prd);*/
        return "cart";
    }

    @GetMapping("/livraison")
    public String pageLivraison(Model model) {
        return "livraison";
    }
}
