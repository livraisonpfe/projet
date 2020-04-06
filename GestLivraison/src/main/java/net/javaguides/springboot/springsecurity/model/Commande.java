package net.javaguides.springboot.springsecurity.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande", nullable = false)
	private int id;
private boolean etat_com;
private String dateCom;
	//mapping commande colis
@OneToMany(mappedBy="commandeC")
private Set<Colis>ColisCommande =new HashSet<Colis>();	

//mapping commande marchand
	@ManyToOne
	@JoinColumn(name="id_marchand")	
	private Marchand marchandM;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isEtat_com() {
		return etat_com;
	}


	public void setEtat_com(boolean etat_com) {
		this.etat_com = etat_com;
	}


	public String getDateCom() {
		return dateCom;
	}


	public void setDateCom(String dateCom) {
		this.dateCom = dateCom;
	}


	public Marchand getMarchandM() {
		return marchandM;
	}


	public void setMarchandM(Marchand marchandM) {
		this.marchandM = marchandM;
	}
	public void addColisCommande(Colis c)
	{
		c.setCommandeC(this);
		ColisCommande.add(c);
	}
	public Set<Colis> getColisCommande() {return ColisCommande;	}
}
