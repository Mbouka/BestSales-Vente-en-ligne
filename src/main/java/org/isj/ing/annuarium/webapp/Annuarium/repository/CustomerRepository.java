package org.isj.ing.annuarium.webapp.Annuarium.repository;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}