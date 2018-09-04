package fr.formation.dao;

import java.util.List;

import fr.formation.dao.entity.User;

public interface IUserDAO {

	public User getUser(User u);
	public User getUserById(int id);
	public List<User> getAllUser();
	public void addUser(User u);
	public void modifyUser(User u);
	public void deleteUser(User u);
	
}
