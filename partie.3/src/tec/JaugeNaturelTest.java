package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Classe de test pour la classe JaugeNaturel.
 * <p>
 * Cette classe teste les fonctionnalités de la classe JaugeNaturel
 * pour s'assurer que les états de la jauge sont correctement gérés
 * et que les méthodes fonctionnent comme prévu.
 * </p>
 */
public class JaugeNaturelTest implements IJaugeTest{
	
	/**
	 * Cette méthode crée une nouvelle instance de JaugeNaturel avec les paramètres spécifiés pour les tests.
	 *
	 */
	public JaugeNaturel creerJauge(long min, long max, long depart) {
		return new JaugeNaturel(min, max, depart);
		
	}
	JaugeNaturel jauge1, jauge2, jauge3, jauge4, jauge5, jauge6, jauge7, jauge8, jauge9;
	
	/**
     * Initialise les instances de JaugeNaturel avant chaque test.
     */
	@Before
	public void initialiser() throws Exception {
		jauge1 = creerJauge(-345, 67899, 100);
		jauge2 = creerJauge(4,50, 6);
		jauge3 = creerJauge(30, 350, 15);
		jauge4 = creerJauge(-68, 150, -68);
		jauge5 = creerJauge(15, 567, 733);
		jauge6 = creerJauge(56, 300, 300);
		jauge7 = new JaugeNaturel(89, 56, 60);
		jauge8 = new JaugeNaturel(40, 40, 60);
		jauge9 = new JaugeNaturel(40, 40, 40);
	}
	
	/**
     * Nettoie les instances de JaugeNaturel après chaque test.
     */
	@After
	public void nettoyer() throws Exception {
		jauge1 = null;
		jauge2 = null;
		jauge3 = null;
		jauge4 = null;
		jauge5 = null;
		jauge6 = null;
		jauge7 = null;
		jauge8 = null;
		jauge9 = null;
		/*
		 * jaugeRouge = null; jaugeBleu = null;
		 */


	}
	
	/**
     * Teste si la jauge est dans l'intervalle de vigie.
     */
	@Test
	public void testDansIntervalle() {
		/**
		 * 
		 */
		assertTrue("La valeur de départ n'est pas dans l'intervalle de vigie", jauge1.estVert() && !jauge1.estBleu() && !jauge1.estRouge());
	}
	
	/**
     * Teste le comportement de la jauge lors de l'incrémentation et de la décrémentation.
     */
	@Test
	public void testDeplacer() {
		/**
		 * 
		 */
		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();

		boolean b1 = jauge2.estBleu() && !jauge2.estRouge() && !jauge2.estVert();

		jauge2.incrementer();
		jauge2.incrementer();

		boolean b2 = !jauge2.estBleu() && !jauge2.estRouge() && jauge2.estVert();

		assertTrue("La valeur de départ n'est pas dans l'intervalle de vigie", b1 && b2);

	}
	
	 /**
     * Teste si la jauge est inférieure à l'intervalle.
     */
	@Test
	public void testInferieurIntervalle() {
		/**
		 * 
		 */
		boolean b1  = jauge3.estBleu() && !jauge3.estRouge() && !jauge3.estVert();
		boolean b2 = jauge4.estBleu() && !jauge4.estRouge() && !jauge4.estVert();

		assertTrue("la valeur de départ n'est pas inf ou égale à la valeur de min", b1 && b2);

	}
	
	/**
     * Teste si la jauge est supérieure à l'intervalle.
     */
	@Test
	public void testSuperieurIntervalle() {
		/*
		 * 
		 */
		boolean b1  = !jauge5.estBleu() && jauge5.estRouge() && !jauge5.estVert();
		boolean b2 = !jauge6.estBleu() && jauge6.estRouge() && !jauge6.estVert();

		assertTrue("la valeur de départ n'est pas sup ou égale à la valeur de min", b1 && b2);
	}
	/**
     * Teste si la jauge a une limite incohérente entre vigieMax et vigieMin.
     * L'état n'est pas cohérent du  tout cohérent,
     */
	@Test
	public void testLimieVigieMaxinferieurVigieMin() {
		/*
		 * 
		 */
		assertTrue(jauge7.estBleu() && jauge7.estRouge());
	}
	

	/**
     * Teste le cas où max est égal à min.
     * L'état n'est pas cohérent du  tout cohérent,
     */
	@Test
	public void testMaxegalMin() {

		boolean b1 = jauge8.estRouge();
		boolean b2 = jauge9.estRouge() && jauge9.estBleu();

		assertTrue(b1 && b2);

	}
	
	/**
     * Teste la méthode toString de la jauge.
     */
	@Test 
	public void testToString() { 
		String res_attendu = "<100 [-345,67899]>";
		assertEquals("La représentation sous forme de chaîne ne correspond pas à l'attendu.", res_attendu, jauge1.toString()); 
	}

}
