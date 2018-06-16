package ppdCrowd.Crowdsourcing.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultatCrowder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Comparaison id_Comparaison;
	

	private Float Champ1_Left;
	private Float Champ2_Left;
	private Float Champ3_Left;
	private Float Champ4_Left;
	private Float Champ5_Left;
	
	private int nbReponse_Crowder;
	private int nbReponse_Similaire;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Comparaison getId_Comparaison() {
		return id_Comparaison;
	}



	public void setId_Comparaison(Comparaison id_Comparaison) {
		this.id_Comparaison = id_Comparaison;
	}



	public Float getChamp1_Left() {
		return Champ1_Left;
	}



	public void setChamp1_Left(Float champ1_Left) {
		Champ1_Left = champ1_Left;
	}



	public Float getChamp2_Left() {
		return Champ2_Left;
	}



	public void setChamp2_Left(Float champ2_Left) {
		Champ2_Left = champ2_Left;
	}



	public Float getChamp3_Left() {
		return Champ3_Left;
	}



	public void setChamp3_Left(Float champ3_Left) {
		Champ3_Left = champ3_Left;
	}



	public Float getChamp4_Left() {
		return Champ4_Left;
	}



	public void setChamp4_Left(Float champ4_Left) {
		Champ4_Left = champ4_Left;
	}



	public Float getChamp5_Left() {
		return Champ5_Left;
	}



	public void setChamp5_Left(Float champ5_Left) {
		Champ5_Left = champ5_Left;
	}



	public int getNbReponse_Crowder() {
		return nbReponse_Crowder;
	}



	public void setNbReponse_Crowder(int nbReponse_Crowder) {
		this.nbReponse_Crowder = nbReponse_Crowder;
	}



	public int getNbReponse_Similaire() {
		return nbReponse_Similaire;
	}



	public void setNbReponse_Similaire(int nbReponse_Similaire) {
		this.nbReponse_Similaire = nbReponse_Similaire;
	}



	public ResultatCrowder() {
		super();
	}
	
	
}