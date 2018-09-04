package fr.formation.dao;

import fr.formation.dao.entity.Adresse;

public interface IAdresseDAO {
	public void ajouterAdresse(Adresse adresse);
	public void modifierAdresse(Adresse adresse);
	public Adresse retrouverAdresse(int id);
}
