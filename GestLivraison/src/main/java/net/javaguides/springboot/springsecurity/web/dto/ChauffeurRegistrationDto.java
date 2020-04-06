package net.javaguides.springboot.springsecurity.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.NonNull;

public class ChauffeurRegistrationDto {
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message="*ce champ est obligatoire")

	private String nom;
	@NotEmpty(message="*ce champ est obligatoire")

	private String prenom;
	@NotEmpty(message="*ce champ est obligatoire")
	private String dateNai;
	@Pattern( regexp="^[5,2,9][0-9]{7}|{0}" ,message ="*invalid numéro de téléphone")
	@NotEmpty(message="*ce champ est obligatoire")

	private String NumTel;
	@NotEmpty(message="*ce champ est obligatoire")
	@Pattern( regexp="[0-9]{2}/[0-9]{6}|{0}" ,message ="*invalid numéro de permis")
	private String NumPermi;
	@Pattern( regexp="[0-9]{8}|{0}" ,message ="Le numéro cin doit contenir 8 chiffres")
	@NotEmpty(message="*ce champ est obligatoire")
	private String NumCin;
	
	@NotEmpty(message="*ce champ est obligatoire")

	private String login;
	
	@NotEmpty(message="*ce champ est obligatoire")

	private String MotPasse;
	@NotEmpty(message="*ce champ est obligatoire")

	private String etatDispo;

	public String getEtatDispo() {
		return etatDispo;
	}

	public void setEtatDispo(String etatDispo) {
		this.etatDispo = etatDispo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNai() {
		return dateNai;
	}

	public void setDateNai(String dateNai) {
		this.dateNai = dateNai;
	}

	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}

	public String getNumPermi() {
		return NumPermi;
	}

	public void setNumPermi(String numPermi) {
		NumPermi = numPermi;
	}

	public String getNumCin() {
		return NumCin;
	}

	public void setNumCin(String numCin) {
		NumCin = numCin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}
	


}
