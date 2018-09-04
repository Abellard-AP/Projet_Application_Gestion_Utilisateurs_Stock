package fr.formation.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCT")
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRD_ID")
	private int id;
	
	@Column(name="PRD_REFERENCE")
	private String reference;
	
	@Column(name="PRD_DESIGNATION")
	private String designation;
	
	@Column(name="PRD_PRIX")
	private String prix;
	
	@Column(name="PRD_QUANTITE")
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name="FR_ID", referencedColumnName="FR_ID")
	private Fournisseur fournisseur;

	public Produit(int id, String reference, String designation, String prix, int quantite, Fournisseur fournisseur) {
		this.id = id;
		this.reference = reference;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.fournisseur = fournisseur;
	}

	public Produit(String reference, String designation, String prix, int quantite, Fournisseur fournisseur) {
		this.reference = reference;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.fournisseur = fournisseur;
	}
	
	public Produit() {}

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", reference=" + reference + ", designation=" + designation + ", prix=" + prix
				+ ", quantite=" + quantite + ", fournisseur=" + fournisseur + "]";
	}
		
}
