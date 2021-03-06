package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ProfilRemuneration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String code;
	
	@ManyToMany
	@JoinTable(name= "ProfilRem_Cot_Not_Imp",
	joinColumns = @JoinColumn(name = "ID_ProfilRem", referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "Cot_ID", referencedColumnName = "ID"))
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany
	@JoinTable(name= "ProfilRem_Cot_Imp",
	joinColumns = @JoinColumn(name = "ID_ProfilRem", referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "Cot_ID", referencedColumnName = "ID"))
	private List<Cotisation> cotisationsImposables;
	@OneToMany
	private List<Avantage> avantages;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
