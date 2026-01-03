package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutobusExceptionTest {

    private Autobus bus;
    private PassagerStandard passager;

    /**
     * Configuration avant chaque test : crée un autobus et un passager par défaut.
     */
    @Before
    public void setUp() {
        // Initialisation d'un autobus avec 1 place assise et 1 place debout pour chaque test
        bus = new Autobus(1, 1);
        passager = new PassagerStandard("Oumou", 1);
    }

    /**
     * Nettoyage après chaque test : réinitialisation des objets pour garantir des tests indépendants.
     */
    @After
    public void tearDown() {
        bus = null;
        passager = null;
    }

    /**
     * Teste si le constructeur lève une IllegalArgumentException lorsque le nombre de places assises est négatif.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructoeurNbPlacesAssisesNegatif() {
        new Autobus(-1, 10); // Doit lever IllegalArgumentException
    }

    /**
     * Teste si le constructeur lève une IllegalArgumentException lorsque le nombre de places debout est négatif.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNbPlacesDeboutNegatif() {
        new Autobus(10, -1); // Doit lever IllegalArgumentException
    }

    /**
     * Teste si la demande de place assise lève une IllegalStateException lorsque le passager est déjà assis.
     */
    @Test(expected = IllegalStateException.class)
    public void testDemanderPlaceAssiseException() {
        passager.accepterPlaceAssise(); // Simule un passager déjà assis
        bus.demanderPlaceAssise(passager); // Doit lever IllegalStateException car le passager est déjà assis
    }

    /**
     * Teste si la demande de place debout lève une IllegalStateException lorsque le passager est déjà debout.
     */
    @Test(expected = IllegalStateException.class)
    public void testDemanderPlaceDeboutException() {
        passager.accepterPlaceDebout(); // Simule un passager déjà debout
        bus.demanderPlaceDebout(passager); // Doit lever IllegalStateException car le passager est déjà debout
    }

    /**
     * Teste si le changement pour une place debout lève une IllegalStateException lorsque le passager est déjà debout.
     */
    @Test(expected = IllegalStateException.class)
    public void testDemanderChangerEnDeboutException() {
        passager.accepterPlaceDebout(); // Simule un passager déjà debout
        bus.demanderChangerEnDebout(passager); // Doit lever IllegalStateException car le passager est déjà debout
    }

    /**
     * Teste si le changement pour une place assise lève une IllegalStateException lorsque le passager est déjà assis.
     */
    @Test(expected = IllegalStateException.class)
    public void testDemanderChangerEnAssisException() {
        passager.accepterPlaceAssise(); // Simule un passager déjà assis
        bus.demanderChangerEnAssis(passager); // Doit lever IllegalStateException car le passager est déjà assis
    }

    /**
     * Teste si la demande de sortie lève une IllegalStateException lorsque le passager est déjà sorti.
     */
    @Test(expected = IllegalStateException.class)
    public void testDemanderSortieException() {
        passager.accepterSortie(); // Simule un passager déjà sorti
        bus.demanderSortie(passager); // Doit lever IllegalStateException car le passager est déjà sorti
    }

    /**
     * Teste si l'avance à l'arrêt suivant lève une UsagerInvalideException lorsque le passager est sorti de manière inattendue.
     */
    @Test(expected = UsagerInvalideException.class)
    public void testAllerArretSuivantException() throws UsagerInvalideException {
        bus.demanderPlaceAssise(passager); // Assigne une place au passager
        passager.accepterSortie(); // Simule que le passager est sorti de manière inattendue

        bus.allerArretSuivant(); // Doit lever UsagerInvalideException car le passager n'est plus dans le bus
    }
}
