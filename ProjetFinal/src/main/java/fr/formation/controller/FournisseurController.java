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
public class FournisseurController {

	private static final Logger logger = Logger.getLogger(IFournisseurService.class);
	
	@Resource(name="fournisseurService")
	private IFournisseurService fournisseurService;
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Resource(name="produitService")
	private IProduitService produitService;
	
	@RequestMapping(value="/ajoutFournisseur", method=RequestMethod.POST)
	public String ajouterUser(Fournisseur fournisseur, Integer idLoggedUser, Model model) {
		model.addAttribute("fournisseur", fournisseur);
		model.addAttribute("idLoggedUser", idLoggedUser);
		User loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("message", "Fournisseur ajouté");
		fournisseurService.ajouterFourn(fournisseur);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		logger.info("LISTE DES FOURNISSEURS " + listF);
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		return "gestionfourni";
	}
	
	
	@RequestMapping(value="/deletFournisseur", method=RequestMethod.POST)
	public String deletUser(Integer idu, Integer idLoggedUser, Model model, User loggedUser) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		
		Fournisseur fourni1 = fournisseurService.getUnFourn(idu);
		
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		int test = 0;
		for (Produit produit : listP) {
			if (produit.getFournisseur().getId()==fourni1.getId()) {
				test=test+1;
			}
		}
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		if (test!=0) {
			model.addAttribute("message", "<strong id=warn>Ce fournisseur ne peut être supprimé, il fournit des produits</strong>");
		} else {
		fournisseurService.supprimerFourn(idu);
		model.addAttribute("message", "Fournisseur supprimé");
		}
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		return "gestionfourni";
	}
	
	@RequestMapping(value="/modifyFournisseur", method=RequestMethod.POST)
	public String modifyUser(Integer idu, Integer idLoggedUser, Model model) {
		model.addAttribute("idLoggedUser", idLoggedUser);
		Fournisseur fourni1 = fournisseurService.getUnFourn(idu);
		logger.info(fourni1);
		model.addAttribute("fournisseur", fourni1);
		User loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		logger.info("AI-JE BIEN RENVOYER MON FOURNISSEUR ? : "+fourni1);
		return "gestionfourni2";
	}
	
	@RequestMapping(value="/modifierFournisseur", method=RequestMethod.POST)
	public String modifierUser(Fournisseur fournisseur, Integer idLoggedUser, Model model, User loggedUser) {
		model.addAttribute("message", "Fournisseur mis à jour");
		logger.info("AI-JE BIEN RENVOYER MON FOURNISSEUR ? ET LA ? : "+fournisseur);
		//fournisseur.getAdresse().setAid(fournisseur.getId());
		//logger.info("AI-JE BIEN RENVOYER MON FOURNISSEUR ? ET MAINTENANT ? : "+fournisseur);
		fournisseurService.modifierFourn(fournisseur);
		model.addAttribute("fournisseur", fournisseur);
		logger.info("AIJE BIEN RENVOYER MON FOURNISSEUR ? : "+fournisseur);
		List<Fournisseur> listF = fournisseurService.listerFourn();
		model.addAttribute("listefournisseur", listF);
		List<Produit> listP = produitService.listerProduit();
		model.addAttribute("listeproduit", listP);
		loggedUser = userService.getUnUser(idLoggedUser);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("idLoggedUser", idLoggedUser);
		return "gestionfourni";
	}
	
	
}
