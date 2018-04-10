package ppdCrowd.Crowdsourcing.entity;

import java.util.Date;
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
public class Fichier {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nomFichier;
	
	@ManyToOne
	private Import idImport;
	
	@ManyToOne
	private Theme idTheme;
	
	@OneToMany(mappedBy="idFichier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ligne> lignes;
	
	public Fichier(int idFichier) {
		super();
		this.id = idFichier;
		
	}
	
	public Fichier() {
		super();
	}
	

	public Fichier(String nomFichier) {
		super();
		this.nomFichier = nomFichier;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public Import getIdImport() {
		return idImport;
	}

	public void setIdImport(Import idImport) {
		this.idImport = idImport;
	}

	public Theme getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(Theme idTheme) {
		this.idTheme = idTheme;
	}


	public List<Ligne> getLignes() {
		return lignes;
	}


	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	
	
}
