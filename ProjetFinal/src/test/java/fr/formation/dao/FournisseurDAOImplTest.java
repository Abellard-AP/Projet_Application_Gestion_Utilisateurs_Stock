package fr.formation.dao;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.dao.entity.Adresse;
import fr.formation.dao.entity.Fournisseur;
import fr.formation.exception.FournisseurException;

public class FournisseurDAOImplTest {

	public final static Logger logger = Logger.getLogger(FournisseurDAOImpl.class);

	ApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
FournisseurDAOImpl fdao = (FournisseurDAOImpl) context.getBean("fournisseurDAO");

private Adresse adresse;
private Fournisseur f;


	@Before
	public void initAvantTest() {
		adresse = new Adresse("3, rue de la liberation", "37000", "Tours");
		f = new Fournisseur("ref-dell", "Dell", adresse);		
	}
	@After
	public void initApresTest() {
		adresse = null;
		adresse = null;
		
	}

	@Test
	public void testAjouterFournisseur() {
		logger.debug("Test ajout");
		try {
			fdao.ajouterFournisseur(f);
		} catch (FournisseurException e) {
			logger.debug(e);
		}
		logger.debug("Fin Test ajout");
	}

	@Test
	public void testModifierFournisseur() {
		logger.debug("Test Modifié");
		Adresse adresse2 = new Adresse(2,"5, rue de la liberation", "37000", "Tours");
		Fournisseur f2 = new Fournisseur(2,"ref-dell", "Dell", adresse2);
		
		try {
			fdao.modifierFournisseur(f);
		} catch (FournisseurException e) {
			logger.debug(e);
		}
		logger.debug("Fin Test Modifié");
	}

	@Test
	public void testSupprimerFournisseur() {
	}

	@Test
	public void testTrierParNomOrdreAsc() {
	}

}
