package org.isj.ing.annuarium.webapp.Annuarium.service;


import org.isj.ing.annuarium.webapp.Annuarium.dto.cart.AjouterAuPanierDto;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Cart;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartService {
    @Autowired
    ProduitService produitService;
    @Autowired
    CartRepository cartRepository;

//    public void ajouterAuPanier(AjouterAuPanierDto ajouterAuPanierDto) {
//
////        validate if the product id is valid
//        //Produit produit = produitService.findById(ajouterAuPanierDto.getProductId());
//
//        Cart cart = new Cart();
//        cart.setProduit(produit);
//        cart.setQuantite(ajouterAuPanierDto.getQuantity());
//        cart.setDateCreation(new Date());
//
////        save the cart
//        cartRepository.save(cart);
//    }
}
