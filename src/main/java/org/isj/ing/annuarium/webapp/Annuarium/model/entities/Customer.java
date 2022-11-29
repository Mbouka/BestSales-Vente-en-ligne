package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Integer id;

    @Column(name = "nom_complet", nullable = false)
    private String nomComplet;

    @Column(name = "telephone", nullable = false)
    private Long telephone;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "quartier", nullable = false)
    private String quartier;

    @Column(name = "email")
    private String email;

}