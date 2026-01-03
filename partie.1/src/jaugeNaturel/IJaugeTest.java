package jaugeNaturel;
/**
 *L'interface IJaugeTest est une référence de type qui est utilisée 
 *pour spécifier toutes les méthodes qu'une classe de JaugeTest doit 
 *implémenter doit implémenter permettant ainsi à toutes 
 *les jaugeTest de partager leur comportements communs.
 */
public interface IJaugeTest{
	/**
	 * Crée une instance de jauge spécifique selon les paramètres fournis (min, max, départ).
	 * <p>
	 * Cette méthode permet de factoriser la création des jauges, qu'il s'agisse de jauges naturelles, distance, négative, ou réelle
	 * La méthode est publique afin de pouvoir être utilisée dans d'autres classes (du même package)de test.
	 * </p>
	 *
	 * @param min La valeur minimale (vigieMin) que la jauge peut prendre.
	 * @param max La valeur maximale (vigieMax) que la jauge peut prendre.
	 * @param depart La valeur de départ initiale de la jauge, indiquant sa position actuelle.
	 * @return Une instance de jauge correspondant à l'interface IJaugeTest 
	 */
	public IJauge creerJauge(long min, long max, long depart);
	/**
     * Initialise les instances de JaugeNaturel avant chaque test.
     */
	public void initialiser() throws Exception;
	/**
     * Nettoie les instances de JaugeNaturel après chaque test.
     */
	public void nettoyer() throws Exception;
	/**
     * Teste si la jauge est dans l'intervalle de vigie.
     */
	public void testDansIntervalle();
	/**
     * Teste le comportement de la jauge lors de l'incrémentation et de la décrémentation.
     */
	public void testDeplacer();
	 /**
     * Teste si la jauge est inférieure à l'intervalle.
     */
	public void testInferieurIntervalle();
	/**
     * Teste si la jauge est supérieure à l'intervalle.
     */
	public void testSuperieurIntervalle();
	/**
     * Teste si la jauge a une limite incohérente entre vigieMax et vigieMin.
     * L'état n'est pas cohérent du  tout cohérent,
     */
	public void testLimieVigieMaxinferieurVigieMin();
	/**
     * Teste le cas où max est égal à min.
     * L'état n'est pas cohérent du  tout cohérent,
     */
	public void testMaxegalMin();
	
	
}
