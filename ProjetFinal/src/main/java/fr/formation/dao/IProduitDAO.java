package fr.formation.dao;

import java.util.List;

import fr.formation.dao.entity.Produit;


public interface IProduitDAO {

	public void ajouterUnProduit(Produit produit);
	public void modifierUnProduit(Produit produit);
	public void supprimerProduit(Produit produit);
	public Produit retrouverProduit(int id);
	public List<Produit> listeAllProduit();

}
