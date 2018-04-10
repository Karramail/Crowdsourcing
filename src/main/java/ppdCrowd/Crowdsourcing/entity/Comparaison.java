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

	@OneToMany (mappedBy="idComparaison", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ResultatComparaison> resultatComparaisons;

	private int resChamp1;
	private int resChamp2;
	private int resChamp3;
	
	public Comparaison() {
		super();
	}
	
	public Comparaison(int id, Ligne idLigne1, Ligne idLigne2, List<ResultatComparaison> resultatComparaisons,
			int resChamp1, int resChamp2, int resChamp3, int resChamp4) {

		this.idLigne1 = idLigne1;
		this.idLigne2 = idLigne2;
		this.resultatComparaisons = resultatComparaisons;
		this.resChamp1 = resChamp1;
		this.resChamp2 = resChamp2;
		this.resChamp3 = resChamp3;
		this.resChamp4 = resChamp4;
	}
	private int resChamp4;
	
	
	
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
	public int getResChamp1() {
		return resChamp1;
	}
	public void setResChamp1(int resChamp1) {
		this.resChamp1 = resChamp1;
	}
	public int getResChamp2() {
		return resChamp2;
	}
	public void setResChamp2(int resChamp2) {
		this.resChamp2 = resChamp2;
	}
	public int getResChamp3() {
		return resChamp3;
	}
	public void setResChamp3(int resChamp3) {
		this.resChamp3 = resChamp3;
	}
	public int getResChamp4() {
		return resChamp4;
	}
	public void setResChamp4(int resChamp4) {
		this.resChamp4 = resChamp4;
	}

}