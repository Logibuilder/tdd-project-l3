package tec;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import tec.EtatPassager.Etat;

import static org.junit.Assert.*;

public class PassagerStandardExceptionTest {

    private PassagerStandard passager;
    private Bus bus;
    private Transport transport;
    @Before
    public void setUp() {
        // Initialisation d'un passager et d'un bus avant chaque test
        passager = new PassagerStandard("Test", 5);
        bus = new Autobus(10, 5); // Bus avec 10 places assises et 5 debout
        transport = new Autobus(2, 5) ; 
    }

    @After
    public void tearDown() {
        passager = null;
        bus = null;
        transport = null;
    }

    /**
     * Teste si la méthode 'nouvelArret' lève une exception quand le bus est nul.
     */
    @Test(expected = NullPointerException.class)
    public void testNouvelArretNullBus() {
        passager.nouvelArret(null, 3); // Le bus ne doit pas être nul
    }

    /**
     * Teste si la méthode 'nouvelArret' lève une exception pour un numéro d'arrêt invalide.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNouvelArretNumeroArretInvalide() {
        passager.nouvelArret(bus, -1); // Le numéro d'arrêt doit être strictement positif
    }

    /**
     * Teste si la méthode 'nouvelArret' lève une exception lorsque l'arrêt a déjà été dépassé.
     */
    @Test(expected = IllegalStateException.class)
    public void testNouvelArretArretDepasse() {
        passager.nouvelArret(bus, 7); // L'arrêt 6 est supérieur à la destination (5)
    }

    /**
     * Teste si la méthode 'nouvelArret' fait sortir le passager lorsque l'arrêt correspond à la destination.
     */
    @Test
    public void testNouvelArretDestinationAtteinte() {
        passager.setEtat(new EtatPassager(Etat.ASSIS)); // Passager est assis
        passager.nouvelArret(bus, 5); // L'arrêt 5 est la destination
        assertTrue("Le passager doit être dehors", passager.estDehors()); // Le passager doit sortir
    }

    /**
     * Teste la méthode 'monterDans' pour vérifier l'exception UsagerInvalideException.
     */
    @Test(expected = UsagerInvalideException.class)
    public void testMonterDansTransportInvalide() throws UsagerInvalideException {
        Transport transportInvalide = new Transport() {}; // Un transport qui n'est pas un Autobus
        passager.monterDans(transportInvalide);
    }
}
