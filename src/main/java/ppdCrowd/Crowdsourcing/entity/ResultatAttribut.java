package ppdCrowd.Crowdsourcing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultatAttribut {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String typeAtr;
	
	
	@ManyToOne
	private Attribut idAttribut;
	
	@ManyToOne
	private Resultat idResultat;
	
	
	public ResultatAttribut() {
		super();
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getTypeAtr() {
		return typeAtr;
	}



	public void setTypeAtr(String typeAtr) {
		this.typeAtr = typeAtr;
	}



	public Attribut getIdAttribut() {
		return idAttribut;
	}



	public void setIdAttribut(Attribut idAttribut) {
		this.idAttribut = idAttribut;
	}



	public Resultat getIdResultat() {
		return idResultat;
	}



	public void setIdResultat(Resultat idResultat) {
		this.idResultat = idResultat;
	}



}
