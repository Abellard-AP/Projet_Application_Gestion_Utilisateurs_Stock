package fr.formation.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ADRESS")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "A_ID")
	private int aid;
	@Column(name = "A_VOIRIE")
	private String voirie;
	@Column(name = "A_CODEPOSTAL")
	private String codePostal;
	@Column(name = "A_VILLE")
	private String ville;

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	

	public Adresse(int aid, String voirie, String codePostal, String ville) {
		this.aid = aid;
		this.voirie = voirie;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(String voirie, String codePostal, String ville) {
		this.voirie = voirie;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse() {
		this.voirie = "";
		this.codePostal = "";
		this.ville = "";
	}

	public String getVoirie() {
		return voirie;
	}

	public void setVoirie(String voirie) {
		this.voirie = voirie;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "Adresse [aid=" + aid + ", voirie=" + voirie + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
}
