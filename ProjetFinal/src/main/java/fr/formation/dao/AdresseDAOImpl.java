package fr.formation.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.formation.dao.entity.Adresse;

@Repository(value = "adresseDAO")
public class AdresseDAOImpl implements IAdresseDAO {

	private static final Logger logger = Logger.getLogger(FournisseurDAOImpl.class);

	@Resource(name = "hibernate5AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void ajouterAdresse(Adresse adresse) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		logger.info("Ajout Adresse en cours");
		session.save(adresse);
		tx.commit();
		logger.info("Ajout Fournisseur " + adresse.getVoirie() + " " + adresse.getCodePostal() + " "
				+ adresse.getVille() + " effectué");
		session.close();

	}

	@Override
	public void modifierAdresse(Adresse adresse) {
		logger.info("Entrée dans retrouverAdresse :");
		logger.debug("modification de Adresse  ");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		logger.info("Modification Adresse en cours");
		session.update(adresse);
		tx.commit();
		session.close();
		logger.debug("Adresse Modifiée : " );
		logger.info("Sortie de modifierAdresse :");

	}

	@Override
	public Adresse retrouverAdresse(int id) {
		logger.info("Entrée dans retrouverAdresse :");
		logger.debug("recherche de Adresse avec id  de " + id);
		Session session = sessionFactory.openSession();
		Adresse a = session.get(Adresse.class,id);
		session.close();
		logger.debug("Adresse récupérée : " );
		logger.info("Sortie de retrouverAdresse :");
		return a;
	}

}
