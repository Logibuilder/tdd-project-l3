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

		if (max<=min)  {
			throw new IllegalArgumentException();
		}
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
	 * 
	 */
	@Test //(expected=IllegalArgumentException.class)
	public void testCreationNonValide() {
		// une seule exception est levée parce qu'il ya eu seul test, dès qu'on trouve une seule exeption on sort du test
		/*
		 * Pourquoi faut-il deux blocs try/catch  pour sassurer que l exception est bien levee dans
 			tous les cas dinstanciation invalide.
		 * 
		 * Reponse : C'est pour s'assurer qu'il vérifie les exceptions car dans un meme bloc dès qu'il trouve une exception il sort.
		 * 
		 * Quelle est la valeur des variables inverse, egale dans la partie catch?
		 * 
		 * Reponse : les deux variables doivent être nulles car il ya des levées d'exception
		 * 
		 * Comment declarer les variables pour les utiliser a la fois dans la clause try et la clause catch?
		 * 
		 * Reponse : A l'extérieur des deux blocs
		 * p*/
		
		IJauge inverse = null, egale=null;
		try {
			inverse = creerJauge(78, 13, 0);
			//IJauge egale = creerJauge( 45, 45, 45);
		}catch (IllegalArgumentException e){
			//System.out.println("Exception capturée ");
			assertNull(inverse);

		}
		try {
			//IJauge inverse = creerJauge(78, 13, 0);
			egale = creerJauge( 45, 45, 45);
		}catch (IllegalArgumentException e){
			//System.out.println("Exception capturée ");
			assertNull(egale);

		}
		
		

	}
	
	/*
	 * Donner la classe de base de cette exception?
	 * Reponse : La classe de base de cette exception est RuntimeException
	 * 
	 * Explication du resultat : 
	 * Reponse : l'exception a bien été levée et le test marche car RuntimeException est la classe de bas
	 * de toutes les exceptions non vérifiées, le compilateur ne cherche pas à déclarer ou capturer cette exception.
	 * Si par contre le test est appelé sans spécifié l'exception attendue, le test va échouer (expected = NullPointerException.class).
	 * 
	 * 
	 * Remplacons l'exception dans le code precedent par une instance de la classe ClassNotFoundException.
	 * 
	 * Pourquoi cette exception est-elle controlee et pas la precedente?
	 * 
	 * Reponse : parce que ClassNotFoundException hérite de la classe 
	 * Exception qui est une classe de base pour les exceptions vérifiées
	 * Cette fois, le compilateur nous oblige soit à déclarer l'exception
	 * en rajoutant throws ClassNotFoundException soit à la capturer dans le bloc try/catch 
	 * */
	
	@Test(expected = ClassNotFoundException.class)
	 public void testExceptionControlee() throws ClassNotFoundException {
		
		throw new ClassNotFoundException( "Attention");
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
