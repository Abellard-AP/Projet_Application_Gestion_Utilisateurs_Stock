package fr.formation.service;

import java.util.List;

import fr.formation.dao.entity.Fournisseur;

public interface IFournisseurService {
	public List<Fournisseur> listerFourn ();
	public Fournisseur getUnFourn(int id);
	public void ajouterFourn(Fournisseur f);
	public void modifierFourn(Fournisseur f);
	public void supprimerFourn(int id);
}
