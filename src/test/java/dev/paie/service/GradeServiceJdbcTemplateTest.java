package dev.paie.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
// TODO compléter la configuration
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;
	
	       
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		int compteAvant = gradeService.lister().size();
		Grade unGrade = new Grade("Voila", new BigDecimal(532.56), new BigDecimal(32.89));
		gradeService.sauvegarder(unGrade);
		int compteApres = gradeService.lister().size();

		assertEquals(compteAvant + 1, compteApres);
		
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		
		
		Grade gradeCompare = new Grade();
		List<Grade> liste = gradeService.lister();
		gradeCompare = liste.get(liste.size()-1);
		assertEquals(unGrade, gradeCompare);
		System.out.println(unGrade);
		System.out.println(gradeCompare);

		
		// TODO modifier un grade
		Grade unAutreGrade = new Grade("Voila", new BigDecimal(598765.56), new BigDecimal(352.89));
		unAutreGrade.setId(4);
		gradeService.mettreAJour(unAutreGrade);
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}