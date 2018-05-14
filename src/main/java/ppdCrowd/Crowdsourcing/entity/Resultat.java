package ppdCrowd.Crowdsourcing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Resultat {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private boolean identique;
	
	@JsonIgnore
	@ManyToOne
	private Utilisateur idUtilisateur;
	
	@JsonIgnore
	@ManyToOne
	private Comparaison idTuple;
	
	public Resultat() {
		super();
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public boolean isIdentique() {
		return identique;
	}



	public void setIdentique(boolean identique) {
		this.identique = identique;
	}



	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}



	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public Comparaison getIdTuple() {
		return idTuple;
	}



	public void setIdTuple(Comparaison idTuple) {
		this.idTuple = idTuple;
	}







}
