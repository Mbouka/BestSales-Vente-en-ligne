package org.isj.ing.annuarium.webapp.Annuarium.presentation.api;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Ivendeur;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Vendeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendeur" )
@Slf4j
public class VendeurRestController {
    @Autowired
    Ivendeur ivendeur;

    @PostMapping("/save")
    public String saveV(@RequestBody Vendeur vendeur)throws isjException  {
        try {
            ivendeur.saveV(vendeur);
        }catch (isjException i){
            return i.getMessage();
        }
         return "Enregitrement reussi";
    }
    @PutMapping("/update/{id}")
   public String updateV(@PathVariable("id")Integer id)throws isjException {
        try {
           ivendeur.updateV(id);
            System.out.println(ivendeur.updateV(id));

        }catch (isjException i){
           return i.getMessage();
        }
        return "modification reussi";
    }
    @GetMapping("all/{page}/{size}")
    public ResponseEntity<List<Vendeur>> listvendeur(
            @PathVariable("page") int page,
           @PathVariable("size") int size
    ){
        return  ResponseEntity.ok(ivendeur.listvendeur(page, size));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vendeur>> getAllList(){
        return  ResponseEntity.ok(ivendeur.listvendeur(0,40));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteV(@PathVariable("id")Integer id)throws isjException{
        ivendeur.deleteV(id);
        return  new ResponseEntity<>("Le compte à  étè srppimier avec succéss",HttpStatus.OK);
   }

    @GetMapping("/search/{id}")
    public ResponseEntity<?>findVendeurById(@PathVariable ("id")Integer id)throws isjException{
       Vendeur vend= ivendeur.findVendeurById(id);
        return  new ResponseEntity<>(vend,HttpStatus.OK);
    }


}
