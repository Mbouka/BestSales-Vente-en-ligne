package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="panier")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_creation")
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private int quantite;

    public Cart(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
