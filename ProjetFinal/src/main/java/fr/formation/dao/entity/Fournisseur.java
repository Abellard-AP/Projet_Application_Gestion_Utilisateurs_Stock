package fr.formation.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PROVIDER")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FR_ID")
	private int id;
	
	
	@Column(name="FR_REFERENCE")
	private String reference;
	@Column(name="FR_NOM")
	private String nom;
	@OneToOne(orphanRemoval=true)
	@JoinColumn(name="A_ID", referencedColumnName="A_ID")
	private Adresse adresse;
	
	public Fournisseur(int id, String reference, String nom, Adresse adresse) {
		this.id = id;
		this.reference = reference;
		this.nom = nom;
		this.adresse = adresse;
	}

	public Fournisseur(String reference, String nom, Adresse adresse) {
		this.reference = reference;
		this.nom = nom;
		this.adresse = adresse;
	}

	public Fournisseur() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", reference=" + reference + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
}
