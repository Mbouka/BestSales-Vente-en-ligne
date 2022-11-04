package org.isj.ing.annuarium.webapp.Annuarium.repository;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
}