package fr.formation.service;

import java.util.List;

import fr.formation.dao.entity.Produit;

public interface IProduitService {
	public List<Produit> listerProduit ();
	public Produit getUnProduit(int id);
	public void ajouterProduit(Produit p);
	public void modifierProduit(Produit p);
	public void supprimerProduit(int id);
}
