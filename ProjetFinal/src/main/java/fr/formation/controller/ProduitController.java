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
public class ProduitController {

	private static final Logger logger = Logger.getLogger(IProduitService.class);
	
	@Resource(name="fournisseurService")
	private IFournisseurService fournisseurService;
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Resource(name="produitService")
	private IProduitService produitService;
	
	@RequestMapping(value="/ajoutProduit", method=RequestMethod.POST)
	public String ajouterUser(Produit produit, Integer idLoggedUser, Model model) {
		logger.info("ICI !!!!!!!!!!!!!!!!!" + produit);
		
		produitService.ajouterProduit(produit);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		List<Produit> listP = produitService.listerProduit();
		User loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("produit", produit);
		model.addAttribute("idLoggedUser", idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("message", "Produit ajouté");
		model.addAttribute("listefournisseur", listF);
		model.addAttribute("listeproduit", listP);
		return "gestionprod";
	}
	
	
	@RequestMapping(value="/deletProduit", method=RequestMethod.POST)
	public String deletUser(Integer idu, Integer idLoggedUser, Model model, User loggedUser) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		model.addAttribute("message", "Produit supprimé");
		produitService.supprimerProduit(idu);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		return "gestionprod";
	}
	
	@RequestMapping(value="/modifyProduit", method=RequestMethod.POST)
	public String modifyUser(Integer idu, Integer idLoggedUser, Model model) {
		logger.info("ICI !!!!!!!!!!!!!!!!!" + idu);	
		model.addAttribute("idLoggedUser", idLoggedUser);
		Produit produit = produitService.getUnProduit(idu);
		logger.info("ICI !!!!!!!!!!!!!!!!!" + produit);
		
		model.addAttribute("produit", produit);
		User loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		return "gestionprod2";
	}
	
	@RequestMapping(value="/modifierProduit", method=RequestMethod.POST)
	public String modifierUser(Produit produit, Integer idLoggedUser, Model model, User loggedUser) {
		logger.info("ICI !!!!!!!!!!!!!!!!!" + produit);
		model.addAttribute("message", "Produit mis à jour");
		produitService.modifierProduit(produit);
		model.addAttribute("produit", produit);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("idLoggedUser", idLoggedUser);
		return "gestionprod";
	}
	
	
}
