package etatPassager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test pour la classe EtatPassager.
 * <p>
 * Cette classe teste les différentes fonctionnalités de la classe EtatPassager,
 * y compris les états d'un passager (DEHORS, ASSIS, DEBOUT) et leurs comportements.
 * </p>
 */
public class EtatPassagerChaineTest implements IEtatPassagerTest{
	
	/** Instance de EtatPassager pour représenter un passager dehors. */
	EtatPassagerChaine passagerDehors;
    
    /** Instance de EtatPassager pour représenter un passager assis. */
	EtatPassagerChaine passagerAssis;
    
    /** Instance de EtatPassager pour représenter un passager debout. */
    
    EtatPassagerChaine passagerDebout;
    
    /** Instanciation d'un passager
	 * 
	 * @return un passager debout de type EtatPassagerChaine qui est un sous type IEtatPassager
	 */
    public EtatPassagerChaine creerDebout() {
    	return new EtatPassagerChaine(EtatPassagerChaine.DEBOUT);
    }
    
    /** Instanciation d'un passager
	 * 
	 * @return un passager assis de type EtatPassagerChaine qui est un sous type IEtatPassager
	 */
    public EtatPassagerChaine creerAssis() {
    	return new EtatPassagerChaine(EtatPassagerChaine.ASSIS);
    }
    
    /** Instanciation d'un passager
	 * 
	 * @return un passager dehors de type EtatPassagerChaine qui est un sous type IEtatPassager
	 */
    public EtatPassagerChaine creerDehors() {
    	return new EtatPassagerChaine(EtatPassagerChaine.DEHORS);
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
		passagerDehors = creerDehors();
		passagerAssis = creerAssis();
		passagerDebout = creerDebout();
	}

	/**
     * Nettoyage après les tests.
     * <p>
     * Cette méthode est exécutée après chaque test pour libérer les ressources.
     * </p>
     */
	@After
	public void tearDown() throws Exception {
		passagerDehors = null;
		passagerAssis = null;
		passagerDebout = null;
	}

	/**
     * Teste la création d'un passager.
     * <p>
     * Vérifie que l'instance de passager1 est correctement initialisée.
     * </p>
     */
	@Test
	public void testEtatPassager() {
		assertNotNull("Le passager passager1 est pas définit", passagerDehors);
	}

	/**
     * Teste si le passager est à l'extérieur.
     * <p>
     * Vérifie que passager1 est en dehors.
     * </p>
     */
	@Test
	public void testEstExterieur() {
		assertTrue("Le passager 1 devrait être à l'extérieur", (!passagerDehors.estAssis() && !passagerDehors.estDebout() && passagerDehors.estExterieur()));
	}

	/**
     * Teste si le passager est assis.
     * <p>
     * Vérifie que passager2 est assis.
     * </p>
     */
	@Test
	public void testEstAssis() {
		assertTrue("Le passager devrait être assis", (passagerAssis.estAssis() && !passagerAssis.estDebout() && !passagerAssis.estExterieur()));
	}
	
	/**
     * Teste si le passager est debout.
     * <p>
     * Vérifie que passager3 est debout.
     * </p>
     */
	@Test
	public void testEstDebout() {
		assertTrue("Le passager devrait être debout", (!passagerDebout.estAssis() && passagerDebout.estDebout() && !passagerDebout.estExterieur()));
	}

	/**
     * Teste si le passager est à l'intérieur.
     * <p>
     * Vérifie que passager1 n'est pas à l'intérieur, tandis que passager2 et passager3 le sont.
     * </p>
     */
	@Test
	public void testEstInterieur() {
		
		assertTrue("Le passager devrait être à l'interieur", !passagerDehors.estInterieur() && passagerAssis.estInterieur() && passagerDebout.estInterieur() );
	}
	
	/**
     * Teste la représentation sous forme de chaîne du passager.
     * <p>
     * Vérifie que la méthode toString() renvoie la chaîne attendue pour passager1.
     * </p>
     */
	@Test
	public void testToString() {
		String resultat_attendu = "<" +EtatPassagerChaine.DEHORS+ ">";
		assertEquals("La représentation sous forme de chaine est différente de ce qui a été définie", resultat_attendu, passagerDehors.toString());
	}

}
