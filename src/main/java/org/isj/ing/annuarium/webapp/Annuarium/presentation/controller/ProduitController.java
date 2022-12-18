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

    @GetMapping("/")
    public String pageAccueil(Model model) {

        return "index";
    }


    @GetMapping("/enregistrerproduitform")
    public String enregistrerProduitForm( Model model) {
        Produit produit=  new Produit();
        produit.setPrixUnit("FRS CFA");
        List<Categorie> cat=icategorie.listCat();
        model.addAttribute("cat",cat);
        model.addAttribute("testons","testons");
        System.out.println(cat);
        model.addAttribute("produit",produit);
        return "saveproduit";
    }

    @PostMapping("/enregistrerproduit")
    public String enregistrerMateriel(@ModelAttribute Produit produit) throws isjException {

        ProduitController.log.info("enregistrer-produit");
        // appel de la couche service ou metier injectée pour enregistrer un materiel
//        iProduit.saveProd(idCat,idvnte,produit);ce qui a ete modifie avec vinny
        iProduit.saveProd(produit);
        return "redirect:Listes";
    }

    @GetMapping("/Listes")
    public String pageListeProduit(Model model)  {
        List<Produit> prd =iProduit.listProduit();
       List<Categorie> cat= icategorie.listCat();
        model.addAttribute("cat",cat);
        model.addAttribute("prd",prd);
        return "listeproduit";
    }

    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name ="id")Integer id,Model model) throws isjException {
        Produit prd = iProduit.findProduitById(id);
        model.addAttribute("prd",prd);
        return "details";
    }

    @GetMapping("/carts")
    public String pageCart(@RequestParam(name ="id")Integer id,Model model) throws isjException{

        Produit prd = iProduit.findProduitById(id);
        model.addAttribute("prd",prd);
        return "cart";
    }

    @GetMapping("/livraison")
    public String pageLivraison(Model model) {

        return "livraison";
    }

//    @PostMapping("/rechercherproduit" )
//    public String rechercherProduits( @RequestParam(name = "nom") String nom,
//                                   Model model) throws isjException {
//
//        ProduitController.log.info("rechercher-produit");
//        // appel de la couche service ou metier injectée pour enregistrer un materiel
////        List<Categorie> cate=  categorie.searchCategorieByKeyword(motcle);
//
////        model.addAttribute("acteDtos",acteDtos);
//        icategorie.searchNom(nom);
//
//        return "rechercher";
//    }

    @GetMapping("/rechercherproduitform")
    public String pagerechercherproduitform(Model model) {
        Categorie categorie=  new Categorie();
        //apppel de la couche service pour avoir la liste des actes dto
        List<Categorie> cat=icategorie.listCat();
        model.addAttribute("cat",cat);

        return "rechercher";
    }
}
