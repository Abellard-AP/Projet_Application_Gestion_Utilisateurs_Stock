package fr.formation.service;

import java.util.List;

import fr.formation.dao.entity.User;

public interface IUserService {

	public User getLoggedUser(String userName, String Password);
	public List<User> listerUser ();
	public User getUnUser(int id);
	public void ajouterUser(User u);
	public void modifierUser(User u);
	public void supprimerUser(int id);
}
