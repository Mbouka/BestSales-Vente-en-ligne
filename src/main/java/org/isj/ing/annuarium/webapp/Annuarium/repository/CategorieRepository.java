package org.isj.ing.annuarium.webapp.Annuarium.repository;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findCatBynomCat(String cat);

//    Optional<List<Categorie>> findCategorieByNumeroOrNom(String motcle1, String motcle2);

}