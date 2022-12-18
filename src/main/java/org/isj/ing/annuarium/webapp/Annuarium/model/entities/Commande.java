package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "commande")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private Integer id;

    @Column(name = "qntite_commande")
    private Integer qntiteCommande;


    @Column(name = "date_com", nullable = false)
    private LocalDate dateCom;



    @OneToMany(mappedBy = "idCommande")
    private Set<Commandeproduit> commandeproduits = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idCommande")
    private Set<Facture> factures = new LinkedHashSet<>();

    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    public Set<Commandeproduit> getCommandeproduits() {
        return commandeproduits;
    }

    public void setCommandeproduits(Set<Commandeproduit> commandeproduits) {
        this.commandeproduits = commandeproduits;
    }

    public LocalDate getDateCom() {
        return dateCom;
    }

    public void setDateCom(LocalDate dateCom) {
        this.dateCom = dateCom;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}