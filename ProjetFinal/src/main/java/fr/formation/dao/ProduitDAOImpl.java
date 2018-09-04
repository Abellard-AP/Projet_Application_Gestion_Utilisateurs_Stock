package fr.formation.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.formation.dao.entity.Fournisseur;
import fr.formation.dao.entity.Produit;

@Repository(value="produitDAO")
public class ProduitDAOImpl implements IProduitDAO {
	
	@Resource(name="hibernate5AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(ProduitDAOImpl.class); 
	
	@Override
	public void ajouterUnProduit(Produit produit) {
		logger.info("Ajout Produit en cours");
		if (produit == null || produit.getReference() == null || produit.getDesignation() == null||produit.getPrix() ==null
				|| produit.getQuantite() < 0) {
			logger.info("Erreur ajout Produit");
//			throw new FournisseurException("Fournisseur non conforme");
		} else {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(produit);
			tx.commit();
			logger.info("Ajout Produit " + produit.getDesignation()+" effectué");
			session.close();
		}
	}

	@Override
	public void modifierUnProduit(Produit produit) {
		// Test métier !!!
				logger.info("Modification Produit en cours");
				if (retrouverProduit(produit.getId()) != null) {
					Session session = sessionFactory.openSession();
					Transaction tx = session.beginTransaction(); 
					session.update(produit);
					tx.commit();
					session.close();
					logger.info("Modification du produit"+ produit.getDesignation());
				} else {logger.info("tentative de modification d'un produit non enregistré" + produit.getDesignation());}

	}

	@Override
	public void supprimerProduit(Produit produit) {
		logger.info("Suppression Produit en cours");
		Produit ptemp = produit;
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction(); 
		session.delete(produit);
		tx.commit();
		logger.info("Suppression du Produit : " + ptemp.getDesignation() +" effectuée");
	}

	@Override
	public Produit retrouverProduit(int id) {
		logger.info("Entrée dans retrouverFournisseur :");
		logger.debug("recherche du fournisseur avec id  de " + id);
		Session session = sessionFactory.openSession();
		Produit p = session.get(Produit.class,id);
		session.close();
		logger.debug("Fournisseur trouvé : " + p.getDesignation());
		logger.info("Sortie de retrouverFournisseur :");
		return p;
	}

	@Override
	public List<Produit> listeAllProduit() {
		Session session = sessionFactory.openSession();
		List<Produit> listeProduits = (List<Produit>) session.createQuery("from Produit").list();
		session.close();
		return listeProduits;
	}

}
