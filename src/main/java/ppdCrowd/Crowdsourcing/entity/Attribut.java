package ppdCrowd.Crowdsourcing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Attribut {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String label;
	
	private String typeAtr;
	
	private int place;
	
	private Float resultat;
	
	@JsonIgnore
	@ManyToOne
	private Import idImport;
	
	
	public Attribut() {
		super();
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public String getTypeAtr() {
		return typeAtr;
	}



	public void setTypeAtr(String typeAtr) {
		this.typeAtr = typeAtr;
	}



	public int getPlace() {
		return place;
	}



	public void setPlace(int place) {
		this.place = place;
	}



	public Float getResultat() {
		return resultat;
	}



	public void setResultat(Float resultat) {
		this.resultat = resultat;
	}



	public Import getIdImport() {
		return idImport;
	}



	public void setIdImport(Import idImport) {
		this.idImport = idImport;
	}






}
