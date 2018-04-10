package ppdCrowd.Crowdsourcing.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comparaison {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Ligne idLigne1;
	
	@ManyToOne
	private Ligne idLigne2;
	
	@OneToMany(mappedBy="idComparaison", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ResultatComparaison> resultatComparaisons;
	
	public Comparaison() {
		super();
		
	}
	
	

	public Comparaison(Ligne idLigne1, Ligne idLigne2) {
		super();
		this.idLigne1 = idLigne1;
		this.idLigne2 = idLigne2;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ligne getIdLigne1() {
		return idLigne1;
	}

	public void setIdLigne1(Ligne idLigne1) {
		this.idLigne1 = idLigne1;
	}

	public Ligne getIdLigne2() {
		return idLigne2;
	}

	public void setIdLigne2(Ligne idLigne2) {
		this.idLigne2 = idLigne2;
	}



	public List<ResultatComparaison> getResultatComparaisons() {
		return resultatComparaisons;
	}



	public void setResultatComparaisons(List<ResultatComparaison> resultatComparaisons) {
		this.resultatComparaisons = resultatComparaisons;
	}
	
	

}
