package fr.formation.dao;

import java.util.List;

import fr.formation.dao.entity.Fournisseur;
import fr.formation.exception.FournisseurException;

public interface IFournisseurDAO {

	public void ajouterFournisseur(Fournisseur fournisseur) throws FournisseurException;
	public void modifierFournisseur(Fournisseur fournisseur) throws FournisseurException;
	public void supprimerFournisseur(Fournisseur fournisseur);
	public Fournisseur retrouverFournisseur(int id);
	public List<Fournisseur> listeAllFournisseur();

}
