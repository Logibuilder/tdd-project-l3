package tec;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;


/**
 * Classe de test pour la classe PassagerStandard.
 * Elle vérifie les différents comportements et états des instances de PassagerStandard
 * dans divers scénarios.
 */
public class PassagerStandardTest {
    // Instances de PassagerStandard utilisées dans les tests.
	PassagerStandard   passagerDehors,passagerDehors1, passagerDehors2, passagerAssis, passagerDebout ;
	
    // États utilisés pour tester les transitions d'état des passagers.
	EtatPassager debout, assis;
	
	
    // Faux bus simulant différents scénarios de capacité.
	Autobus bus ;
	
	
	 /**
     * Méthode exécutée avant chaque test.
     * Elle initialise les objets nécessaires pour les tests.
     */
	@Before
	public void setUp() throws Exception {
		
		passagerDehors = new PassagerStandard ("Assane", 2);
		passagerDehors1 = new PassagerStandard ("Assane1", 2);
		passagerDehors2 = new PassagerStandard ("Assane2", 2);

		
		passagerDebout = new PassagerStandard ("Oumou", 3);
		
		passagerAssis = new PassagerStandard ("Tabara", 4);
		
		debout = new EtatPassager(Etat.DEBOUT);
		assis = new EtatPassager(Etat.ASSIS);
		
		passagerDebout.setEtat(debout);
		passagerAssis.setEtat(assis);
		
		bus  = new Autobus(1,1);
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		passagerDehors = passagerAssis =passagerDebout = null;
		debout = assis = null;
		
		bus =  null;
		
	}
	/**
	 *Test du constructeur de PassagerStandard.
	 * verifier que les passagerStandards instanciés au niveau du setUp ne sont pas nuls 
	 */
	@Test
	public void testPassagerStandard() {
		assertNotNull(passagerDebout);
		assertNotNull(passagerAssis);
		assertNotNull(passagerDehors);

	}
	/**
	 *Test de la méthode nom().
	 * verifier que la fonction nom retourne le nom d'un passger standard
	 */
	@Test
	public void testNom() {
		assertTrue( "Assane".equals(passagerDehors.nom()) && "Oumou".equals(passagerDebout.nom()) && "Tabara".equals(passagerAssis.nom()) && !"assane".equals(passagerDehors.nom()) && !"oumou".equals(passagerDebout.nom()) && !"tabara".equals(passagerAssis.nom()));
	}
	/**
	 * Test de la méthode estDehors().
	 * vérifier que la methode retourne vrai si le passagerStandard est instancié avec l'etat estDehors
	 */
	@Test
	public void testEstDehors() {
		assertTrue(passagerDehors.estDehors());
		assertFalse(passagerAssis.estDehors());
		assertFalse(passagerDebout.estDehors());
		assertFalse(passagerDehors.estAssis());
	}
	 /**
	 * Test de la méthode estEstAssis().
	 * vérifier que la methode retourne vrai si le passagerStandard est instancié avec l'etat estAssis
	 */
	@Test
	public void testEstAssis() {
		assertTrue(passagerAssis.estAssis());
		assertFalse(passagerAssis.estDehors());
		assertFalse(passagerDebout.estAssis());
		assertFalse(passagerDehors.estAssis());
	}
	/**
	 * Test de la méthode estEstDebout().
	 * vérifier que la methode retourne vrai si le passagerStandard est instancié avec l'etat estDebout
	 */
	@Test
	public void testEstDebout() {
		assertTrue(passagerDebout.estDebout());
		assertFalse(passagerAssis.estDebout());
		assertFalse(passagerDebout.estDehors());
		assertFalse(passagerDehors.estDebout());
	}
	/**
	 * Test de la méthode accepterSortie().
	 * Verifie, après avoir executer la méthode accepterSortie sur une instance passagerStandard, que l'état du passagerStandard est "DEHORS" 
	 */
	@Test
	public void testAccepterSortie() {
		passagerDebout.accepterSortie();
		passagerAssis.accepterSortie();
		assertTrue(passagerDehors.estDehors() &&  passagerDebout.estDehors() && passagerAssis.estDehors() && !passagerDebout.estDebout() && !passagerAssis.estAssis() && !passagerDebout.estAssis() && !passagerAssis.estDebout());
	}
	/**
	 * Test de la méthode accepterPlaceAssise().
	 * Verifie, après avoir executer la méthode accepterPlaceAssis sur une instance passagerStandard, que l'état du passagerStandard est "ASSIS" 
	 */
	@Test
	public void testAccepterPlaceAssise() {
		passagerDehors.accepterPlaceAssise();
		passagerDebout.accepterPlaceAssise();
		assertTrue(passagerAssis.estAssis() &&passagerDehors.estAssis() && passagerDebout.estAssis() && !passagerDehors.estDehors() && !passagerDebout.estDebout()  && !passagerDehors.estDebout() && !passagerDebout.estDebout());
	}
	/**
	 * Test de la méthode accepterPlaceDebout().
	 * Verifie, après avoir executer la méthode AccepterPlaceDebout sur une instance passagerStandard, que l'état du passagerStandard est "DEBOUT" 
	 */
	@Test
	public void testAccepterPlaceDebout() {
		passagerDehors.accepterPlaceDebout();
		passagerAssis.accepterPlaceDebout();
		assertTrue(passagerDebout.estDebout() && passagerDehors.estDebout() && passagerAssis.estDebout() && !passagerDehors.estDehors() && !passagerAssis.estDehors() && !passagerDehors.estAssis() && !passagerAssis.estAssis());
	}
	/**
	 * Teste la méthode nouvelArret().
	 * Vérifier que le passager descend du bus lorsqu'il atteint son arrêt de destination( numArret == numDestination).
	 * Vérifier que l'est du passagerStandard est cohérent après un changement de place ou de sortie de bus.
	 */
	@Test
	public void testNouvelArret() {
		passagerDehors.nouvelArret(bus, 2);
		passagerDebout.nouvelArret(bus, 3);
		passagerAssis.nouvelArret(bus, 4);

		//Le passager assis ne doit plus être assis mais doit être dehors car arrivé à sa destination
		assertFalse(passagerAssis.estAssis());
		assertTrue(passagerAssis.estDehors());
		//Le passager debout ne doit plus être debout mais doit être dehors car arrivé à sa destination
		assertFalse(passagerDebout.estDebout());
		assertTrue(passagerDebout.estDehors());
		//Le passager Dehors doit toujours être Dehors 
		assertTrue(passagerDehors.estDehors());
	}
	
	/**
	 * Test de la méthode monterDans().
	 * Vérifie que l'usager peut correctement monter dans un transport donné, 
	 * et que les exceptions sont levées lorsque l'état de l'usager est incohérent.
	 * @throws UsagerInvalideException
	 */
	@Test
	public void testMonterDans() throws UsagerInvalideException {
		// Les passagers tentent de monter dans le bus.
		passagerDehors.monterDans(bus);
		passagerDehors1.monterDans(bus);
		passagerDehors2.monterDans(bus);

		// Vérifier que le premier passager monté n'est plus à l'extérieur
	    // et qu'il a obtenu une place assise.
		assertFalse(passagerDehors.estDehors());// Il ne doit plus être à l'extérieur.
		assertTrue(passagerDehors.estAssis());// Il doit être assis.
		
		// Vérifier que le deuxième passager monté a une place debout.
		assertFalse(passagerDehors1.estDehors());
		assertTrue(passagerDehors1.estDebout());// Le deuxième passager doit être debout
		
		// Vérifier que le troisième passager reste à l'extérieur,
	    // car il n'y a plus de place disponible.
		assertTrue(passagerDehors2.estDehors());// Le troisième passager doit rester à l'extérieur.
		assertFalse(passagerDehors2.estAssis());// Il ne doit pas être assis.
		assertFalse(passagerDehors2.estDebout());// Il ne doit pas être debout.



	    }


}
