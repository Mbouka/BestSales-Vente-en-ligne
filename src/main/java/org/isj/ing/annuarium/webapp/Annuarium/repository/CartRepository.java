package org.isj.ing.annuarium.webapp.Annuarium.repository;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
