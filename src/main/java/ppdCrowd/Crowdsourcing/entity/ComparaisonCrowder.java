package ppdCrowd.Crowdsourcing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ComparaisonCrowder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Comparaison id_Comparaison;
	
	@ManyToOne
	private Utilisateur id_Crowder;

	private boolean isChamp1_Left;
	private boolean isChamp2_Left;
	private boolean isChamp3_Left;
	private boolean isChamp4_Left;
	private boolean isChamp5_Left;
	
	private boolean isSimilaire;
	
	
	public ComparaisonCrowder() {
		super();
	}
	
	
	
	
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

	public Utilisateur getId_Crowder() {
		return id_Crowder;
	}

	public void setId_Crowder(Utilisateur id_Crowder) {
		this.id_Crowder = id_Crowder;
	}

	public boolean isChamp1_Left() {
		return isChamp1_Left;
	}

	public void setChamp1_Left(boolean isChamp1_Left) {
		this.isChamp1_Left = isChamp1_Left;
	}

	public boolean isChamp2_Left() {
		return isChamp2_Left;
	}

	public void setChamp2_Left(boolean isChamp2_Left) {
		this.isChamp2_Left = isChamp2_Left;
	}

	public boolean isChamp3_Left() {
		return isChamp3_Left;
	}

	public void setChamp3_Left(boolean isChamp3_Left) {
		this.isChamp3_Left = isChamp3_Left;
	}

	public boolean isChamp4_Left() {
		return isChamp4_Left;
	}

	public void setChamp4_Left(boolean isChamp4_Left) {
		this.isChamp4_Left = isChamp4_Left;
	}

	public boolean isChamp5_Left() {
		return isChamp5_Left;
	}

	public void setChamp5_Left(boolean isChamp5_Left) {
		this.isChamp5_Left = isChamp5_Left;
	}

	public boolean isSimilaire() {
		return isSimilaire;
	}

	public void setSimilaire(boolean isSimilaire) {
		this.isSimilaire = isSimilaire;
	}

}