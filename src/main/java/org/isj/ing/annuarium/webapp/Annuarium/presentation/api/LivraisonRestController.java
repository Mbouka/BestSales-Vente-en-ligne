package org.isj.ing.annuarium.webapp.Annuarium.presentation.api;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Ilivraison;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liv" )
@Slf4j
public class LivraisonRestController {
    @Autowired
    private  Ilivraison ilivraison;

    @PostMapping("/save")
    public String saveLiv(@RequestBody Livraison liv)throws isjException {
        try {
            ilivraison.saveLivraison(liv);
        }catch (isjException i){
            return i.getMessage();
        }
        return "Enregitrement reussi";
    }
    @PutMapping("/update/{id}/{idclient}")
    public String updateLiv(@PathVariable("id")Integer id,@RequestBody  Livraison liv,@PathVariable("idclient")Integer idclient)throws isjException {
        try {
            ilivraison.updateLivraison(id,liv,idclient);

        }catch (isjException i){
            return i.getMessage();
        }
        return "modification reussi";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Livraison>> getAllList(){
        return  ResponseEntity.ok(ilivraison.listLivraison());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteLiv(@PathVariable("id")Integer id)throws isjException{
        ilivraison.deleteLivraison(id);
        return  new ResponseEntity<>("Le compte à  étè srppimier avec succéss", HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?>findLivById(@PathVariable ("id")Integer id)throws isjException{
        Livraison liv= ilivraison.findLivraisonById(id);
        return  new ResponseEntity<>(liv,HttpStatus.OK);
    }
}
