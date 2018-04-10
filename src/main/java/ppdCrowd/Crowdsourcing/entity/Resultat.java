package ppdCrowd.Crowdsourcing.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Resultat {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String champsLeft;
	
	private String champsRight;
	
	@OneToOne
	private Import idImport;
	
	public Resultat() {
		super();
		
	}
	
	

	public Resultat(String champsLeft, String champsRight, Import idImport) {
		super();
		this.champsLeft = champsLeft;
		this.champsRight = champsRight;
		this.idImport = idImport;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChampsLeft() {
		return champsLeft;
	}

	public void setChampsLeft(String champsLeft) {
		this.champsLeft = champsLeft;
	}

	public String getChampsRight() {
		return champsRight;
	}

	public void setChampsRight(String champsRight) {
		this.champsRight = champsRight;
	}

	public Import getIdImport() {
		return idImport;
	}

	public void setIdImport(Import idImport) {
		this.idImport = idImport;
	}


}
