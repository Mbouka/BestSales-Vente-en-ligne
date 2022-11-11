package org.isj.ing.annuarium.webapp.Annuarium.presentation.api;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Iproduit;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@Slf4j
public class ProduitRestController {
    @Autowired
    private Iproduit iproduit;

    @PostMapping("/save/{idCat}/{idvnte}")
    public String saveProd(@PathVariable("idCat")Integer idCat,@PathVariable("idvnte")Integer idvnte)throws isjException {
        try {
           iproduit.saveProd(idCat, idvnte);

        }catch ( isjException exception){

            return exception.getMessage();
        }
        return "Enregistrement Réussi !";
    }

    @GetMapping("/all/{page}/{size}")
    public ResponseEntity<List<Produit>>LIST(
            @PathVariable("page")int page,
            @PathVariable("size") int size
    ){
        System.out.println(iproduit.PRODUIT_LIST(page, size));
        return ResponseEntity.ok(iproduit.PRODUIT_LIST(page, size));
    }

    @GetMapping("/update/{id}")
    public String updateProd(@PathVariable("id") Integer id)throws isjException{
        try {
            iproduit.updateProd(id);
        }catch (isjException i){
            return i.getMessage();
        }
        return "Modification reussi";
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?>deleteProd(@PathVariable ("id") Integer id)throws isjException{
      try {
         return ResponseEntity.ok(iproduit.deleteProd(id));
      }catch (isjException i){
          return new ResponseEntity<String>(i.getMessage(), HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>findProduitById(@PathVariable("id") Integer id) throws isjException{
      try {
          return ResponseEntity.ok(iproduit.findProduitById(id));
      }catch (isjException i){
          return new ResponseEntity<String>(i.getMessage(),HttpStatus.NOT_FOUND);
      }
    }

   /* @GetMapping("/all/{id}/{page}/{size}")
    public ResponseEntity<List<Produit>>ListCat(
            @PathVariable("page")int page,
            @PathVariable("size") int size,
            @PathVariable("id") Integer id
    ) throws isjException {

        return ResponseEntity.ok(iproduit.findProduitByCategorie(id,page,size));
    }

    @GetMapping("/all/{id}/{page}/{size}")
    public ResponseEntity<List<Produit>>listVend(
            @PathVariable("page")int page,
            @PathVariable("size") int size,
            @PathVariable("id") Integer id
    )throws isjException{
        return ResponseEntity.ok(iproduit.findProduitByVendeur(page,size,id));
    }*/
}
