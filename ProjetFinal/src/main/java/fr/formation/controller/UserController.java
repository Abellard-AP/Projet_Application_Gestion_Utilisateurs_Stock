package fr.formation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.dao.entity.Fournisseur;
import fr.formation.dao.entity.Produit;
import fr.formation.dao.entity.User;
import fr.formation.service.IFournisseurService;
import fr.formation.service.IProduitService;
import fr.formation.service.IUserService;
import fr.formation.service.UserServiceImpl;
import fr.formation.util.Encrypt;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Resource(name="fournisseurService")
	private IFournisseurService fournisseurService;
	
	@Resource(name="produitService")
	private IProduitService produitService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		logger.info("IN : userAccueil");
		model.addAttribute("loggedUser", new User());
		model.addAttribute("loginLoggedUser", null);
		model.addAttribute("roleLoggedUser", null);
		return "userAccueil";
	}
	
	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
	public String loginAction(User loggedUser, Model model, Integer idLoggedUser) {
		logger.info("IN loginAction -- utilisateur : " + loggedUser.getLogin());
		loggedUser=userService.getLoggedUser(loggedUser.getLogin(), loggedUser.getPassword());
		if (loggedUser==null) {
			model.addAttribute("message", "Login ou mot de passe incorrect");
			model.addAttribute("loggedUser",new User());
			model.addAttribute("loginLoggedUser", null);
			model.addAttribute("roleLoggedUser", null);
			return "userAccueil";
		}
		else {
			model.addAttribute("message","");
			model.addAttribute("idLoggedUser", loggedUser.getId());
			model.addAttribute("loggedUser", loggedUser);
			List<User> listU = userService.listerUser();
			model.addAttribute("listeuser", listU);		
			List<Fournisseur> listF = fournisseurService.listerFourn();
			model.addAttribute("listefournisseur", listF);
			List<Produit> listP = produitService.listerProduit();
			model.addAttribute("listeproduit", listP);
			if (loggedUser.getRole().equals("ADMIN")) {
				return "gestionuser";
			}
			else return "gestionprod";
			
		}
	}
	
	@RequestMapping(value="/disconnect", method=RequestMethod.GET)
	public String disconnect(Model model) {
		logger.info("IN disconnect : ");
		model.addAttribute("message", "Vous avez bien été déconnecté ! A bientôt !");
		model.addAttribute("loggedUser", new User());
		model.addAttribute("loginLoggedUser", null);
		model.addAttribute("roleLoggedUser", null);
		return "userAccueil";
	}
	
	@RequestMapping(value="/ajoutUser", method=RequestMethod.POST)
	public String ajouterUser(User user, Integer idLoggedUser, Model model) {
		Encrypt e = new Encrypt();
		String pwd=e.hashPwd(user.getPassword());
		user.setPassword(pwd);
		model.addAttribute("user", user);
		model.addAttribute("idLoggedUser", idLoggedUser);
		logger.info("QUI EST MON USER LOGGER ?" + idLoggedUser);
		User loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("message", "Utilisateur ajouté");
		userService.ajouterUser(user);
		List<User> listU = userService.listerUser();
		model.addAttribute("listeuser", listU);
		return "gestionuser";
	}
	
	@RequestMapping(value="/deletUser", method=RequestMethod.POST)
	public String deletUser(Integer idu, Integer idLoggedUser, Model model, User loggedUser) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		model.addAttribute("message", "Utilisateur supprimé");
		userService.supprimerUser(idu);
		List<User> listU = userService.listerUser();
		model.addAttribute("listeuser", listU);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		return "gestionuser";
	}
	
	@RequestMapping(value="/modifyUser", method=RequestMethod.POST)
	public String modifyUser(Integer idu, Integer idLoggedUser, Model model) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		User user1 = userService.getUnUser(idu);
		logger.info(user1);
		model.addAttribute("user1", user1);
		User loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		List<User> listU = userService.listerUser();
		model.addAttribute("listeuser", listU);
		return "gestionuser2";
	}
	
	@RequestMapping(value="/modifierUser", method=RequestMethod.POST)
	public String modifierUser(User user1, Integer idLoggedUser, Model model, User loggedUser) {
		Encrypt e = new Encrypt();
		String pwd=e.hashPwd(user1.getPassword());
		user1.setPassword(pwd);
		model.addAttribute("message", "Utilisateur mis à jour");
		userService.modifierUser(user1);
		model.addAttribute("user1", user1);
		List<User> listU = userService.listerUser();
		model.addAttribute("listeuser", listU);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("idLoggedUser", idLoggedUser);
		return "gestionuser";
	}
	
}
