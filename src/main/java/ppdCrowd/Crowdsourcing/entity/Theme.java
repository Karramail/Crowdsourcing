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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Theme {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom_theme;
	
	@JsonIgnore
	@OneToMany(mappedBy="id_theme", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fichier> fichiers;
	

	public Theme() {
		super();
		
	}
	
	public Theme(String name) {
		super();
		this.nom_theme = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomTheme() {
		return nom_theme;
	}


	public void setNomTheme(String nomTheme) {
		this.nom_theme = nomTheme;
	}


	public List<Fichier> getFichiers() {
		return fichiers;
	}


	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	
	
	
	
		

}
