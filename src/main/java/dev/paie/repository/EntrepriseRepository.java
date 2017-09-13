package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.paie.entite.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
