package net.javaguides.springboot.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Marchand")
@PrimaryKeyJoinColumn(name = "id")

public class Marchand extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marchand", nullable = false)
	private Long id;
    @Column(name = "adresse")
    @NotNull
    private String adresse;
    @OneToMany(mappedBy="marchandM")
	private Set<Commande>CommandesMarchand =new HashSet<Commande>();
    public String getAdresse() {
		return adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Set<Commande> getCommandesMarchand() {
		return CommandesMarchand;
	}

	public void setCommandesMarchand(Set<Commande> commandesMarchand) {
		CommandesMarchand = commandesMarchand;
	}

	public String getVille() {
		return ville;
	}
*/
	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "nom")
    private String nom;
    
    @Column(name = "Prenom")
    private String Prenom;
    
    @Column(name = "ville")
    private String ville;
    
    @Column(name = "tel")
    private String tel;
    
    
    

}