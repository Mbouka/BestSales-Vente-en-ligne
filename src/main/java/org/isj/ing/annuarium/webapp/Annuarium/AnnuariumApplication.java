package org.isj.ing.annuarium.webapp.Annuarium;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Vendeur;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CategorieRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.VendeurRepository;
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
	public static void main(String[] args) {
		SpringApplication.run(AnnuariumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*categorieRepository.save(new Categorie(null,"electro-ménagé"));
		categorieRepository.save(new Categorie(null,"cuisine"));
		categorieRepository.save(new Categorie(null,"mode"));
		categorieRepository.save(new Categorie(null,"mécanique"));
		categorieRepository.save(new Categorie(null,"voyage"));

		vendeurRepository.save(new Vendeur(null,"vinny",69823688L,null,null,null));
		vendeurRepository.save(new Vendeur(null,"jay",6948202L,null,null,null));*/
	}
}
