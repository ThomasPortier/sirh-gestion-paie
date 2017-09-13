package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Component
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private List<ProfilRemuneration> listeProfilRemuneration;

	@Autowired
	private List<Entreprise> listeEntreprises;

	@Autowired
	private List<Cotisation> listeCotisations;

	@Autowired
	private List<Grade> listeGrades;

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private CotisationRepository cotisationRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private PeriodeRepository periodeRepository;

	@Override
	public void initialiser() {

		for (Cotisation indexCotisation : listeCotisations) {
			cotisationRepository.save(indexCotisation);
		}

		for (ProfilRemuneration indexProfilRemuneration : listeProfilRemuneration) {
			profilRemunerationRepository.save(indexProfilRemuneration);
		}

		for (Entreprise indexEntreprise : listeEntreprises) {
			entrepriseRepository.save(indexEntreprise);
		}

		for (Grade indexGrade : listeGrades) {
			gradeRepository.save(indexGrade);
		}

		for (int i = 1; i <= 12; i++) {
			periodeRepository.save(new Periode(i));
		}
		// TODO Auto-generated method stub

	}

}
