package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;

public class CotisationServiceJpa implements CotisationService {
	
	@PersistenceContext private EntityManager em;


	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		Grade unGrade = new Grade("Voila", new BigDecimal(532.56), new BigDecimal(32.89));
		em.getTransaction().begin();
		em.persist(unGrade);
		em.getTransaction().commit();
		// TODO Auto-generated method stub

	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cotisation> lister() {
		// TODO Auto-generated method stub
		return null;
	}

}
