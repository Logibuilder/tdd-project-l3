package etatPassager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import etatPassager.EtatPassagerMonter.Etat;

/**
 * Classe de test pour la classe EtatPassagerMonter.
 * <p>
 * Cette classe teste les différentes fonctionnalités de la classe EtatPassagerMonter,
 * y compris les états d'un passager (ASSIS, DEBOUT) et leurs comportements.
 * </p>
 */
public class EtatPassagerMonterTest implements IEtatPassagerTest{

	/** Instance de EtatPassagerMonter pour représenter un passager assis. */
	EtatPassagerMonter passagerAssis;

	/** Instance de EtatPassagerMonter pour représenter un passager debout. */
	EtatPassagerMonter passagerDebout;

	/** Instance de EtatPassagerMonter pour représenter un passager debout. */
	EtatPassagerMonter passagerDehors;

	/** Instanciation d'un passager
	 * 
	 * @return un passager debout de type EtatPassagerMonter qui est un sous type IEtatPassager
	 */
	public EtatPassagerMonter creerDebout() {
		return new EtatPassagerMonter(Etat.DEBOUT);
	}
	
	/** Instanciation d'un passager
	 * 
	 * @return un passager assis de type EtatPassagerMonter qui est un sous type IEtatPassager
	 */
	public EtatPassagerMonter creerAssis() {
		return new EtatPassagerMonter(Etat.ASSIS);
	}
	
	/** Instanciation d'un passager
	 * 
	 * @return un passager dehors de type EtatPassagerMonter qui est un sous type IEtatPassager
	 */
	public EtatPassagerMonter creerDehors() {
		return null;
	}

	/**
	 * Préparation des tests.
	 * <p>
	 * Cette méthode est exécutée avant chaque test pour initialiser les passagers
	 * avec différents états.
	 * </p>
	 */
	@Before
	public void setUp() throws Exception {
		passagerAssis = creerAssis();
		passagerDebout = creerDebout();
		passagerDehors = creerDehors();
	}

	/**
	 * Nettoyage après les tests.
	 * <p>
	 * Cette méthode est exécutée après chaque test pour libérer les ressources.
	 * </p>
	 */
	@After
	public void tearDown() throws Exception {
		passagerAssis = null;
		passagerDebout = null;
	}

	/**
	 * Teste la création d'un passager.
	 * <p>
	 * Vérifie que l'instance de passagerAssis est correctement initialisée.
	 * </p>
	 */
	@Test
	public void testEtatPassager() {
		assertNotNull("Le passager assis n'est pas défini", passagerAssis);
	}

	/**
	 * Teste qu'il n'y ait pas de passager dehors
	 */
	@Test
	public void testPassagerDehors() {
		assertNull("Le passager ne doit pas être dehors",passagerDehors);
	}

	/**
	 * Teste si le passager est assis.
	 * <p>
	 * Vérifie que passagerAssis est assis.
	 * </p>
	 */
	@Test
	public void testEstAssis() {
		assertTrue("Le passager devrait être assis", (passagerAssis.estAssis() && !passagerAssis.estDebout()));
	}

	/**
	 * Teste si le passager est debout.
	 * <p>
	 * Vérifie que passagerDebout est debout.
	 * </p>
	 */
	@Test
	public void testEstDebout() {
		assertTrue("Le passager devrait être debout", (!passagerDebout.estAssis() && passagerDebout.estDebout()));
	}

	/**
	 * Teste si le passager est à l'intérieur.
	 * <p>
	 * Vérifie que passagerAssis et passagerDebout sont tous deux à l'intérieur.
	 * </p>
	 */
	@Test
	public void testEstInterieur() {
		assertTrue("Les passagers devraient être à l'intérieur", passagerAssis.estInterieur() && passagerDebout.estInterieur());
	}

	/**
	 * Teste la représentation sous forme de chaîne du passager.
	 * <p>
	 * Vérifie que la méthode toString() renvoie la chaîne attendue pour passagerAssis.
	 * </p>
	 */

	/**
	 * teste qu'il n'y ait pas de passager à l'extérieur
	 */
	@Test
	public void testEstExterieur() {
		assertFalse("Le passager passagerAssis ne doit pas être à l'extérieur",passagerAssis.estExterieur());
	}

	@Test
	public void testToString() {

		String resultatAttendu = "<" + Etat.ASSIS + ">";
		assertEquals("La représentation sous forme de chaîne est différente de ce qui a été définie", resultatAttendu, passagerAssis.toString());
	}
}
