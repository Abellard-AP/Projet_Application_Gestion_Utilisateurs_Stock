package fr.formation.controller.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.entity.Produit;
import fr.formation.service.IProduitService;

@RestController
public class RestProductController {
	
	@Resource(name="produitService")
	private IProduitService produitService;
	
	@RequestMapping(value="/products",
			method=RequestMethod.GET,
			headers = "Accept=application/json")
	@CrossOrigin
	public List<Produit> getproduct(){
		List<Produit>listProducts = produitService.listerProduit();
		return listProducts;
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@CrossOrigin 
	public Produit getCountryById(@PathVariable int id) {
		return produitService.getUnProduit(id);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST, headers = "Accept=application/json")
	@CrossOrigin 
	public void addCountry(@RequestBody Produit product) {
		produitService.ajouterProduit(product);
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT, headers = "Accept=application/json")
	@CrossOrigin 
	public void updateCountry(@RequestBody Produit product) {
		produitService.modifierProduit(product);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	@CrossOrigin 
	public void deleteCountry(@PathVariable("id") int id) {
		produitService.supprimerProduit(id);
	}

	
	public IProduitService getProductService() {
		return produitService;
	}

	public void setProductService(IProduitService produitService) {
		this.produitService = produitService;
	} 

}
