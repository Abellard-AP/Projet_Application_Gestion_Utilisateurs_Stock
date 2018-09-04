package fr.formation.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IUserDAO;
import fr.formation.dao.entity.User;
import fr.formation.util.Encrypt;

@Service(value="userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDAO userDAO;

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User getLoggedUser(String userName, String password) {
		logger.info("In getLoggerUser");
		User u = new User();
		u.setLogin(userName);
		u = userDAO.getUser(u);

		boolean isLogged = false;
		if (u != null) {
			isLogged = Encrypt.checkHashedPwd(password, u.getPassword());
			logger.info("Out getLoggerUser");
		}
		if (isLogged) {
			return u;
		} else
			return null;
	}

	@Override
	public List<User> listerUser() {
		return userDAO.getAllUser();
	}

	@Override
	public User getUnUser(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void ajouterUser(User u) {
		userDAO.addUser(u);	
	}

	@Override
	public void modifierUser(User u) {
		userDAO.modifyUser(u);
		
	}

	@Override
	public void supprimerUser(int id) {
		User u = userDAO.getUserById(id);
		userDAO.deleteUser(u);		
	}

}
