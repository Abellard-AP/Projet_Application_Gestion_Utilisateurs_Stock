package fr.formation.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.dao.entity.Adresse;
import fr.formation.dao.entity.Fournisseur;
import fr.formation.exception.FournisseurException;

@Repository(value="fournisseurDAO")
public class FournisseurDAOImpl implements IFournisseurDAO{

	private static final Logger logger = Logger.getLogger(FournisseurDAOImpl.class); 
	
	@Resource(name="hibernate5AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	@Autowired
	AdresseDAOImpl adao;
	
	

	@Override
	public void ajouterFournisseur(Fournisseur fournisseur) throws FournisseurException {
		
		
		logger.info("Ajout Fournisseur en cours");
		if (fournisseur == null || fournisseur.getNom() == null || fournisseur.getReference() == null
				|| fournisseur.getAdresse().getCodePostal().trim().length() > 5
				|| fournisseur.getAdresse().getCodePostal().trim().length() <= 0
				|| fournisseur.getAdresse().getVille().trim().length() <= 0
				|| fournisseur.getAdresse().getVoirie().trim().length() <= 0) {
			logger.info("Erreur ajout Fournisseur");
			throw new FournisseurException("Fournisseur non conforme");
		} else {
			
			Adresse adresse = fournisseur.getAdresse();
			adao.ajouterAdresse(adresse);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(fournisseur);
			tx.commit();
			logger.info("Ajout Fournisseur " + fournisseur.getNom()+" effectué");
			session.close();
		}
	}

	@Override
	public void modifierFournisseur(Fournisseur fournisseur) throws FournisseurException {
		
		
		// Test métier !!!
		logger.info("Modification Fournisseur en cours");
		if (retrouverFournisseur(fournisseur.getId()) != null) {
			Adresse adresse = fournisseur.getAdresse();
			adao.modifierAdresse(adresse);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction(); 
			session.update(fournisseur);
			tx.commit();
			session.close();
			logger.info("Modification du Fournisseur"+ fournisseur.getNom());
		} else {logger.info("tentative de modification d'un Fournisseur non enregistré" + fournisseur.getNom());
			throw new FournisseurException("Fournisseur inconnu veuillez l'ajouter avant de le modifier.");	
		}
	}
	
	@Override
	public void supprimerFournisseur(Fournisseur f) {
		logger.info("Suppression Fournisseur en cours");
		Fournisseur ftemp = f;
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction(); 
		session.delete(f);
		tx.commit();
		logger.info("Suppression du Fournisseur : " + ftemp.getNom() +" effectuée");
	}

	@Override
	public Fournisseur retrouverFournisseur(int id) {
		logger.info("Entrée dans retrouverFournisseur :");
		logger.debug("recherche du fournisseur avec id  de " + id);
		Session session = sessionFactory.openSession();
		Fournisseur f = session.get(Fournisseur.class,id);
		session.close();
		logger.debug("Fournisseur trouvé : " + f.getNom());
		logger.info("Sortie de retrouverFournisseur :");
		return f;
		
		
	}

	@Override
	public List<Fournisseur> listeAllFournisseur() {
		Session session = sessionFactory.openSession();
		List<Fournisseur> listeFournisseurs = (List<Fournisseur>) session.createQuery("from Fournisseur").list();
		session.close();
		return listeFournisseurs;
	}

}
