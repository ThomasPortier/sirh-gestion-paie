package dev.paie.web.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.repository.BulletinSalaireRepository;

@Controller
@RequestMapping({"/employes","/bulletins"})
public class RemunerationEmployeController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	///////////////////////////////// EMPLOYE ////////////////////////////////////////////////

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("prefixMatricule");
		mv.addObject("listeEntreprises", entrepriseRepository.findAll());
		mv.addObject("listeProfilRemuneration", profilRemunerationRepository.findAll());
		mv.addObject("listeGrades", gradeRepository.findAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/validerForm")
	public ModelAndView validerEmploye(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("matricule"));
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		remunerationEmploye.setMatricule(request.getParameter("matricule"));
		remunerationEmploye
				.setEntreprise(entrepriseRepository.findOne(Integer.parseInt(request.getParameter("entrepriseId"))));
		remunerationEmploye.setGrade(gradeRepository.findOne(Integer.parseInt(request.getParameter("gradeId"))));
		remunerationEmploye.setProfilRemuneration(
				profilRemunerationRepository.findOne(Integer.parseInt(request.getParameter("profilId"))));
		remunerationEmployeRepository.save(remunerationEmploye);

		return new ModelAndView("redirect:" + "/mvc/employes/lister");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/employes/listerEmploye");
		System.out.println(remunerationEmployeRepository.findAll());
		mv.addObject("listeRemunerationEmploye", remunerationEmployeRepository.findAll());
		return mv;
	}
	
	/////////////////////////////////////////// BULLETIN /////////////////////////////////////////////////////////////////
	
	@RequestMapping(method = RequestMethod.GET, path = "/create")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("listePeriodes", periodeRepository.findAll());
		mv.addObject("listeRemunerationEmploye", remunerationEmployeRepository.findAll());
		mv.addObject("prefixePrimeExceptionnelle");

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/validerFormBulletin")
	public ModelAndView validerBulletin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BulletinSalaire  bulletinSalaire = new BulletinSalaire();
		
		bulletinSalaire.setPeriode(periodeRepository.findOne(Integer.parseInt(request.getParameter("periodeId"))));
		bulletinSalaire.setRemunerationEmploye(remunerationEmployeRepository.findOne(Integer.parseInt(request.getParameter("remunerationId"))));
		System.out.println(request.getParameter("PrimeExceptionnelle"));
		System.out.println(request.getParameter("PrimeExceptionnelle").getClass());
		System.out.println(Integer.parseInt(request.getParameter("PrimeExceptionnelle")));
		System.out.println(Integer.parseInt(request.getParameter("PrimeExceptionnelle")));
		System.out.println(BigDecimal.valueOf(Integer.parseInt(request.getParameter("PrimeExceptionnelle"))));
		System.out.println(BigDecimal.valueOf(Integer.parseInt(request.getParameter("PrimeExceptionnelle"))).getClass());
		bulletinSalaire.setPrimeExceptionnelle(BigDecimal.valueOf(Integer.parseInt(request.getParameter("PrimeExceptionnelle"))));
		
		bulletinSalaireRepository.save(bulletinSalaire);

		return new ModelAndView("redirect:" + "/mvc/bulletins/listerBulletin");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listerBulletin")
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bulletins/listerBulletin");
		System.out.println(bulletinSalaireRepository.findAll());
		mv.addObject("listeBulletinSalaire", bulletinSalaireRepository.findAll());
		return mv;
	}

}