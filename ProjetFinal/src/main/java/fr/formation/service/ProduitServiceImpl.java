package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IProduitDAO;
import fr.formation.dao.entity.Produit;

@Service(value="produitService")
public class ProduitServiceImpl implements IProduitService {
	
	@Autowired
	private IProduitDAO pdao;

	@Override
	public List<Produit> listerProduit() {
		return pdao.listeAllProduit();
	}

	@Override
	public Produit getUnProduit(int id) {
		return pdao.retrouverProduit(id);
	}

	@Override
	public void ajouterProduit(Produit p) {
		pdao.ajouterUnProduit(p);

	}

	@Override
	public void modifierProduit(Produit p) {
		pdao.modifierUnProduit(p);
	}

	@Override
	public void supprimerProduit(int id) {
	Produit p = pdao.retrouverProduit(id);
	pdao.supprimerProduit(p);
	}

}
