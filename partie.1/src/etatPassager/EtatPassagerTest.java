package etatPassager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import etatPassager.EtatPassager.Etat;

/**
 * Classe de test pour la classe EtatPassager.
 * <p>
 * Cette classe teste les différentes fonctionnalités de la classe EtatPassager,
 * y compris les états d'un passager (DEHORS, ASSIS, DEBOUT) et leurs comportements.
 * </p>
 */
public class EtatPassagerTest implements IEtatPassagerTest{
	
	/** Instance de EtatPassager pour représenter un passager dehors. */
	EtatPassager passager1;
    
    /** Instance de EtatPassager pour représenter un passager assis. */
    EtatPassager passager2;
    
    /** Instance de EtatPassager pour représenter un passager debout. */
    EtatPassager passager3;
    
    /** Instanciation d'un passager
	 * 
	 * @return un passager debout de type EtatPassager qui est un sous type IEtatPassager
	 */
    public EtatPassager creerDebout() {
    	return new EtatPassager(Etat.DEBOUT);
    }
    
    /** Instanciation d'un passager
	 * 
	 * @return un passager assis de type EtatPassager qui est un sous type IEtatPassager
	 */
    public EtatPassager creerAssis() {
    	return new EtatPassager(Etat.ASSIS);
    }
    
    /** Instanciation d'un passager
	 * 
	 * @return un passager dehors de type EtatPassager qui est un sous type IEtatPassager
	 */
    public EtatPassager creerDehors() {
    	return new EtatPassager(Etat.DEHORS);
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
		passager1 = creerDehors();
		passager2 = creerAssis();
		passager3 = creerDebout();
	}

	/**
     * Nettoyage après les tests.
     * <p>
     * Cette méthode est exécutée après chaque test pour libérer les ressources.
     * </p>
     */
	@After
	public void tearDown() throws Exception {
		passager1 = null;
		passager2 = null;
		passager3 = null;
	}

	/**
     * Teste la création d'un passager.
     * <p>
     * Vérifie que l'instance de passager1 est correctement initialisée.
     * </p>
     */
	@Test
	public void testEtatPassager() {
		assertTrue("Le passager passager1 est pas définit", passager1!=null);
	}

	/**
     * Teste si le passager est à l'extérieur.
     * <p>
     * Vérifie que passager1 est en dehors.
     * </p>
     */
	@Test
	public void testEstExterieur() {
		assertTrue("Le passager 1 devrait être à l'extérieur", (!passager1.estAssis() && !passager1.estDebout() && passager1.estExterieur()));
	}

	/**
     * Teste si le passager est assis.
     * <p>
     * Vérifie que passager2 est assis.
     * </p>
     */
	@Test
	public void testEstAssis() {
		assertTrue("Le passager devrait être assis", (passager2.estAssis() && !passager2.estDebout() && !passager2.estExterieur()));
	}
	
	/**
     * Teste si le passager est debout.
     * <p>
     * Vérifie que passager3 est debout.
     * </p>
     */
	@Test
	public void testEstDebout() {
		assertTrue("Le passager devrait être debout", (!passager3.estAssis() && passager3.estDebout() && !passager3.estExterieur()));
	}

	/**
     * Teste si le passager est à l'intérieur.
     * <p>
     * Vérifie que passager1 n'est pas à l'intérieur, tandis que passager2 et passager3 le sont.
     * </p>
     */
	@Test
	public void testEstInterieur() {
		
		assertTrue("Le passager devrait être à l'interieur", !passager1.estInterieur() && passager2.estInterieur() && passager3.estInterieur() );
	}
	
	/**
     * Teste la représentation sous forme de chaîne du passager.
     * <p>
     * Vérifie que la méthode toString() renvoie la chaîne attendue pour passager1.
     * </p>
     */
	@Test
	public void testToString() {
		String resultat_attendu = "<" +Etat.DEHORS+ ">";
		assertEquals("La représentation sous forme de chaine est différente de ce qui a été définie", resultat_attendu, passager1.toString());
	}

}
