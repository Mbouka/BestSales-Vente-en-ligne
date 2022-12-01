package org.isj.ing.annuarium.webapp.Annuarium;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Vendeur;
import org.isj.ing.annuarium.webapp.Annuarium.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnuariumApplication implements CommandLineRunner {
@Autowired
	CategorieRepository categorieRepository;
@Autowired
	VendeurRepository vendeurRepository;
@Autowired
	CommandeproduitRepository commandeproduitRepository;
@Autowired
	LivraisonRepository livraisonRepository;
@Autowired
	CommandeRepository commandeRepository;
@Autowired
CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnnuariumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		categorieRepository.save(new Categorie(null,"electro-ménagé"));
		categorieRepository.save(new Categorie(null,"cuisine"));
		categorieRepository.save(new Categorie(null,"mode"));
		categorieRepository.save(new Categorie(null,"mécanique"));
		categorieRepository.save(new Categorie(null,"voyage"));

		vendeurRepository.save(new Vendeur(null,"vinny",69823688L,"douala","ndogbong","yup@gmail.com","yup yup"));
		vendeurRepository.save(new Vendeur(null,"jay",6948202L,"Yaoundé","damas","combo@gmail.com","comboSarl"));

		customerRepository.save(new Customer(null,"vinny",69178459L,"yaounde","mendong","vinny@gmail.com"));
		customerRepository.save(new Customer(null,"linda",69198459L,"yaounde","mendong","linda@gmail.com"));
		customerRepository.save(new Customer(null,"jay",69177959L,"douala","nn","jay@gmail.com"));
*/
	}
}
