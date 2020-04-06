package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;


@Entity
@Table(name = "chauffeur")
@PrimaryKeyJoinColumn(name = "id")
public class Chauffeur extends User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;
    @ManyToOne
	@JoinColumn(name="id_admin")	
	private Admin adminA;
    @Column(name = "nom")
    private String nom;
    
    public Long getId()
    {
    	return id;
    }
    
    public void setId(Long id)
    {
    	this.id=id;
    }
    public Admin getAdminA() {
		return adminA;
	}

	public void setAdminA(Admin adminA) {
		this.adminA = adminA;
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

	
	
	public String getEtatDispo() {
		return etatDispo;
	}

	public void setEtatDispo(String etatDispo) {
		this.etatDispo = etatDispo;
	}

	public String getDateNai() {
		return DateNai;
	}

	public void setDateNai(String dateNai) {
		DateNai = dateNai;
	}
	@Column(name = "NumTel")
    private String NumTel;
	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	@Column(name = "prenom")
    private String prenom;
    public String getNumPermis() {
		return NumPermis;
	}

	public void setNumPermis(String numPermis) {
		NumPermis = numPermis;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	@Column(name = "etat_dispo")
    private String etatDispo;
    
    @Column(name = "DateNai")
    private String DateNai;
    @Column(name = "NumPermis")
    private String NumPermis;
    @Column(name = "cin")
    private String cin;
    
}
