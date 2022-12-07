package org.isj.ing.annuarium.webapp.Annuarium.presentation.controller;


import io.swagger.v3.oas.models.responses.ApiResponse;
import org.isj.ing.annuarium.webapp.Annuarium.dto.cart.AjouterAuPanierDto;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.isj.ing.annuarium.webapp.Annuarium.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

//    post cart api
    //@PostMapping("/add")
    //public ResponseEntity<ApiResponse> ajouterAuPanier(@RequestBody AjouterAuPanierDto ajouterAuPanierDto,/*@RequestParam("token") String token*/){

//        User user = authenticationService:getUser(token);

        //cartService.ajouterAuPanier(ajouterAuPanierDto);

        //return new ResponseEntity<>(new ApiResponse(true, "Ajouter au panier").HttpStatus.CREATED );
   // }
//    get all cart items for a user

//    delete a cart item for a user
}
