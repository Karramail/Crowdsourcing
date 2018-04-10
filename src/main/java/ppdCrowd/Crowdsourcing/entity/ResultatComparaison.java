package ppdCrowd.Crowdsourcing.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultatComparaison {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne 
	private Comparaison idComparaison;
	
	private int resultat;
	
	@ManyToOne
	private Utilisateur idCrowder;
	
	public ResultatComparaison() {
		super();
		
	}

	public ResultatComparaison(Comparaison idComparaison, int resultat, Utilisateur idCrowder) {
		super();
		this.idComparaison = idComparaison;
		this.resultat = resultat;
		this.idCrowder = idCrowder;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comparaison getIdComparaison() {
		return idComparaison;
	}

	public void setIdComparaison(Comparaison idComparaison) {
		this.idComparaison = idComparaison;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	public Utilisateur getIdCrowder() {
		return idCrowder;
	}

	public void setIdCrowder(Utilisateur idCrowder) {
		this.idCrowder = idCrowder;
	}
	
	
}
