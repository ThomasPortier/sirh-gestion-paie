package dev.paie.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@ContextConfiguration(classes = { JpaConfig.class, DataSourceMySQLConfig.class })
// TODO compléter la configuration
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		
		List<Cotisation> listeCotisations = new ArrayList<>();
		listeCotisations.add(new Cotisation("code1", "libelle1", new BigDecimal(1.1),new BigDecimal(1.1)));
		listeCotisations.add(new Cotisation("code2", "libelle2", new BigDecimal(2.1),new BigDecimal(1.2)));
		listeCotisations.add(new Cotisation("code3", "libelle3", new BigDecimal(3.1),new BigDecimal(1.3)));
		listeCotisations.add(new Cotisation("code4", "libelle4", new BigDecimal(4.1),new BigDecimal(1.4)));
		listeCotisations.add(new Cotisation("code5", "libelle5", new BigDecimal(5.1),new BigDecimal(1.5)));
		listeCotisations.add(new Cotisation("code6", "libelle6", new BigDecimal(6.1),new BigDecimal(1.6)));
		listeCotisations.add(new Cotisation("code7", "libelle7", new BigDecimal(7.1),new BigDecimal(1.7)));
		listeCotisations.add(new Cotisation("code8", "libelle8", new BigDecimal(8.1),new BigDecimal(1.8)));
		
		for(Cotisation cotisationIndex : listeCotisations){
			cotisationService.sauvegarder(cotisationIndex);
		}
		
		
		int compteAvant = cotisationService.lister().size();
		Cotisation uneCotisation = new Cotisation("code9", "libelle9", new BigDecimal(9.1),new BigDecimal(1.9));
		listeCotisations.add(uneCotisation);
		cotisationService.sauvegarder(uneCotisation);
		int compteApres = cotisationService.lister().size();
		//TEST SAUVEGARDER
		assertEquals(compteAvant + 1, compteApres);
		
		
		Cotisation uneAutreCotisation =new Cotisation("code10", "libelle10", new BigDecimal(10.1),new BigDecimal(10.9));
		listeCotisations.add(uneAutreCotisation);
		cotisationService.sauvegarder(uneAutreCotisation);
		Cotisation cotisationCompare = new Cotisation();
		cotisationCompare = listeCotisations.get(listeCotisations.size() - 1);
		//TEST LISTER
		//assertEquals(uneAutreCotisation, cotisationCompare);

		
		int lastIndexList = listeCotisations.size() - 1;
		cotisationService.mettreAJour(listeCotisations.get(lastIndexList));

		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}

}
