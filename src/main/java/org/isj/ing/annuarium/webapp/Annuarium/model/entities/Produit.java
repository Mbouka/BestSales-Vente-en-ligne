package org.isj.ing.annuarium.webapp.Annuarium.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "produit")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Data
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit", nullable = false)
    private Integer id;

    @Column(name = "nom_produit")
    private String nomProduit;

    @Column(name = "prix_unit")
    private Integer prixUnit;

    @Column(name = "qntite_en_stock")
    private Integer qntiteEnStock;


    @Column(name = "seuil")
    private Integer seuil;


    @Column(name = "nom_image")
    private String nomImage;

    // @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vendeur", nullable = false)
    private Vendeur idVendeur;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categorie", nullable = false)
    private Categorie idCategorie;

    /*@Transient
    public String getPhotosImagePath() {
        if (nomImage == null || id == null) return null;

        return "/user-photos/" + id + "/" + nomImage;
    }*/

   }