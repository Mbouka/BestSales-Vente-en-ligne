package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "livraison")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livraison", nullable = false)
    private Integer id;

    @Column(name = "id_comprod", nullable = true)
    private Integer idComprod;

    @Column(name = "prix_liv", nullable = true)
    private String prixLiv ;

    @Column(name = "quartier", nullable = false)
    private String quartier;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "nom_client", nullable = false)
    private String client;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone", nullable = false)
    private Long telephone;

    @Column(name = "date_liv" ,nullable = false)
    private String dateLiv ;
//
//    @OneToMany(mappedBy = "idLivraison")
//    private Set<Commandeproduit> commandeproduits = new LinkedHashSet<>();
//
//    public Set<Commandeproduit> getCommandeproduits() {
//        return commandeproduits;
//    }
//
//    public void setCommandeproduits(Set<Commandeproduit> commandeproduits) {
//        this.commandeproduits = commandeproduits;
//    }




}