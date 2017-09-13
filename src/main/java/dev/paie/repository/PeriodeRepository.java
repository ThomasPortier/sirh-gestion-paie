package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.paie.entite.Grade;
import dev.paie.entite.Periode;

@Repository
public interface PeriodeRepository extends JpaRepository<Grade, Integer> {

	void save(Periode periode);

}
