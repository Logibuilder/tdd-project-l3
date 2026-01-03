package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class AutobusTest {
	/**
	 * Cette methode est executée avant chaque test pour initialisé un autobus avant
	 * chaque test
	 * 
	 * @throws Exception si une erreur survient pendant l'initialisation.
	 */
	PassagerStandard passager, passager2, passager3, passager4;
	Autobus bus;

	@Before
	public void setUp() throws Exception {
		// initialisation des ressources avant chaque test
		passager = new PassagerStandard("Assane", 2);
		passager2 = new PassagerStandard("Oumou", 3);
		passager3 = new PassagerStandard("Myriame", 4);
		// passager4 = new PassagerStandard();
		bus = new Autobus(1, 2);
	}

	/**
	 * Cette methode est executée après chaque test pour liberer les ressources
	 * 
	 * @throws Exception si une erreur survient lors de la libération des ressources
	 */

	@After
	public void tearDown() throws Exception {
		// Libération des ressources après chaque test.
		passager = passager2 = passager3 = null;
		bus = null;
	}

	/**
	 * Test du contructeur de la classe Autobus. Verifie quel'objet Autobus est
	 * correctement initialisé.
	 */
	@Test
	public void testAutobus() {
		assertNotNull("Le passager n'est pas créé", bus);
	}

	/**
	 * Test de la methode {@code aPlaceAssise}. Verifie si l'autobus détecte
	 * correctement la disponibilité des places assises.
	 */
	@Test
	public void testAPlaceAssise() {
		assertEquals("", bus.aPlaceAssise(), bus.getJaugeAssise().estVert());
	}

	/**
	 * Test de la methode {@code aPlaceDebout}. Verifie si l'autobus détecte
	 * correctement la disponibilité des places debout.
	 */
	@Test
	public void testAPlaceDebout() {
		assertEquals("", bus.aPlaceDebout(), bus.getJaugeDebout().estVert());
	}

	/**
	 * Test de la méthode {@code demanderPlaceAssise}. Vérifie si une place assise
	 * peut être demandée et attribuée correctement.
	 */
	@Test
	public void testDemanderPlaceAssise() {
		bus.demanderPlaceAssise(passager);
		bus.demanderPlaceAssise(passager2);
		bus.demanderPlaceAssise(passager3);
		assertTrue(passager.estAssis());
		assertFalse(passager2.estAssis());
	}

	/**
	 * Test de la méthode {@code demanderPlaceDebout} Verifie si une place debout
	 * peut etre demandée et attribuée correctement.
	 */

	@Test 
	public void testDemanderPlaceDebout() {
		bus.demanderPlaceDebout(passager); 
		bus.demanderPlaceDebout(passager2);
		bus.demanderPlaceDebout(passager3); 
		assertTrue(passager.estDebout()); 
		assertTrue(passager2.estDebout()); 
		assertFalse(passager3.estDebout()); }

	/**
	 * Test la methode {@code demanderChangerEnDebout} Verifie si un passager peut
	 * changer d'une place assice à une place debout.
	 */

	@Test 
	public void testDemanderChangerEnDebout() { 
		// il etait assis, il existe encore de la place debout donc il peut changer de place
		bus.demanderPlaceAssise(passager); 
		bus.demanderChangerEnDebout(passager); 
		//il etait debout, donc il reste debout 
		bus.demanderPlaceDebout(passager2);
		bus.demanderChangerEnDebout(passager2); 
		// il etait assis, il n'existe plus de la place debout donc il ne peut pas changer de place
		bus.demanderPlaceAssise(passager3); 
		bus.demanderChangerEnDebout(passager3);

		assertTrue(passager.estDebout());
		assertTrue(passager2.estDebout());
		assertFalse(passager3.estDebout()); }

	/**
	 * Test la méthode {@code  demanderChangerEnsAssis} verifie si un passager peut
	 * changer une place débout en assis.
	 */

	@Test 
	public void testDemanderChangerEnAssis() { 
		// il a pris la seule placeassise qu'il y avait 
		bus.demanderPlaceDebout(passager2);
		bus.demanderChangerEnAssis(passager2);

		// Plus de place assise donc le message doit pas renvoyer accepter place assise 
		bus.demanderPlaceAssise(passager);
		bus.demanderChangerEnAssis(passager);

		assertTrue(passager2.estAssis());
		assertFalse(passager.estAssis()); }

	/**
	 * Test de la methode {@code demanderSortie} Verifie on utilise cette methode si
	 * un passager est dehors et s'il change d'état
	 */

	@Test 
	public void testDemanderSortie() { 

		// Un passager assis peut sortir 
		bus.demanderPlaceAssise(passager2);

		bus.demanderSortie(passager2);

		// Un passager debout peut sortir 
		
		bus.demanderPlaceDebout(passager3);

		bus.demanderSortie(passager3);

		assertTrue(passager2.estDehors());
		assertTrue(passager3.estDehors());

	}

	/**
	 * Test de la methode {@code allerArretSuivant} Verifie que l'autobus effectue
	 * correctement la trasition vers l'arret suivant
	 * 
	 * @throws UsagerInvalideException
	 */
	@Test 
	public void testAllerArretSuivant() throws UsagerInvalideException {
		
		bus.demanderPlaceAssise(passager);
		bus.demanderPlaceAssise(passager2);
		bus.demanderPlaceAssise(passager3);
		bus.allerArretSuivant();
		bus.allerArretSuivant();
		assertTrue(passager.estDehors());
		/*
		 * bus.allerArretSuivant(); assertTrue(passager2.estDehors());
		 * bus.allerArretSuivant(); assertTrue(passager3.estDehors());
		 */
		}

}
