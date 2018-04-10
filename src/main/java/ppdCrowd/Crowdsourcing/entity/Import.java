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
public class Import {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date dateImport;
	
	@ManyToOne
	private Utilisateur idDemandeur;
	
	@OneToMany(mappedBy="idImport", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fichier> fichiers;
	
	public Import() {
		super();
		
	}

	public Import(int id, Date dateImport, Utilisateur idDemandeur) {
		super();
		this.dateImport = dateImport;
		this.idDemandeur = idDemandeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateImport() {
		return dateImport;
	}

	public void setDateImport(Date dateImport) {
		this.dateImport = dateImport;
	}

	public Utilisateur getIdDemandeur() {
		return idDemandeur;
	}

	public void setIdDemandeur(Utilisateur idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	
	
	
		

}
