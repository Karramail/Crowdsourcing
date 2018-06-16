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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comparaison {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Ligne idLigne1;

	@ManyToOne
	private Ligne idLigne2;

	
	private int levChamp1;
	private int levChamp2;
	private int levChamp3;
	private int levChamp4;
	private int levChamp5;
	
	
	public Comparaison() {
		super();
	}
	
	public Comparaison(Ligne idLigne1, Ligne idLigne2) {

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

	public int getLevChamp1() {
		return levChamp1;
	}

	public void setLevChamp1(int levChamp1) {
		this.levChamp1 = levChamp1;
	}

	public int getLevChamp2() {
		return levChamp2;
	}

	public void setLevChamp2(int levChamp2) {
		this.levChamp2 = levChamp2;
	}

	public int getLevChamp3() {
		return levChamp3;
	}

	public void setLevChamp3(int levChamp3) {
		this.levChamp3 = levChamp3;
	}

	public int getLevChamp4() {
		return levChamp4;
	}

	public void setLevChamp4(int levChamp4) {
		this.levChamp4 = levChamp4;
	}

	public int getLevChamp5() {
		return levChamp5;
	}

	public void setLevChamp5(int levChamp5) {
		this.levChamp5 = levChamp5;
	}
	

}