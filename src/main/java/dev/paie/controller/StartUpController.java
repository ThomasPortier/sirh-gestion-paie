package dev.paie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;

@Controller
public class StartUpController {
		@Autowired
		private InitialiserDonneesService initService;
		//@Autowired
		private static final Logger LOGGER = LoggerFactory.getLogger(StartUpController.class);
		
		
		@EventListener(ContextRefreshedEvent.class)
		public void contextRefreshedEvent(){
			LOGGER.info("Initialisation des donnees");
			//System.out.println("Initialisation des donnees");
			//initService.initialiser();
		}
}
