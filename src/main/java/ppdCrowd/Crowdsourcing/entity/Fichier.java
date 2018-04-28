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
public class Fichier {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom_fichier;
	
	@ManyToOne
	private Import id_import;
	
	@ManyToOne
	private Theme id_theme;
	
	@JsonIgnore
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
		this.nom_fichier = nomFichier;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomFichier() {
		return nom_fichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nom_fichier = nomFichier;
	}

	public Import getIdImport() {
		return id_import;
	}

	public void setIdImport(Import idImport) {
		this.id_import = idImport;
	}

	public Theme getIdTheme() {
		return id_theme;
	}

	public void setIdTheme(Theme idTheme) {
		this.id_theme = idTheme;
	}


	public List<Ligne> getLignes() {
		return lignes;
	}


	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	
	
}
