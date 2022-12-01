package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "commandeproduit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commandeproduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_com_prod", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande idCommande;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit idProduit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_livraison", nullable = false)
    private Livraison idLivraison;

}