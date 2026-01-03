package jaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Classe de test pour la classe JaugeNaturel.
 * <p>
 * Cette classe teste les fonctionnalités de la classe JaugeDistance
 * pour s'assurer que les états de la jauge sont correctement gérés
 * et que les méthodes fonctionnent comme prévu.
 * </p>
 */
public class JaugeDistanceTest implements IJaugeTest{

	/**
	 * Cette méthode crée une nouvelle instance de JaugeDistance avec les paramètres spécifiés pour les tests.
	 *
	 */
	public JaugeDistance creerJauge(long min, long max, long depart) {
		return new JaugeDistance(min, max, depart);

	}
	JaugeDistance jauge1, jauge2, jauge3, jauge4, jauge5, jauge6, jauge7, jauge8, jauge9, jauge10, jauge11;

	/**
	 * Initialise les instances de JaugeDistance avant chaque test.
	 */
	@Before
	public void initialiser() throws Exception {
		jauge1 = creerJauge(95, 67899, 100);
		jauge2 = creerJauge(4,9, 6);
		jauge3 = creerJauge(30, 350, 15);
		jauge4 = creerJauge(68, 150, 68);
		jauge5 = creerJauge(15, 567, 733);
		jauge6 = creerJauge(56, 300, 300);
		jauge7 = creerJauge(0, 20, 10);
		jauge8 = creerJauge(40, 40, 60);//vigieMin = VigieMax < depart
		jauge9 = creerJauge(40, 40, 40);//vigieMin = VigieMax < depart
		jauge10 = creerJauge(30, 40, 20);//depart < vigieMin < VigieMax 
		jauge11 = creerJauge(30, 40, 30);//depart = vigieMin < VigieMax 
	}

	/**
	 * Nettoie les instances de JaugeDistance après chaque test.
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
		assertTrue("La valeur de départ est dans l'intervalle de vigie", !jauge4.estVert() && jauge4.estBleu() && !jauge4.estRouge());
		assertTrue("La valeur de départ est dans l'intervalle de vigie", !jauge6.estVert() && !jauge6.estBleu() && jauge6.estRouge());

	}

	/**
	 * Teste le comportement de la jauge lors de l'incrémentation et de la décrémentation.
	 * Tester l'incrémentation et la décrémentation dans les cas oû le jauge est bleu, vert et rouge
	 */
	@Test
	public void testDeplacer() {
		/**
		 * 
		 */

		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();

		boolean b1 = jauge2.estBleu() && !jauge2.estRouge() && !jauge2.estVert();//tester l'incrémentation au cas oû le jauge est bleu

		jauge2.incrementer();
		jauge2.incrementer();
		jauge2.incrementer();
		jauge2.incrementer();


		boolean b2 = !jauge1.estBleu() && !jauge1.estRouge() && jauge1.estVert();//tester l'incrémentation au cas oû le jauge est vert

		jauge1.incrementer();
		jauge1.incrementer();
		jauge1.incrementer();

		boolean b3 = !jauge1.estBleu() && !jauge1.estRouge() && jauge1.estVert(); //tester l'incrémentation au cas oû le jauge est vert


		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();
		jauge6.incrementer();

		boolean b4 = !jauge6.estBleu() && jauge6.estRouge() && !jauge6.estVert();//tester l'incrémentation au cas oû le jauge est rouge


		boolean b5 = jauge4.estBleu() && !jauge4.estRouge() && !jauge4.estVert();//tester l'incrémentation au cas oû le jauge est bleu


		jauge4.incrementer();
		jauge4.incrementer();
		jauge4.incrementer();
		jauge4.incrementer();
		jauge4.incrementer();
		jauge4.incrementer();


		boolean b6 = !jauge4.estBleu() && !jauge4.estRouge() && jauge4.estVert();

		for (int i = 0; i < 50; i++) {
			jauge4.decrementer();
		}

		boolean b66 = jauge4.estBleu() && !jauge4.estRouge() && !jauge4.estVert();//tester la décrémentation au cas oû le jauge est bleu

		boolean b7 = !jauge7.estBleu() && !jauge7.estRouge() && jauge7.estVert();//tester la décrémentation au cas oû le jauge est vert

		for (int i = 0; i < 300; i++) {
			jauge5.decrementer();
		}
		boolean b8 = !jauge5.estBleu() && jauge5.estRouge() && !jauge5.estVert();//tester la décrémentation au cas oû le jauge est rouge

		assertTrue(b7);

		assertTrue("La valeur de départ n'est pas dans l'intervalle de vigie", b1 && b2 && b3 && b4 && b5 && b6 && b66 && b7 && b8);
	}

	/**
	 * Teste si la jauge est inférieure à l'intervalle.
	 */
	@Test
	public void testInferieurIntervalle() {
		/**
		 * 
		 */
		boolean b1  = jauge10.estBleu() && !jauge10.estRouge() && !jauge10.estVert();
		boolean b2 = jauge10.estBleu() && !jauge11.estRouge() && !jauge11.estVert();

		assertTrue("l'abscisse de la la position courante n'est pas n'est pas inférieure à celle de vigieMin ou celle de vigieMax", b1 && b2);

	}

	/**
	 * Teste si la jauge est supérieure à l'intervalle.
	 */
	@Test
	public void testSuperieurIntervalle() {
		/*
		 * 
		 */
		boolean b1  = !jauge6.estBleu() && jauge6.estRouge() && !jauge6.estVert();
		boolean b2 = !jauge5.estBleu() && jauge5.estRouge() && !jauge5.estVert();

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
		assertTrue(!jauge7.estBleu() && !jauge7.estRouge() && jauge7.estVert() );
	}


	/**
	 * Teste le cas où max est égal à min.
	 * L'état n'est pas cohérent du  tout cohérent,
	 */
	@Test
	public void testMaxegalMin() {

		boolean b1 = jauge9.estRouge();
		boolean b2 = jauge9.estBleu(); 

		assertTrue(b1 );
		assertTrue(b2);
	}
	/*
	 * Tester les duex distances diminuent de 1 si la position courante est à l'extérieure des deux vigies.
	 * et que D entre position courante et vigiemin diminue de 1 et D entre position courante et vigiemax augmente de 1
	 */
	@Test
	public void testDecrementer() {
		assertTrue(jauge2.estVert());
		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();
		jauge2.decrementer();
		assertTrue(jauge2.estBleu());
	}
	/**
	 * Teste la méthode toString pour vérifier la représentation en chaîne de l'état de la jauge.
	 */
	@Test
	public void testToString() {
		String resAttendu = "distance entre position courante et vegieMin: 5\n\ndistance entre position courante et vegieMax: 67799";
		assertEquals("La représentation sous forme de chaîne ne correspond pas à l'attendu.", resAttendu, jauge1.toString());
	}
}
