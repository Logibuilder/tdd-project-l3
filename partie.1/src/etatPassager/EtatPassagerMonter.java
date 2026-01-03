package etatPassager;

import etatPassager.EtatPassager.Etat;

/**
 * Cette classe représente l'état d'un passager lorsqu'il est à l'intérieur d'un transport.
 * Il y a deux états possibles pour un passager à l'intérieur :
 *  - ASSIS
 *  - DEBOUT
 * 
 * Les instances de cette classe sont des objets constants.
 */
public class EtatPassagerMonter implements IEtatPassager{
  /**
   * Définit les trois états possible d'un passager dans un transport.
   */
  public enum Etat {/** passager assis à l'intérieur */  ASSIS, 
                    /** passager debout à l'intérieur */ DEBOUT
  };

  private final Etat monEtat;

  /**
   * Construit une instance en précisant l'état du passager.
   * 
   * @param e  valeur de l'état.
   */
  public EtatPassagerMonter(Etat e) {
    monEtat = e;

    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }

  /**
   * Le passager est-il assis à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return monEtat == Etat.ASSIS;
  }

  /**
   * Le passager est-il debout à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
    return monEtat == Etat.DEBOUT;
  }

  /**
   * Le passager est-il a l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
    return (monEtat==Etat.ASSIS || monEtat==Etat.DEBOUT);
  }
  
  /** Le passager est-il à l'exterieur?
   * 
   * @return faux
   */
  public boolean estExterieur() {
	  return false;
  }


  /**
   * Cette méthode est heritée de la classe {@link java.lang.Object}.
   * Trés utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * <p> Un code par défaut est définit dans 
   * {@link java.lang.Object#toString() la classe Object} 
   * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
   *
   * Pour les chaînes de cararctéres, l'opérateur + correspond a la concaténation. 
   */
  @Override
  public String toString() {
	String s;
	//if etat ==DEHORS s ="dehors"
    return "<" + monEtat + ">";
  }
}