package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@EnableTransactionManagement
@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation uneCotisation) {
		 Cotisation uneCotisationToUpdate= (Cotisation)em.find(Cotisation.class ,uneCotisation.getId());
		 uneCotisationToUpdate.setLibelle("Updated libelle");
		 uneCotisationToUpdate.setTauxPatronal(new BigDecimal(888.88));
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("from Cotisation", Cotisation.class);
		List<Cotisation> listeCotisation = (query.getResultList());
		for (Cotisation indexCotisation : listeCotisation) {
			System.out.println(indexCotisation);
		}
		return query.getResultList();
	}

}
