//Auteur  : Oumou Tabara Diallo


package tec;

/*Cette interface permet de standardiser l’interaction avec 
 * les états possibles d’un passager, facilitant ainsi 
 * l’implémentation de la logique de gestion des passagers.
 */
public interface IEtatPassager {
	
	/**
	   * Le passager est-il à l'extérieur du transport ?
	   *
	   * @return vrai si instanciation avec DEHORS;
	   */
	public boolean estExterieur();
	
	/**
	   * Le passager est-il assis à l'intérieur du transport ?
	   *
	   * @return vrai si instanciation avec ASSIS;
	   */
	public boolean estAssis();
	
	/**
	   * Le passager est-il debout à l'intérieur du transport ?
	   *
	   * @return vrai si instanciation avec DEBOUT;
	   */
	public boolean estDebout();
	
	/**
	   * Le passager est-il a l'intérieur du transport ?
	   *
	   * @return vrai si instanciation avec ASSIS ou DEBOUT.
	   */
	public boolean estInterieur();
	
}
