package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "id_comprod", nullable = false)
    private Integer idComprod;

    @Column(name = "prix_liv", nullable = false)
    private Integer prixLiv;

    @Column(name = "quartier", nullable = false)
    private String quartier;

    @Column(name = "ville")
    private String ville;

    @Column(name = "date_liv")
    private LocalDate dateLiv;

    @OneToMany(mappedBy = "idLivraison")
    private Set<Commandeproduit> commandeproduits = new LinkedHashSet<>();

    public Set<Commandeproduit> getCommandeproduits() {
        return commandeproduits;
    }

    public void setCommandeproduits(Set<Commandeproduit> commandeproduits) {
        this.commandeproduits = commandeproduits;
    }

    public LocalDate getDateLiv() {
        return dateLiv;
    }

    public void setDateLiv(LocalDate dateLiv) {
        this.dateLiv = dateLiv;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public Integer getPrixLiv() {
        return prixLiv;
    }

    public void setPrixLiv(Integer prixLiv) {
        this.prixLiv = prixLiv;
    }

    public Integer getIdComprod() {
        return idComprod;
    }

    public void setIdComprod(Integer idComprod) {
        this.idComprod = idComprod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}