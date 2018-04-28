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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Import {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date date_import;
	
	@ManyToOne
	private Utilisateur id_demandeur;
	
	@JsonIgnore
	@OneToMany(mappedBy="id_import", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fichier> fichiers;
	
	public Import() {
		super();
		
	}

	public Import(int id, Date dateImport, Utilisateur idDemandeur) {
		super();
		this.date_import = dateImport;
		this.id_demandeur = idDemandeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateImport() {
		return date_import;
	}

	public void setDateImport(Date dateImport) {
		this.date_import = dateImport;
	}

	public Utilisateur getIdDemandeur() {
		return id_demandeur;
	}

	public void setIdDemandeur(Utilisateur idDemandeur) {
		this.id_demandeur = idDemandeur;
	}

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	
	
	
		

}
