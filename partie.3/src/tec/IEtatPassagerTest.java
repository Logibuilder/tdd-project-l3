//Auteur  : Oumou Tabara Diallo

package tec;

public interface IEtatPassagerTest{
	
	/** Instanciation d'un passager
	 * 
	 * @return un passager debout de type IEtatPassager
	 */
	public IEtatPassager creerDebout();
	
	/** Instanciation d'un passager
	 * 
	 * @return un passager assis de type IEtatPassager
	 */
	public IEtatPassager creerAssis();
	
	/** Instanciation d'un passager
	 * 
	 * @return un passager dehors de type IEtatPassager
	 */
	public IEtatPassager creerDehors();

	/**
     * Préparation des tests.
     * <p>
     * Cette méthode est exécutée avant chaque test pour initialiser les passagers
     * avec différents états.
     * </p>
     */
	public void setUp() throws Exception;
	
	/**
     * Nettoyage après les tests.
     * <p>
     * Cette méthode est exécutée après chaque test pour libérer les ressources.
     * </p>
     */
	public void tearDown() throws Exception;

	/**
     * Teste la création d'un passager.
     * <p>
     * Vérifie que l'instance d'un passager est correctement initialisée.
     * </p>
     */
	public void testEtatPassager();

	/** Etat dehors après instanciation.
	 * 
	 * A vérifier :

	 * estExterieur() retourne vrai.

	 * estAssis() retourne faux.

	 * estDebout() retourne faux.
	 */
	public void testEstExterieur();

	/**Etat assis après instanciation.
	 * 
	 * A vérifier :

	 * estExterieur() retourne faux.

	 * estAssis() retourne vrai.

	 * estDebout() retourne faux.
	 */
	public void testEstAssis();

	/** Etat debout après instanciation.
	 * 
	 * A vérifier :

	 * estExterieur() retourne faux.

	 * estAssis() retourne faux.

	 * estDebout() retourne vrai. 
	 */
	public void testEstDebout();

	/** Etat intérieur après instanciation.
	 * 
	 * Instanciation avec ASSIS A vérifier :

	 * estInterieur() retourne vrai.

	 * Instanciation avec DEBOUT A vérifier :

	 * estInterieur() retourne vrai.

	 * Instanciation avec DEHORS A vérifier :

	 * estInterieur() retourne faux.
	 */
	public void testEstInterieur();

}
