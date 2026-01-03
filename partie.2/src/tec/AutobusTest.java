package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutobusTest {
	/**
	 * Cette methode est executée avant chaque test pour initialisé un autobus avant chaque test
	 * @throws Exception si une erreur survient pendant l'initialisation.
	 */
	@Before
	public void setUp() throws Exception {
		
		// initialisation des ressources avant chaque test
	}
	
	/**
	 * Cette methode est executée après chaque test pour liberer les ressources
	 *  @throws Exception si une erreur survient lors de la libération des ressources
	 */

	@After
	public void tearDown() throws Exception {
		// Libération des ressources après chaque test.
	}

	/**
	 * Test du contructeur de la classe Autobus.
	 * Verifie quel'objet Autobus est correctement initialisé.
	 */
	@Test
	public void testAutobus() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test de la methode {@code aPlaceAssise}.
	 * Verifie si l'autobus détecte correctement la disponibilité des places assises.
	 */
	@Test
	public void testAPlaceAssise() {
		fail("Not yet implemented");
	}

	/**
	 * Test de la methode {@code aPlaceDebout}.
	 * Verifie si l'autobus détecte correctement la disponibilité des places debout.
	 */
	@Test
	public void testAPlaceDebout() {
		fail("Not yet implemented");
	}

	/**
	 * Test de la méthode {@code demanderPlaceAssise}.
	 * Vérifie si une place assise peut être demandée et attribuée correctement.
	 */
	@Test
	public void testDemanderPlaceAssise() {
		fail("Not yet implemented");
	}

	/**
	 * Test de la méthode {@code demanderPlaceDebout}
	 * Verifie si une place debout peut etre demandée et attribuée correctement.
	 */
	@Test
	public void testDemanderPlaceDebout() {
		fail("Not yet implemented");
	}

	/**
	 * Test la methode {@code demanderChangerEnDebout}
	 * Verifie si un passager peut changer d'une place assice à une place debout.
	 */
	@Test
	public void testDemanderChangerEnDebout() {
		fail("Not yet implemented");
	}

	/**
	 * Test la méthode {@code  demanderChangerEnsAssis}
	 * verifie si un passager peut changer une place débout en assis.
	 */
	@Test
	public void testDemanderChangerEnAssis() {
		fail("Not yet implemented");
	}

	/**
	 * Test de la methode {@code demanderSortie}
	 * Verifie on utilise cette methode si un passager est dehors et s'il change d'état
	 */
	@Test
	public void testDemanderSortie() {
		fail("Not yet implemented");
	}

	/**
	 * Test de la methode {@code allerArretSuivant}
	 * Verifie que l'autobus effectue correctement la trasition vers l'arret suivant
	 */
	@Test
	public void testAllerArretSuivant() {
		fail("Not yet implemented");
	}

}
