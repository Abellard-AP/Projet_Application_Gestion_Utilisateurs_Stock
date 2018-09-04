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


@Controller
public class MenuController {

	//private static final Logger logger = Logger.getLogger(User.class);
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Resource(name="fournisseurService")
	private IFournisseurService fournisseurService;
	
	@Resource(name="produitService")
	private IProduitService produitService;
	
	@RequestMapping(value = "/menuuser", method = RequestMethod.POST)
	public String menuUser(Integer idLoggedUser, Model model, User loggedUser) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		List<User> listU = userService.listerUser();
		model.addAttribute("listeuser", listU);
		return "gestionuser";
	}

	@RequestMapping(value = "/menufourni", method = RequestMethod.POST)
	public String menuFourni(Integer idLoggedUser, Model model, User loggedUser) {
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("idLoggedUser", idLoggedUser);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		return "gestionfourni";
	}
	
	@RequestMapping(value = "/menuprod", method = RequestMethod.POST)
	public String menuProd(Integer idLoggedUser, Model model, User loggedUser) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		return "gestionprod";
	}

	
	@RequestMapping(value="/exit", method=RequestMethod.POST)
	public String disconnect(Model model) {
		model.addAttribute("message", "Vous avez bien été déconnecté ! A bientôt !");
		model.addAttribute("loggedUser", new User());
		model.addAttribute("loginLoggedUser", null);
		model.addAttribute("roleLoggedUser", null);
		return "userAccueil";
	}
}
