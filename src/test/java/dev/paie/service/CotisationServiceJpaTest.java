package dev.paie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Cotisation;
import dev.paie.service.CotisationService;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;


@ContextConfiguration(classes = { JpaConfig.class , DataSourceMySQLConfig.class })
//TODO compléter la configuration
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;
	// TODO compléter la configuration

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Cotisation uneCotisation = new Cotisation();
		cotisationService.sauvegarder(uneCotisation);
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}

}
