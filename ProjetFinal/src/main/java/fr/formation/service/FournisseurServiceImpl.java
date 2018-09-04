package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IFournisseurDAO;
import fr.formation.dao.entity.Fournisseur;
import fr.formation.exception.FournisseurException;

@Service(value="fournisseurService")
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	private IFournisseurDAO fdao;
	
	@Override
	public List<Fournisseur> listerFourn() {
		return fdao.listeAllFournisseur();
	}

	@Override
	public Fournisseur getUnFourn(int id) {
		return fdao.retrouverFournisseur(id);
	}

	@Override
	public void ajouterFourn(Fournisseur f) {
		try {
			fdao.ajouterFournisseur(f);
		} catch (FournisseurException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifierFourn(Fournisseur f) {
		try {
			fdao.modifierFournisseur(f);
		} catch (FournisseurException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void supprimerFourn(int id) {
		Fournisseur f = fdao.retrouverFournisseur(id);
		fdao.supprimerFournisseur(f);		
	}

}
