package org.isj.ing.annuarium.webapp.Annuarium.presentation.api;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icategorie;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
@Slf4j
public class CategorieRestController {
    @Autowired
    private Icategorie icategorie;

    @PostMapping("/save")
    public String saveCat(@RequestBody Categorie categorie) throws isjException {
        try {
            icategorie.saveCat(categorie);
        }catch (isjException i){
            return i.getMessage();
        }
        return "enregistrement réussi";
    }
    @GetMapping("/all/{page}/{size}")
    public ResponseEntity<List<Categorie>>listCat(
            @PathVariable("page")int page,
            @PathVariable("size")int size
    ){
        return ResponseEntity.ok(icategorie.listCat(page, size));
    }

    @PutMapping("/update/{id}")
    public String updateCat(@RequestBody Categorie categorie) throws isjException{
        try {
            icategorie.updateCat(categorie);
            System.out.println(icategorie.updateCat(categorie));
        }catch (isjException i){
            return i.getMessage();
        }

       return "modification reussi";
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String>deleteCat(@PathVariable("id")Integer id)throws isjException{
        icategorie.deleteCat(id);
        return  new ResponseEntity<>("La categorie à  étè srppimier avec succéss",HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?>findCat(@PathVariable("id")Integer id)throws isjException{
        Categorie cat = icategorie.findCat(id);
        return new ResponseEntity<>(cat,HttpStatus.OK);
    }
    @GetMapping("/searchNom/{nom}")
    public ResponseEntity<?>searchNom(@PathVariable("nom")String nom)throws isjException{
        Categorie cat = icategorie.searchNom(nom);
        return new ResponseEntity<>(cat,HttpStatus.OK);
    }
}
